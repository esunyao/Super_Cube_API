package cn.esuny.super_cube;

import cn.esuny.super_cube.Mapper.UserMapper;
import cn.esuny.super_cube.model.user_account.Account_Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SuperCubeApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        for (Account_Table userPO : userMapper.selectList(null)) {
            System.out.println(userPO.toString());
        }
    }

}
