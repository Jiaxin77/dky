package hci.dky.service;

import hci.dky.pojo.User;

public interface TokenService {

    String getToken(User user);
}
