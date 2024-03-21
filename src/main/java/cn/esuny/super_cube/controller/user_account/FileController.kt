package cn.esuny.super_cube.controller.user_account

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.UserFileTable
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import cn.esuny.super_cube.service.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class FileController {
    @Autowired
    var login_Service: LoginService? = null

    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null

    @PostMapping(value = [core_constant.API_V1_GETDATA])
    fun GetData(@RequestHeader token: String): Result_general? {
        return login_Service?.userFileGetEvent(token)
    }

    @PostMapping(value = [core_constant.API_V1_SETDATA])
    fun SetData(@RequestBody userFileTable: UserFileTable, @RequestHeader token: String): Result_general? {
        return login_Service?.userFileSetEvent(userFileTable, token)
    }
}