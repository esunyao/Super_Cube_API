package cn.esuny.super_cube.model.cube_data

import cn.esuny.super_cube.constants.core_constant
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import java.time.LocalDateTime

@Data
@TableName(value = core_constant.CubeBureauTableName)
data class CubeBureauData(
    @TableId(value = "ID", type = IdType.AUTO) var id: Int? = null,

    @TableField(value = "user_id") var user_id: String,

    @TableField(value = "bureauID") var bureauID: String? = null,

    @TableField(value = "startTime") var startTime: LocalDateTime? = null,

    @TableField(value = "totalTime") var totalTime: String? = null,

    @TableField(value = "totalChunk") var totalChunk: Long? = null,
)