package cn.esuny.super_cube.controller.user_account

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.model.user_account.GetLoginAuthentication
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import cn.esuny.super_cube.service.utils.JwtUtils
import cn.esuny.super_cube.translation.language
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController {
    @Autowired
    var login_Service: LoginService? = null

    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null

    @PostMapping(value = [core_constant.API_V1_LOGIN])
    fun login(@RequestBody accountAuthentication: Account_Authentication): Result_general? {
        return login_Service?.loginEvent(accountAuthentication)
    }

    @PostMapping(value = [core_constant.API_V1_GETLOGIN])
    fun getLogin(@RequestBody getLoginAuthentication: GetLoginAuthentication): Result_general? {
        if(jwtUtils != null) {
            return Result_general(
                language.tr("super_cube.service.LoginService.successCode").toInt(),
                null,
                jwtUtils!!.verify(getLoginAuthentication.token).toString(),
                "验证成功"
            )
        }
        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            jwtUtils!!.verify(getLoginAuthentication.token).toString(),
            "验证失败"
        )
    }

    @PostMapping(value = [core_constant.API_V1_REGISTER])
    fun register(@RequestBody accountAuthentication: Account_Authentication): Result_general? {
        return login_Service?.registerEvent(accountAuthentication)
    }
}