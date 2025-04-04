package cn.esuny.super_cube.constants

open class core_constant {
    companion object{
        const val NAME_SHORT: String = "Cube"
        const val NAME: String = "Super_Cube"
        const val PACKAGE_NAME: String = "Super_Cube"


        const val VERSION: String = "0.0.3-alpha"

        const val GITHUB_URL: String = "https://github.com/esunyao/Super_Cube_API"

        const val LANGUAGE_FILE_SUFFIX: String = ".yml"
        const val DEFAULT_LANGUAGE: String = "zh_cn"

        const val API_PREFIX_V1: String = "/api/v1/"
        const val API_V1_LOGIN: String = API_PREFIX_V1 + "login"
        const val API_V1_REGISTER: String = API_PREFIX_V1 + "register"
        const val API_V1_GETLOGIN: String = API_PREFIX_V1 + "get"
        const val API_V1_FITNESS: String = API_PREFIX_V1 + "fitness"
        const val API_V1_GETDATA: String = API_PREFIX_V1 + "fileData"
        const val API_V1_SETDATA: String = API_PREFIX_V1 + "setfileData"

        const val API_V1_FITNESS_WX: String = API_V1_FITNESS + "/wx"

        /**
         * @author esuny
         * @description 用户类数据库查询设定
         * */
        const val UserInfoTableName: String = "user"
        const val UserAuthTableName: String = "user_auths"
        const val FitnessTableName: String = "fitness_data"
    }
}