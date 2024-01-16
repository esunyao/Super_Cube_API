package cn.esuny.super_cube.constants

open class core_constant {
    companion object{
        const val NAME_SHORT: String = "Cube"
        const val NAME: String = "Super_Cube"
        const val PACKAGE_NAME: String = "Super_Cube"


        const val VERSION: String = "0.0.1-alpha"

        const val GITHUB_URL: String = "https://github.com/esunyao/Super_Cube_API"

        const val LANGUAGE_FILE_SUFFIX: String = ".yml"
        const val DEFAULT_LANGUAGE: String = "zh_cn"

        const val API_PREFIX_V1: String = "/api/v1/"
        const val API_V1_LOGIN: String = API_PREFIX_V1 + "login"
        const val API_V1_GETLOGIN: String = API_PREFIX_V1 + "get"
        const val API_V1_FITNESS: String = API_PREFIX_V1 + "fitness"

        /**
         * @author esuny
         * @description 用户类数据库查询设定
         * */
        const val UserInfoTableName: String = "user"
        const val UserAuthTableName: String = "user_auths"
        const val FitnessTableName: String = "fitness_data"
    }
}