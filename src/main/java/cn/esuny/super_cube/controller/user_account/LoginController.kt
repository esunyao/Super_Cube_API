package cn.esuny.super_cube.controller.user_account

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.user_account.Account_Authentication
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.user_account.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class LoginController {
    @Autowired
    var login_Service: LoginService? = null

    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @PostMapping(value = [core_constant.API_V1_LOGIN])
    fun login(@RequestBody accountAuthentication: Account_Authentication): Result_general? {
        return login_Service?.login_event(accountAuthentication)
    }

    @GetMapping(value = ["/api/v1/video"])
    fun test(): FileSystemResource {
        return FileSystemResource("./a.mp4");
    }

    @GetMapping(value = ["/api/v1/show"])
    fun show(): String {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\" />\n" +
                "<title>Insert title here</title>\n" +
                "</head>\n" +
                "<!--JQuery在线引用-->\n" +
                "<script src=\"http://code.jquery.com/jquery-1.10.1.min.js\"></script>\n" +
                "\n" +
                "<body>\n" +
                "    <video controls=\"autoplay\"    src=\"http://localhost:8081/api/v1/video\" /> \n" +
                "    \n" +
                "</body>\n" +
                "</html>"
    }
}