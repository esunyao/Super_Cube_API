package cn.esuny.super_cube.controller.user_account

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.service.user_account.LoginMySQLService
import cn.esuny.super_cube.service.user_account.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController {
    @Autowired
    var login_Service: LoginService? = null

    @Autowired
    var loginMySQLService: LoginMySQLService? = null

    @PostMapping(value = [core_constant.API_V1_LOGIN])
    fun login(@RequestBody accountAuthentication: Account_Authentication): Result_general? {
        return loginMySQLService?.let { login_Service?.login_event(accountAuthentication, it) }
    }

    @GetMapping(value = ["/api/v1/test"])
    fun test() {
//        val userList: List<Account_Table> = UserMapper.selectList(
//            QueryWrapper<User>()
//                .lambda()
//                .ge(User::getAge, 18)
//        )
//        System.out.println(loginMySQLService?.list() ?: "null")
    }
}