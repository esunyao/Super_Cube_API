package cn.esuny.super_cube.model

import java.io.Serializable

/**
 * @author esuny
 * @param code - 反馈代码
 * @param execute - 反向handler操作
 * @param data - 返回json数据
 * */
data class Result_general(val code: Int, val execute: Array<String>? = null, val data: Any, val Message: String? = null) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Result_general

        if (code != other.code) return false
        if (execute != null) {
            if (other.execute == null) return false
            if (!execute.contentEquals(other.execute)) return false
        } else if (other.execute != null) return false
        if (data != other.data) return false
        if (Message != other.Message) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code
        result = 31 * result + (execute?.contentHashCode() ?: 0)
        result = 31 * result + data.hashCode()
        result = 31 * result + (Message?.hashCode() ?: 0)
        return result
    }
}