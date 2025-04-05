package cn.esuny.super_cube.Mapper.cuber_data;

import cn.esuny.super_cube.model.cube_data.CubeDataData
import com.baomidou.dynamic.datasource.annotation.DS
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
@DS("cuber")
interface CubeDataMapper : BaseMapper<CubeDataData>