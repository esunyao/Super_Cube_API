package cn.esuny.super_cube.service.fitness

import cn.esuny.super_cube.model.Result_general
import cn.esuny.super_cube.model.fitness_data.FitnessData

interface FitnessService {
    fun uploadData(fitnessData: FitnessData?, token: String): Result_general?

    fun getHistoryData(token: String): Result_general?

}