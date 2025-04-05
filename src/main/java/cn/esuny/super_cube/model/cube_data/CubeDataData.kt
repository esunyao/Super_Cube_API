package cn.esuny.super_cube.model.cube_data

import cn.esuny.super_cube.constants.core_constant
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data

@Data
@TableName(value = core_constant.CubeDataTableName)
data class CubeDataData(
    @TableId(value = "ID", type = IdType.AUTO) var id: Long? = null,  // bigint in SQL maps to Long in Kotlin

    @TableField(value = "bureauID") var bureauID: String,  // NOT NULL in SQL

    @TableField(value = "chunk") var chunk: Long,  // bigint NOT NULL in SQL

    @TableField(value = "cubeID") var cubeID: CubeSide,  // enum in SQL

    @TableField(value = "data") var data: ByteArray? = null  // mediumblob NULL in SQL
) {
    enum class CubeSide {
        Front, Back, Left, Right, Top, Bottom
    }
}