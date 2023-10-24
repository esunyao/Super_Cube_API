package cn.esuny.super_cube;

import cn.esuny.super_cube.model.user_account.UserInfoTable;
import cn.esuny.super_cube.service.user_account.LoginMySQLAuthService;
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SuperCubeApplicationTests {

    @Autowired
    private LoginMySQLInfoService loginMySQLInfoService;

    @Autowired
    private LoginMySQLAuthService loginMySQLAuthService;

    @Test
    void contextLoads() {
//        List<UserInfoTable> list = userMapper.list();
//        System.out.println(list.toString());
    }

    private static long time = 1000 * 60 * 60 * 24;
    private static String signature = "admimn";

    @Test
    void user_id() {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                .compact();
    }
}
