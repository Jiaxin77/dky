package hci.dky.service.impl;



import hci.dky.common.ServerResponse;
import hci.dky.dao.HardwareMapper;
import hci.dky.pojo.Hardware;
import hci.dky.pojo.HardwareExample;
import hci.dky.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//硬件指标 - 对应参数评估部分

@Service
public class HardwareServiceImpl implements HardwareService {
    @Autowired
    private HardwareMapper hardwareMapper;


   //获取参数信息
   @Override
   @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getParam()
    {
        /**
         * @Author jiaxin
         * @Description //TODO
         * @Date 4:08 下午 2020/1/17
         * @Param []
         * @return com.example.demo.common.ServerResponse<java.util.ArrayList>
         **/

        HardwareExample hardwareExample = new HardwareExample();

        hardwareExample.setDistinct(false);
       // System.out.println(hardwareExample);

        List<Hardware> hardwares = hardwareMapper.selectByExample(hardwareExample);

        ArrayList<Object> hwList = new ArrayList<Object>();
        if(!hardwares.isEmpty())
        {
            for (Hardware hw:hardwares)
            {
                HashMap<String, Object> data = new HashMap<String, Object>();
                data.put("id",hw.getHardwareId());
                data.put("firstAssessObject",hw.getFirstObjectName());
                if (hw.getSecondObjectName()!=null)
                    data.put("secondAssessObject",hw.getSecondObjectName());
                data.put("firstIndex",hw.getFirstIndexName());
                data.put("secondIndex",hw.getSecondIndexName());
                data.put("unit",hw.getHardwareUnit());
                data.put("userValue",0);
                //未放二级指标
                //未放联动项
//                List<Hardware> linked = hw.getLinkedHardware();//联动项
//                ArrayList<Object> linkedHw = new ArrayList<Object>();
//                if(linked!= null)
//                {
//                    for (Hardware lhw:linked)
//                    {
//                        HashMap<String, Object> linkData = new HashMap<String, Object>();
//                        linkData.put("id",lhw.getHardwareId());
//                        linkData.put("firstAssessObject",lhw.getFirstAssessObject());
//                        linkData.put("secondAssessObject",lhw.getSecondAssessObject());
//                        linkData.put("firstIndex",lhw.getFirstIndex());
//                        linkedHw.add(linkData);
//                    }
//                    data.put("linkedHw",linkedHw);//加入联动项
//                }
                hwList.add(data);
            }
            return ServerResponse.createBySuccess("获取成功",hwList);
        }
        else
        {
            return ServerResponse.createByErrorMessage("获取失败，硬件参数列表为空！");
        }
    }


    //提交数值获取结果
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> postParamResult(List<Map<String,Object>> array)
    {
        //读取arrayList每个评估对象
        //调用每个评估对象的比较函数，得到每个评估对象的结果
        //返回结果列表
        if(array != null) {
            ArrayList<Object> allResult = new ArrayList<Object>();
            for (int i = 0; i < array.size(); i++) {
                //ArrayList<Object> hwResult = new ArrayList<Object>();
                HashMap<String,Object> hwResult = new HashMap<String, Object>();
                System.out.println(getType(array.get(i)));
                hwResult = compareParam(array.get(i));
                allResult.add(hwResult);
            }
            return ServerResponse.createBySuccess("评估成功", allResult);
        }
        else
        {
            return ServerResponse.createByErrorMessage("评估失败，提交列表为空！");
        }

    }

    //每个评估对象比较大小

    public HashMap<String,Object> compareParam(Object hw)
    {
        /**
         * @Author jiaxin
         * @Description //TODO 
         * @Date 7:14 下午 2020/1/17
         * @Param [hw]
         * @return java.util.HashMap<java.lang.String,java.lang.Object>
         **/
//
        HashMap<String,Object> result = new HashMap<String, Object>();
        Map entry = (Map)hw;
        String keyId = "id";
        Object id = entry.get(keyId);



        HardwareExample hardwareExample = new HardwareExample();
        HardwareExample.Criteria criteria = hardwareExample.createCriteria();
        criteria.andHardwareIdEqualTo(Long.valueOf(String.valueOf(id)));
        List<Hardware> hList=hardwareMapper.selectByExample(hardwareExample);

        if(!hList.isEmpty()) {
            Hardware thishardware = hList.get(0);


            //Hardware thishardware = hardwareMapper.findHardwareById((String)id);
            String keyUserValue = "userValue";
            Object userValue = entry.get(keyUserValue);
            BigDecimal userNum = new BigDecimal (userValue.toString());
            BigDecimal minNum = thishardware.getHardwareLower();
            System.out.println(minNum);
            BigDecimal maxNum = thishardware.getHardwareUpper();
            BigDecimal bestNum = thishardware.getHardwareBest();
            result.put("userValue", userNum);
            result.put("bestNum", bestNum);
            result.put("maxNum", maxNum);
            result.put("minNum", minNum);
            result.put("unit",thishardware.getHardwareUnit());
            result.put("otherStandard",thishardware.getOtherStandard());
            if(minNum!=null)
            {
                if(userNum.compareTo(minNum)!=-1)
                {
                    if(maxNum!=null)
                    {
                        if(userNum.compareTo(maxNum)!= 1)
                        {
                            result.put("result", 1);//符合
                        }
                        else
                        {
                            result.put("result", 0);//不符合
                        }
                    }
                    else
                    {
                        result.put("result", 1);//符合
                    }
                }
                else
                {
                    result.put("result", 0);//不符合
                }

            }
            else if (maxNum!=null)
            {

                if(userNum.compareTo(maxNum)!= 1)
                {
                    result.put("result", 1);//符合
                }
                else
                {
                    result.put("result", 0);//不符合
                }
            }
            else
            {
                result.put("result","无数值比较");
            }

//            if (userNum.compareTo(minNum)!=-1 && userNum.compareTo(maxNum)!= 1) {
//                result.put("result", 1);//符合
//            } else {
//                result.put("result", 0);//不符合
//            }
            result.put("id", thishardware.getHardwareId());
            result.put("firstAssessObject", thishardware.getSecondObjectName());
            result.put("secondAssessObject", thishardware.getSecondObjectName());
            result.put("firstIndex", thishardware.getFirstIndexName());
        }
        return result;
        
    }

    private static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }


}
