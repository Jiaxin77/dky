package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.dao.IndexLibraryMapper;

import java.util.ArrayList;

public interface AssessService {

    public ServerResponse<ArrayList> getIndexAndMethods();


}
