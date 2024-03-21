package cn.esuny.super_cube.controller.sports_data

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.fitness_data.FitnessData
import cn.esuny.super_cube.service.fitness.FitnessService
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.nio.file.Paths


@RestController
class FitnessController {
    @Autowired
    var fitnessService: FitnessService? = null

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

    @PostMapping(value = [core_constant.API_V1_FITNESS + "/resource/{id}"])
    fun getResource(@PathVariable id: String): ResponseEntity<Any>? {
        val file = Paths.get("storage/", "$id").toAbsolutePath().normalize().toFile()

        if (file.exists()) {
            val resource: Resource = UrlResource(file.toURI())
            return ResponseEntity.ok().body(resource)
        } else {
            // 如果文件不存在，您可以返回一个错误响应
            return ResponseEntity.notFound().build()
        }
    }
}