package cn.esuny.super_cube.controller.cube_data

import cn.esuny.super_cube.constants.core_constant
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.cube_data.CubeBureauData
import cn.esuny.super_cube.model.cube_data.CubeDataData
import cn.esuny.super_cube.service.cube_data.impl.CubeBureauServiceImpl
import cn.esuny.super_cube.service.cube_data.impl.CubeDataServiceImpl
import cn.esuny.super_cube.service.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.ZoneId

@RestController
class CubeDataController {
    @Autowired
    private lateinit var cubeBureauService: CubeBureauServiceImpl

    @Autowired
    private lateinit var cubeDataService: CubeDataServiceImpl

    @Autowired
    var jwtUtils: JwtUtils? = null

    @PostMapping(value = [core_constant.API_V1_UPLOADACC])
    fun uploadChunkData(
        @RequestHeader("bureauID") bureauID: String,
        @RequestHeader("chunk") chunk: Long,
        @RequestHeader("cubeID") cubeID: CubeDataData.CubeSide,
        @RequestBody binaryData: ByteArray
    ): Result_general {
        return cubeDataService.saveChunkData(
            CubeDataData(
                bureauID = bureauID, chunk = chunk, cubeID = cubeID, data = binaryData
            )
        )
    }

    @PostMapping(core_constant.API_V1_COMPLETEUPLOAD)
    fun completeUpload(
        @RequestHeader("token") token: String, @RequestBody request: BureauMetaRequest
    ): Result_general {
        val claims = jwtUtils?.verify(token) ?: return Result_general(401, data = "{}", Message = "无效Token")
        val userId = claims.id ?: return Result_general(401, data = "{}", Message = "无效用户ID")
// 解析为UTC时间
        val utcTime = Instant.parse(request.startTime)

        // 转换为服务器本地时间
        val localDateTime = utcTime.atZone(ZoneId.systemDefault()).toLocalDateTime()
        return cubeBureauService.createBureauRecord(
            CubeBureauData(
                user_id = userId,
                bureauID = request.bureauID,
                startTime = localDateTime,
                totalTime = request.totalTime,
            )
        )
    }

    data class BureauMetaRequest(
        val bureauID: String, val startTime: String, val totalTime: String
    )
}