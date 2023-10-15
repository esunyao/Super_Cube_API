package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.service.user_account.LoginMySQLService
import cn.esuny.super_cube.service.user_account.LoginService
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
open class LoginServiceImpl : LoginService {

    override fun login_event(accountAuthentication: Account_Authentication, loginMySQLService: LoginMySQLService): Result_general {

        if (StringUtils.isEmpty(accountAuthentication.account)) {
            return Result_general(400, null, "","账号不能为空")
        }
        if (StringUtils.isEmpty(accountAuthentication.password)) {
            return Result_general(400, null, "","密码不能为空")
        }
        return Result_general(400, null, "", "asdfasdf")
    }
}