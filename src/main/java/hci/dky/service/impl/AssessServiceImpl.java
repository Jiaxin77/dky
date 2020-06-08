package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.IndexAndMethodMapper;
import hci.dky.dao.IndexLibraryMapper;
import hci.dky.dao.MethodLibraryMapper;
import hci.dky.pojo.*;
import hci.dky.service.AssessService;
import net.sf.jsqlparser.statement.create.table.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AssessServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/6/8 4:13 下午
 * @Version 1.0
 **/

@Service
public class AssessServiceImpl implements AssessService {

    @Autowired
    private IndexLibraryMapper indexLibraryMapper;
    @Autowired
    private IndexAndMethodMapper indexAndMethodMapper;
    @Autowired
    private MethodLibraryMapper methodLibraryMapper;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ServerResponse<ArrayList> getIndexAndMethods()
    {

        ArrayList<String> categoryList = new ArrayList<String>(Arrays.asList("软件人机交互","硬件人机交互","整体评价"));
        ArrayList<Object> allIndexList = new ArrayList<Object>();

        for (String category:categoryList) {

            IndexLibraryExample indexLibraryExample = new IndexLibraryExample();
            IndexLibraryExample.Criteria indexCriteria = indexLibraryExample.createCriteria();
            indexCriteria.andCategoryEqualTo(category);
            List<IndexLibrary> indexs = indexLibraryMapper.selectByExample(indexLibraryExample);

            HashMap<String, Object> categoryData = new HashMap<String, Object>();
            categoryData.put("category",category); //该大类名称
            ArrayList<Object> indexList = new ArrayList<Object>();
            if(!indexs.isEmpty()) //存在该类别的指标
            {
                for(IndexLibrary index:indexs)
                {
                    HashMap<String, Object> indexData = new HashMap<String, Object>();
                    indexData.put("index",index);

                    ArrayList<Object> methodList = new ArrayList<Object>();


                    //查询该指标对应方法
                    IndexAndMethodExample indexAndMethodExample = new IndexAndMethodExample();
                    IndexAndMethodExample.Criteria indexAndMethodCriteria = indexAndMethodExample.createCriteria();
                    indexAndMethodCriteria.andIndexIdEqualTo(index.getId());
                    List<IndexAndMethod> indexAndMethods = indexAndMethodMapper.selectByExample(indexAndMethodExample);

                    if(!indexAndMethods.isEmpty()) //存在方法
                    {
                        for(IndexAndMethod indexAndMethod:indexAndMethods)
                        {
                            HashMap<String, Object> methodData = new HashMap<String, Object>();
                            methodData.put("id",indexAndMethod.getId());


                            //方法信息
                            MethodLibrary method = methodLibraryMapper.selectByPrimaryKey(indexAndMethod.getMethodId());
                            methodData.put("method",method);
                            methodData.put("isMust",indexAndMethod.getIsMust());
                            methodList.add(methodData);
                        }

                    }

                    indexData.put("method",methodList);

                    indexList.add(indexData);






                }
            }
            categoryData.put("indexs",indexList);
            allIndexList.add(categoryData);

        }
        return ServerResponse.createBySuccess("获取成功",allIndexList);
    }
}
