package cn.esuny.super_cube.model.user_account

import cn.esuny.super_cube.constants.core_constant
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import java.io.Serializable
import java.time.LocalDateTime

@Data
@TableName(value = core_constant.UserInfoTableName)
data class UserInfoTable(
    @TableId(value = "ID", type = IdType.AUTO)
    var id: Int? = null,

    @TableField("username")
    var username: String? = null,

    @TableField("user_id")
    var userId: String? = null,

    @TableField("password")
    var password: String? = null,

    @TableField("birthday")
    var birthday: LocalDateTime? = null,

    @TableField("sex")
    var sex: String? = null,

    @TableField("first_name")
    var firstName: String? = null,

    @TableField("second_name")
    var secondName: String? = null,

    @TableField("phone")
    var phone: Int? = null,

    @TableField("create_time")
    var createTime: LocalDateTime? = null,
)