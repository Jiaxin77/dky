package hci.dky.service.impl;

import hci.dky.common.ServerResponse;
import hci.dky.dao.UserMapper;
import hci.dky.pojo.User;
import hci.dky.pojo.UserExample;
import hci.dky.service.UserService;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(User user){
        /**
         * @Author jiaxin
         * @Description 登录
         * @Date 11:12 上午 2019/11/15
         * @Param [username, password]
         * @return com.example.demo.common.ServerResponse<com.example.demo.pojo.UserList>
         **/

        //System.out.println("用户名：");
        //System.out.println(username);
        //User myuser = userMapper.selectByUserName(user.getUserName());
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andUserPasswordEqualTo(user.getUserPassword());

        List<User> uList = userMapper.selectByExample(example);


        if(!uList.isEmpty()){
                User thisuser = uList.get(0);
                return ServerResponse.createBySuccess("登录成功",thisuser);
            }
            else {
                //密码错误
                return ServerResponse.createByErrorMessage("登录失败");
            }
        }


    public ServerResponse<String> register(User user){

        /**
         * @Author jiaxin
         * @Description 注册
         * @Date 11:11 上午 2019/11/17
         * @Param [username, password]
         * @return com.example.demo.common.ServerResponse<java.lang.String>
         **/

        //User usered = userMapper.selectByUserName(user.getUserName());
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> uList = userMapper.selectByExample(example);


        if(!uList.isEmpty())
        {
            return ServerResponse.createByErrorMessage("昵称重复，注册失败");
        }
        //若不存在
        //User newUser = new User(userid,username,password,0);
        //存数据库

        userMapper.insert(user);

        return ServerResponse.createBySuccessMessage("注册成功");
    }

    public int add(User user) {
        return userMapper.insert(user);
    }

    public ServerResponse<List<User>> getalluser()
    {
        UserExample userExample = new UserExample();
        List<User> userList = userMapper.selectByExample(userExample);
        return ServerResponse.createBySuccess("获取成功",userList);

    }
}
