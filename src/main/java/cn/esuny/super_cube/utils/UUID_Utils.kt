package cn.esuny.super_cube.utils

import cn.esuny.super_cube.model.user_account.Account_Authentication
import java.util.*

object UUID_Utils {
    fun GetUUID(string: String): String {
        return UUID.nameUUIDFromBytes(string.toByteArray()).toString()
    }
}