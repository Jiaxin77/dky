package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.pojo.User;

import java.util.HashMap;
import java.util.List;


public interface UserService {
    ServerResponse<HashMap<String,Object>> login(User user);
    ServerResponse<String> register(User user);
    int add(User user);
    ServerResponse<String> delete(User user);
    ServerResponse<List<User>> getalluser();
    public User findUserById(int id);
}
