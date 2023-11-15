package cn.esuny.super_cube.model.fitness_data

import cn.esuny.super_cube.constants.core_constant
import com.alibaba.fastjson.JSON
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import java.time.LocalDateTime

@Data
@TableName(value = core_constant.FitnessTableName)
data class FitnessTable(
    @TableId(value = "user_id", type = IdType.AUTO)
    var id: String? = null,

    @TableField(value = "startTime")
    var startTime: LocalDateTime? = null,

    @TableField(value = "secondsTotal")
    var secondsTotal: Int? = null,

    @TableField(value = "fitnessNumber")
    var fitnessNumber: Int? = null,

    @TableField(value = "triggerMinVal")
    var triggerMinVal: Int? = null,

    @TableField(value = "triggerMaxVal")
    var triggerMaxVal: Int? = null,

    @TableField(value = "FitnessVal")
    var FitnessVal: JSON? = null
)