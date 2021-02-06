package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.pojo.AssessLibrary;
import hci.dky.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ModelController
 * @Description TODO
 * @Author jiaxin
 * @Date 2021/2/6 10:15 上午
 * @Version 1.0
 **/

@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/setAssessToModel")
    public ServerResponse setAssessToModel(Integer assessId)
    {
        ServerResponse response = modelService.setAssessToModel(assessId);
        return response;

    }

    @PostMapping("/createAssessFromModel")
    public ServerResponse<AssessLibrary> createAssessFromModel(Integer modelId)
    {
        ServerResponse response = modelService.createAssessFromModel(modelId);
        return response;
    }

    @GetMapping("/getModelList")
    public ServerResponse<List<AssessLibrary>> getModelList()
    {
        ServerResponse<List<AssessLibrary>> response = modelService.getModelList();
        return response;
    }

    @PostMapping("/deleteModel")
    public ServerResponse deleteModel(Integer modelId)
    {
        ServerResponse response = modelService.deleteModel(modelId);
        return response;
    }

}
