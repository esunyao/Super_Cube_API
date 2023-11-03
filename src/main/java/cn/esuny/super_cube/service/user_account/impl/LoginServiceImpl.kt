package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.SuperCubeApplication
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.model.user_account.UserInfoTable
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import cn.esuny.super_cube.service.utils.JwtUtils
import cn.esuny.super_cube.translation.language
import cn.esuny.super_cube.utils.UUID_Utils
import cn.esuny.super_cube.utils.UUID_Utils.GetUUID
import com.alibaba.fastjson.JSON
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import kotlin.math.log

@Service
open class LoginServiceImpl : LoginService {
    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null

    override fun login_event(accountAuthentication: Account_Authentication?): Result_general {

        if (accountAuthentication != null) {
            if (StringUtils.isEmpty(accountAuthentication.account) or StringUtils.isEmpty(accountAuthentication.password)) {
                return Result_general(
                    language.tr("super_cube.service.LoginService.failedCode").toInt(),
                    null,
                    "{}",
                    "输入的用户名或密码不能为空"
                )
            }
            val qw: QueryWrapper<UserInfoTable> = QueryWrapper<UserInfoTable>()
            qw.eq("user_id", GetUUID(accountAuthentication.account))
            val res: UserInfoTable? = loginMySQLInfoService?.getOne(qw)
            if (res != null) {
                if (res.password.equals(accountAuthentication.password)) {
                    val token: String? = jwtUtils?.createToken(res.userId, res.username, res.password)
                    return Result_general(
                        language.tr("super_cube.service.LoginService.successCode").toInt(),
                        null,
                        String.format("{\"token\": \"%s\"}", token),
                        "登录成功"
                    )
                }else
                    return Result_general(
                        language.tr("super_cube.service.LoginService.failedCode").toInt(),
                        null,
                        "{}",
                        "输入密码错误"
                    )
            }else
                return Result_general(
                    language.tr("super_cube.service.LoginService.failedCode").toInt(),
                    null,
                    "{}",
                    "用户名错误"
                )
        }

        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            "{}",
            "输入的用户名或密码不能为空"
        )
    }
}