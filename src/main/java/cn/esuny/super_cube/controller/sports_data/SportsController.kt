package cn.esuny.super_cube.controller.sports_data

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import cn.esuny.super_cube.translation.language
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class SportsController {
    @Autowired
    var login_Service: LoginService? = null

    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @PostMapping(value = [core_constant.API_V1_SPORTS])
    fun login(@RequestBody accountAuthentication: Account_Authentication): Result_general? {
//        return login_Service?.login_event(accountAuthentication)
        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            "{}",
            "输入的用户名或密码不能为空"
        )
    }


}