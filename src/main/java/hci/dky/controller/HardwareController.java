package hci.dky.controller;



import hci.dky.common.ServerResponse;
import hci.dky.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//参数评估

@RestController

public class HardwareController {

    @Autowired
    private HardwareService hardwareService;

    //获取参数
    //@RequestMapping(value = "/getParam",method = RequestMethod.GET)
    @GetMapping("/getParam")
    //@ResponseBody
    public ServerResponse<ArrayList> getParam(){
        ServerResponse<ArrayList> response = hardwareService.getParam();
        return response;
    }

    //提交输入 获取结果
    @PostMapping("/postParamResult")
    //@RequestMapping(value = "/postParamResult",method = RequestMethod.POST)
    //@ResponseBody
    public ServerResponse<ArrayList> postParamResult(@RequestBody List<Map<String,Object>> resultArray){
        ServerResponse<ArrayList> response = hardwareService.postParamResult(resultArray);
        return response;
    }

}
