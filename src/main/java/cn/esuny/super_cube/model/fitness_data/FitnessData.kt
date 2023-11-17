package cn.esuny.super_cube.model.fitness_data

import lombok.Data

@Data
data class FitnessData(
    var programCode: String,
    var startTime: String,
    var secondsTotal: Int,
    var fitnessNumber: Int,
    var triggerMinVal: Int,
    var triggerMaxVal: Int,
    var dataValList: List<FitnessValData>
)