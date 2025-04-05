package cn.esuny.super_cube.service.cube_data.impl

import cn.esuny.super_cube.Mapper.cuber_data.CubeBureauMapper
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.cube_data.CubeBureauData
import cn.esuny.super_cube.service.cube_data.CubeBureauService
import com.baomidou.dynamic.datasource.annotation.DS
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@DS("cuber")
open class CubeBureauServiceImpl : CubeBureauService {

    private val bureauMapper: CubeBureauMapper

    constructor(bureauMapper: CubeBureauMapper) {
        this.bureauMapper = bureauMapper
    }

    @Transactional
    override fun createBureauRecord(data: CubeBureauData): Result_general {
        return try {
            bureauMapper.insert(data)
            Result_general(800, data = "{}", Message = "记录创建成功")
        } catch (e: Exception) {
            Result_general(500, data = "{}", Message = "创建失败: ${e.message}")
        }
    }

    override fun getByUserAndBureau(userId: String, bureauId: String): List<CubeBureauData> {
        return bureauMapper.selectList(
            QueryWrapper<CubeBureauData>().eq("user_id", userId).eq("bureauID", bureauId)
        )
    }
}
