package cn.esuny.super_cube.controller.Interceptor

import cn.esuny.super_cube.SuperCubeApplication
import cn.esuny.super_cube.service.utils.impl.JwtUtilsImpl
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.servlet.HandlerInterceptor


/**
 * 登录验证过滤器
 */
@Service
class LoginInterceptor : HandlerInterceptor {

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        try {
            val jwtUtils = JwtUtilsImpl()
            if (jwtUtils.verify(request.getHeader("token")) == null) {
                response.status = HttpStatus.BAD_REQUEST.value()
                return false
            }
            return true
        } catch (e: IllegalArgumentException) {
            SuperCubeApplication.logger.warn("token值为空！")
        }
        return false
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