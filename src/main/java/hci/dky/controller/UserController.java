package hci.dky.controller;

import hci.dky.common.ServerResponse;
import hci.dky.pojo.User;
import hci.dky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
//@RequestMapping(value = "/home")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return user信息
     */
    @PostMapping("/login")
    public ServerResponse<HashMap<String,Object>>  login(User user){
        ServerResponse<HashMap<String,Object>> response = userService.login(user);
        return response;
    }


    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ServerResponse<String> register(User user){


        ServerResponse<String> response = userService.register(user);
        return response;
    }

    @PostMapping("/add")
    public int add(User user) {
        return userService.add(user);
    }

    @PostMapping("/delete")
    public ServerResponse<String> delete(User user) {
        return userService.delete(user);
    }

    @GetMapping("/getalluser")
    public ServerResponse<List<User>> getalluser()
    {
        return userService.getalluser();
    }
}
