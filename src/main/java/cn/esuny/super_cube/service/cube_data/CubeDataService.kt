package cn.esuny.super_cube.service.cube_data

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.cube_data.CubeDataData

interface CubeDataService {
    fun saveChunkData(data: CubeDataData): Result_general
    fun getChunkData(bureauId: String, chunk: Long): CubeDataData?
}