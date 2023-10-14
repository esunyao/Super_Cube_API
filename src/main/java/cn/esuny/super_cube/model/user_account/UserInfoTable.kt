package cn.esuny.super_cube.model.user_account

import cn.esuny.super_cube.constants.core_constant
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import java.time.LocalDateTime

@Data
@TableName(value = core_constant.UserInfoTableName)
class UserInfoTable {
    @TableId(value = "ID", type = IdType.AUTO)
    private var id: Int? = null

    @TableField("username")
    private var username: String? = null

    @TableField("user_id")
    private var userId: String? = null

    @TableField("password")
    private var password: String? = null

    @TableField("birthday")
    private var birthday: LocalDateTime? = null

    @TableField("sex")
    private var sex: String? = null

    @TableField("first_name")
    private var firstName: String? = null

    @TableField("second_name")
    private var secondName: String? = null

    @TableField("phone")
    private var phone: Int? = null

    @TableField("create_time")
    private var createTime: LocalDateTime? = null

    constructor(
        id: Int?,
        username: String?,
        userId: String?,
        password: String?,
        birthday: LocalDateTime?,
        sex: String?,
        firstName: String?,
        secondName: String?,
        phone: Int?,
        createTime: LocalDateTime?
    ) {
        this.id = id
        this.username = username
        this.userId = userId
        this.password = password
        this.birthday = birthday
        this.sex = sex
        this.firstName = firstName
        this.secondName = secondName
        this.phone = phone
        this.createTime = createTime
    }
}
