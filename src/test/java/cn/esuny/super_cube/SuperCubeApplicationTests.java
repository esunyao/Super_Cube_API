package cn.esuny.super_cube;

import cn.esuny.super_cube.service.user_account.LoginMySQLAuthService;
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService;
import cn.esuny.super_cube.utils.UUID_Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        for (int i = 1; i <= 100; i++) {
            System.out.println("test" + i);
            System.out.println(UUID_Utils.INSTANCE.GetUUID("Test" + i).toString());
        }
//        System.out.println(UUID_Utils.INSTANCE.GetUUID("Test1").toString())

    }
}
