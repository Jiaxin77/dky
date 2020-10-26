package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.List;

/**
 * @program: dky
 * @description: 专家走查
 * @author: Leaf
 * @create: 2020-08-27 15:20
 * @Version: 1.0
 **/
public interface ExpertWalkthroughService {
    public ServerResponse<List> postExpertWalkthroughAnswer(int planId, List<Object> answer);
    public ServerResponse<List> getExpertWalkthroughAnswer(int planId);
}
