package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.List;

public interface FillDataService {
    public ServerResponse<List> addTask(int planId, String taskName, String taskObject, String taskDes);
    public ServerResponse<List> addPeople(int planId,String expertName,String expertBackground,String expertDes);

    public ServerResponse editTask(int taskId, String taskName, String taskObject, String taskDes);
    public ServerResponse editExpert(int expertId,String expertName,String expertBackground,String expertDes);



}
