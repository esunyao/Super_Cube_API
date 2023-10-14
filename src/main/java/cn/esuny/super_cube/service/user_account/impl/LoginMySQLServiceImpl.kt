package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.Mapper.user_account.UserMapper
import cn.esuny.super_cube.model.user_account.AccountTable
import cn.esuny.super_cube.service.user_account.LoginMySQLService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


//@Component
@Service
open class LoginMySQLServiceImpl : ServiceImpl<UserMapper, AccountTable?>(), LoginMySQLService{
}