package cn.esuny.super_cube.service.utils

import cn.esuny.super_cube.model.user_account.UserInfoTable

interface JwtUtils {
    companion object {
        /**
         * 过期时间5分钟
         */
        const val EXPIRE_TIME = (5 * 60 * 1000).toLong()

        /**
         * 加密密钥
         */
        // Super_Cube_Token
        const val KEY = "FRS6c92e042bf98a18a"
    }

    /**
     * 生成token
     * @param UserID    用户id
     * @param userName  用户名
     * @return
     */
    fun createToken(UserID: String?, userName: String?, passwd: String?): String

    /**
     * 验证token是否有效
     * @param token  请求头中携带的token
     * @return  token验证结果  2-token过期；1-token认证通过；0-token认证失败
     */
    fun verify(token: String?): UserInfoTable?
}