package cn.esuny.super_cube.controller.sports_data

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.fitness_data.FitnessData
import cn.esuny.super_cube.service.fitness.FitnessService
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController


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


}