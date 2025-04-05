package cn.esuny.super_cube.service.cube_data.impl

import cn.esuny.super_cube.Mapper.cuber_data.CubeDataMapper
import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.cube_data.CubeDataData
import cn.esuny.super_cube.service.cube_data.CubeDataService
import com.baomidou.dynamic.datasource.annotation.DS
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@DS("cuber")
open class CubeDataServiceImpl(
    private val dataMapper: CubeDataMapper
) : CubeDataService {

    @Transactional
    override fun saveChunkData(data: CubeDataData): Result_general {
        return try {
            dataMapper.insert(data)
            Result_general(800, data = "{}", Message = "数据块保存成功")
        } catch (e: Exception) {
            Result_general(500, data = "{}", Message = "保存失败: ${e.message}")
        }
    }

    override fun getChunkData(bureauId: String, chunk: Long): CubeDataData? {
        return dataMapper.selectOne(
            QueryWrapper<CubeDataData>().eq("bureauID", bureauId).eq("chunk", chunk)
        )
    }
}