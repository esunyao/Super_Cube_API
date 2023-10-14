package cn.esuny.super_cube;

import cn.esuny.super_cube.model.user_account.UserInfoTable;
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SuperCubeApplicationTests {

    @Autowired
    private LoginMySQLInfoService userMapper;

    @Test
    void contextLoads() {
        List<UserInfoTable> list = userMapper.list();
        System.out.println(list.toString());
    }

    @Test
    void user_id(){
        System.out.println(1);
    }
}
