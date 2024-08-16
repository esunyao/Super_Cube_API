package cn.esuny.super_cube.service.interceptor

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.controller.Interceptor.LoginInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
open class LoginInterceptorReg : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        //注册TestInterceptor拦截器
        val registration = registry.addInterceptor(LoginInterceptor())
        registration.addPathPatterns("/**") //所有路径都被拦截
        registration.excludePathPatterns( //添加不拦截路径
            core_constant.API_V1_LOGIN,
            core_constant.API_V1_REGISTER,
            core_constant.API_V1_GETLOGIN
        )
    }
}