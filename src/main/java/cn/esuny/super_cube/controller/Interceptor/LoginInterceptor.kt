package cn.esuny.super_cube.controller.Interceptor

import cn.esuny.super_cube.SuperCubeApplication
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.utils.JwtUtils
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView





/**
 * 登录验证过滤器
 */
@Component
class LoginInterceptor : HandlerInterceptor {

    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        try{
            jwtUtils?.verify(request.getHeader("token"))
        }catch (e: Exception){
            return false
        }
        return true
    }

//    @Throws(java.lang.Exception::class)
//    override fun postHandle(
//        request: HttpServletRequest?,
//        response: HttpServletResponse?,
//        handler: Any?,
//        modelAndView: ModelAndView?
//    ) {
//        println("执行了拦截器的postHandle方法")
//    }
//
//    /***
//     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
//     */
//    @Throws(java.lang.Exception::class)
//    override fun afterCompletion(
//        request: HttpServletRequest?,
//        response: HttpServletResponse?,
//        handler: Any?,
//        ex: java.lang.Exception?
//    ) {
//        println("执行了拦截器的afterCompletion方法")
//    }
}