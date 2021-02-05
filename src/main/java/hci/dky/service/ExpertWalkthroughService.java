package hci.dky.service;

import hci.dky.common.ServerResponse;

import java.util.HashMap;
import java.util.List;

/**
 * @program: dky
 * @description:
 * @author: Leaf
 * @create: 2020-11-06 16:52
 * @Version: 1.0
 **/
public interface ExpertWalkthroughService {
    public ServerResponse<List> postExpertWalkthroughAnswer(int planId, List<Object> answer);
    public ServerResponse<List> getExpertWalkthroughAnswer(int planId);
    public ServerResponse<List> getExpertWalkthroughAnswer1(int planId);
}
