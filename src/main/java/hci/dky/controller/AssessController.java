package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.service.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @ClassName AssessController
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/5/18 9:46 上午
 * @Version 1.0
 **/

@RestController
public class AssessController {
    @Autowired
    private AssessService assessService;

    @GetMapping("/getIndexsAndMethods")
    public ServerResponse<ArrayList> getIndexsAndMethods(){
        ServerResponse<ArrayList> response = assessService.getIndexAndMethods();
        return response;
    }



}
