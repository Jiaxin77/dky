package hci.dky.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import hci.dky.pojo.User;
import hci.dky.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @ClassName TokenServiceImpl
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/6/18 4:54 下午
 * @Version 1.0
 **/

@Service
public class TokenServiceImpl implements TokenService {
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() +14 * 24 * 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(String.valueOf(user.getUserId())).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }
    
}
