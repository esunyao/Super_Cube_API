package cn.esuny.super_cube.controller.sports_data

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.fitness_data.FitnessData
import cn.esuny.super_cube.service.fitness.FitnessService
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.utils.JwtUtils
import io.jsonwebtoken.Claims
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.nio.file.Paths


@RestController
class FitnessController {
    @Autowired
    var fitnessService: FitnessService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null

    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    @PostMapping(value = [core_constant.API_V1_FITNESS + "/data"])
    fun getData(@RequestBody fitnessData: FitnessData, @RequestHeader token: String): Result_general? {
        return fitnessService?.uploadData(fitnessData, token)
    }

    @PostMapping(value = [core_constant.API_V1_FITNESS + "/getHistory"])
    fun getHistory(@RequestHeader token: String): Result_general? {
        return fitnessService?.getHistoryData(token)
    }

    @GetMapping(value = [core_constant.API_V1_FITNESS + "/resource/{id}"])
    fun getResource(@PathVariable id: String, @RequestHeader token: String): ResponseEntity<Any>? {
        var file = Paths.get("storage/", id).toAbsolutePath().normalize().toFile()
        if (id.equals("UserImage")) {
            val claims: Claims? = jwtUtils?.verify(token)
            if (claims != null) {
                val userImage = claims.subject.toString() + ".jpg"
                file = Paths.get("storage/", userImage).toAbsolutePath().normalize().toFile()
            }
        }
        if (file.exists()) {
            val resource: Resource = UrlResource(file.toURI())
            return ResponseEntity.ok().body(resource)
        } else {
            // 如果文件不存在，您可以返回一个错误响应
            return ResponseEntity.notFound().build()
        }
    }

    @GetMapping(value = [core_constant.API_V1_FITNESS + "/wxresource/{id}"])
    fun getwxResource(@PathVariable id: String, @RequestHeader token: String): ResponseEntity<Any>? {
        jwtUtils?.verify(token) ?: return ResponseEntity.notFound().build()
        val file = Paths.get("wxstorage/", id).toAbsolutePath().normalize().toFile()
        if (file.exists()) {
            val resource: Resource = UrlResource(file.toURI())
            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.filename + "\"")
                .body(resource)
        } else {
            return ResponseEntity.notFound().build()
        }
    }

    @GetMapping(value = [core_constant.API_V1_FITNESS_WX])
    fun fitnessWx(@RequestBody id: String) {

    }
}