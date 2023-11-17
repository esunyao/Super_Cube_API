package cn.esuny.super_cube.service.user_account

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication

interface LoginService {
    fun loginEvent(accountAuthentication: Account_Authentication?): Result_general?
}