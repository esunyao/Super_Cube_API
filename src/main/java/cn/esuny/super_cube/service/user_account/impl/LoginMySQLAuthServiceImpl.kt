package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.Mapper.user_account.UserAuthMapper
import cn.esuny.super_cube.model.user_account.UserAuthTable
import cn.esuny.super_cube.service.user_account.LoginMySQLAuthService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
open class LoginMySQLAuthServiceImpl : ServiceImpl<UserAuthMapper, UserAuthTable?>(), LoginMySQLAuthService {
}