package cn.esuny.super_cube.model.fitness_data

import lombok.Data

@Data
data class FitnessValData(
    val seconds: Int,
    val dataVal: Int
)