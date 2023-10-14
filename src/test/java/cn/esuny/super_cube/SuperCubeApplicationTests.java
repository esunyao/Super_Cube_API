package cn.esuny.super_cube;

import cn.esuny.super_cube.model.user_account.AccountTable;
import cn.esuny.super_cube.service.user_account.LoginMySQLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SuperCubeApplicationTests {

    @Autowired
    private LoginMySQLService userMapper;

    @Test
    void contextLoads() {
        List<AccountTable> list = userMapper.list();
        System.out.println(list.toString());
    }

}
