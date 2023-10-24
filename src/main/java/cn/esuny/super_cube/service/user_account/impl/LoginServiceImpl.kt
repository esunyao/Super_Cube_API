package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.SuperCubeApplication
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.model.user_account.UserInfoTable
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import cn.esuny.super_cube.utils.UUID_Utils.GetUUID
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import kotlin.math.log

@Service
open class LoginServiceImpl : LoginService {
    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    override fun login_event(accountAuthentication: Account_Authentication?): Result_general {

        if (accountAuthentication != null) {
            if (StringUtils.isEmpty(accountAuthentication.account) or StringUtils.isEmpty(accountAuthentication.password)) {
                return Result_general(SuperCubeApplication.language.get("super_cube.service.LoginService.failed") as Int, null, "","输入的用户名或密码不能为空")
            }
            val qw: QueryWrapper<UserInfoTable> = QueryWrapper<UserInfoTable>()
            qw.eq("user_id", GetUUID(accountAuthentication.account))
            val res: UserInfoTable? = loginMySQLInfoService?.getOne(qw)
            if (res != null) {
                if (res.password.equals(accountAuthentication.password)){

                }
            }
        }
        return Result_general(SuperCubeApplication.language.get("super_cube.service.LoginService.failed") as Int, null, "","输入的用户名或密码不能为空")
    }
}