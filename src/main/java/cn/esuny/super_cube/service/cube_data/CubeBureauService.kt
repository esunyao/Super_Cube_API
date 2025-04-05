package cn.esuny.super_cube.service.cube_data

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.cube_data.CubeBureauData

interface CubeBureauService {
    fun createBureauRecord(data: CubeBureauData): Result_general
    fun getByUserAndBureau(userId: String, bureauId: String): List<CubeBureauData>
}