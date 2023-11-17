package cn.esuny.super_cube.service.fitness.impl

import cn.esuny.super_cube.Mapper.user_account.FitnessMapper
import cn.esuny.super_cube.model.fitness_data.FitnessTable
import cn.esuny.super_cube.service.fitness.FitnessMySQLService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class FitnessMySQLServiceImpl : ServiceImpl<FitnessMapper, FitnessTable?>(), FitnessMySQLService