package hci.dky.service;

import hci.dky.common.ServerResponse;
import hci.dky.pojo.User;


public interface UserService {
    ServerResponse<User> login(User user);
    ServerResponse<String> register(User user);
    int add(User user);
}
