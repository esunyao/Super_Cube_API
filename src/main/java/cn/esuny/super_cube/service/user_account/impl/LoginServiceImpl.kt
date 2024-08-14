package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.model.user_account.UserFileTable
import cn.esuny.super_cube.model.user_account.UserInfoTable
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import cn.esuny.super_cube.service.utils.JwtUtils
import cn.esuny.super_cube.translation.language
import cn.esuny.super_cube.utils.UUID_Utils.GetUUID
import com.alibaba.fastjson.JSONObject
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper
import io.jsonwebtoken.Claims
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.time.LocalDateTime

@Service
open class LoginServiceImpl : LoginService {
    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null

    override fun loginEvent(accountAuthentication: Account_Authentication?): Result_general {

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
            val re: JSONObject = JSONObject()
            qw.eq("user_id", GetUUID(accountAuthentication.account))
            val res: UserInfoTable? = loginMySQLInfoService?.getOne(qw)
            if (res != null) {
                if (res.password.equals(accountAuthentication.password)) {
                    val token: String? = jwtUtils?.createToken(res.userId, res.username, res.password)
                    re.put("token", token)
                    return Result_general(
                        language.tr("super_cube.service.LoginService.successCode").toInt(),
                        null,
                        re.toJSONString(),
                        "登录成功"
                    )
                } else
                    return Result_general(
                        language.tr("super_cube.service.LoginService.failedCode").toInt(),
                        null,
                        re.toJSONString(),
                        "输入密码错误"
                    )
            } else {
                return Result_general(
                    language.tr("super_cube.service.LoginService.failedCode").toInt(),
                    null,
                    re.toJSONString(),
                    "用户名错误"
                )
            }
        }

        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            "{}",
            "输入的用户名或密码不能为空"
        )
    }

    override fun userFileGetEvent(token: String?): Result_general? {
        val claims: Claims? = jwtUtils?.verify(token)
        if (claims != null) {
            val qw: QueryWrapper<UserInfoTable> = QueryWrapper<UserInfoTable>()
            qw.eq("user_id", claims.id.toString())
            val res: UserInfoTable? = loginMySQLInfoService?.getOne(qw)
            val resu: JSONObject = JSONObject();
            resu.put("username", res?.username)
            resu.put("sex", res?.sex)
            resu.put("age", res?.age)
            resu.put("phone", res?.phone)
            resu.put("first_name", res?.firstName)
            resu.put("second_name", res?.secondName)
            resu.put("weigh", res?.weigh)
            resu.put("createTime", res?.createTime)
            return Result_general(
                language.tr("super_cube.service.LoginService.successCode").toInt(),
                null,
                resu.toJSONString(),
                "数据获取成功"
            )
        }
        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            "",
            "数据不能为空或数据异常"
        )
    }

    override fun userFileSetEvent(userFileTable: UserFileTable?, token: String?): Result_general? {
        val claims: Claims? = jwtUtils?.verify(token)
        if (claims != null) {
            val uw: UpdateWrapper<UserInfoTable> = UpdateWrapper<UserInfoTable>()
            uw.set("first_name", userFileTable?.first_name).eq("user_id", claims.id.toString())
            uw.set("second_name", userFileTable?.second_name).eq("user_id", claims.id.toString())
            uw.set("age", userFileTable?.age).eq("user_id", claims.id.toString())
            uw.set("sex", userFileTable?.sex).eq("user_id", claims.id.toString())
            uw.set("weigh", userFileTable?.weigh).eq("user_id", claims.id.toString())
            uw.set("create_time", LocalDateTime.now())
            loginMySQLInfoService?.update(uw)
            return Result_general(
                language.tr("super_cube.service.LoginService.successCode").toInt(),
                null,
                "",
                "数据上传成功"
            )
        }
        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            "",
            "数据不能为空或数据异常"
        )
    }

    override fun registerEvent(accountAuthentication: Account_Authentication): Result_general? {
        accountAuthentication.password = "1"
        if (loginEvent(accountAuthentication).Message.equals("输入密码错误"))
            return Result_general(
                language.tr("super_cube.service.LoginService.failedCode").toInt(),
                null,
                "",
                "用户名已存在"
            )
        loginMySQLInfoService?.save(
            UserInfoTable(
                null,
                accountAuthentication.account,
                GetUUID(accountAuthentication.account).toString(),
                "81dc9bdb52d04dc20036dbd8313ed055"
            )
        )
        val token: String? = jwtUtils?.createToken(
            GetUUID(accountAuthentication.account),
            accountAuthentication.account,
            "81dc9bdb52d04dc20036dbd8313ed055"
        )
        val re: JSONObject = JSONObject()
        re.put("token", token)
        return Result_general(
            language.tr("super_cube.service.LoginService.successCode").toInt(),
            null,
            re.toJSONString(),
            "数据上传成功"
        )
    }
}