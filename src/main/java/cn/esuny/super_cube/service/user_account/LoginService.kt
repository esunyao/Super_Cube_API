package cn.esuny.super_cube.service.user_account

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.model.user_account.UserFileTable

interface LoginService {
    fun loginEvent(accountAuthentication: Account_Authentication?): Result_general?
    fun userFileGetEvent(token: String?): Result_general?

    fun userFileSetEvent(userFileTable: UserFileTable?, token: String?): Result_general?
    fun registerEvent(accountAuthentication: Account_Authentication): Result_general?
}