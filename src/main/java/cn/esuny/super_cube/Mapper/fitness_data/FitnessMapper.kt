package cn.esuny.super_cube.Mapper.fitness_data

import cn.esuny.super_cube.model.fitness_data.FitnessTable
import com.baomidou.dynamic.datasource.annotation.DS
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
@DS("sports")
interface FitnessMapper : BaseMapper<FitnessTable?>