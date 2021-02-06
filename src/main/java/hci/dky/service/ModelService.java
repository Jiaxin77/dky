package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.pojo.AssessLibrary;

import java.util.List;

public interface ModelService {
    public ServerResponse setAssessToModel(Integer assessId);
    public ServerResponse<AssessLibrary> createAssessFromModel(Integer modelId);
    public ServerResponse<List<AssessLibrary>> getModelList();
    public ServerResponse deleteModel(Integer modelId);
}
