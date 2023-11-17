package cn.esuny.super_cube.service.fitness.impl

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.fitness_data.FitnessData
import cn.esuny.super_cube.model.fitness_data.FitnessTable
import cn.esuny.super_cube.service.fitness.FitnessMySQLService
import cn.esuny.super_cube.service.fitness.FitnessService
import cn.esuny.super_cube.service.utils.JwtUtils
import cn.esuny.super_cube.translation.language
import com.alibaba.fastjson.JSON
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import io.jsonwebtoken.Claims
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
open class FitnessServiceImpl : FitnessService {
    @Autowired
    var fitnessMySQLService: FitnessMySQLService? = null

    @Autowired
    var jwtUtils: JwtUtils? = null
    override fun uploadData(fitnessData: FitnessData?, token: String): Result_general? {
        if (fitnessData != null) {
            val claims: Claims? = jwtUtils?.verify(token)
            val qw: QueryWrapper<FitnessTable> = QueryWrapper<FitnessTable>()
            if (claims != null) {
                qw.eq("user_id", claims.id)
                qw.eq("startTime", fitnessData.startTime)
                qw.eq("triggerMaxVal", fitnessData.triggerMaxVal)
                qw.eq("triggerMinVal", fitnessData.triggerMinVal)
                qw.eq("fitnessNumber", fitnessData.fitnessNumber)
                qw.eq("dataValList", fitnessData.dataValList)
                qw.eq("secondsTotal", fitnessData.secondsTotal)
                fitnessMySQLService?.save(
                    FitnessTable(
                        claims.id,
                        LocalDateTime.parse(
                            fitnessData.startTime,
                            DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss")
                        ),
                        fitnessData.secondsTotal,
                        fitnessData.fitnessNumber,
                        fitnessData.triggerMinVal,
                        fitnessData.triggerMaxVal,
                        JSON.parseArray(JSON.toJSONString(fitnessData.dataValList))
                    )
                )
                return Result_general(
                    language.tr("super_cube.service.LoginService.successCode").toInt(),
                    null,
                    "",
                    "上传成功"
                )
            }
        }
        return Result_general(
            language.tr("super_cube.service.LoginService.failedCode").toInt(),
            null,
            "",
            "数据不能为空"
        )
    }
}