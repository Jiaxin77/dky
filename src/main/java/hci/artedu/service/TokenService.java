package hci.artedu.service;

import hci.artedu.pojo.User;

public interface TokenService {

    String getToken(User user);
}
