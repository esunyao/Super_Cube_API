package cn.esuny.super_cube.model.user_account

import cn.esuny.super_cube.constants.core_constant
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import java.time.LocalDateTime

@Data
@TableName(value = core_constant.UserAuthTableName)
open class UserAuthTable {
    @TableId(value = "ID", type = IdType.AUTO)
    private var id: Int? = null

    @TableField("user_id")
    private var userId: String? = null

    @TableField("identity")
    private var identity: String? = null

    @TableField("token")
    private var token: String? = null

    @TableField("token_create_time")
    private var tokenCreateTime: LocalDateTime? = null

    @TableField("IFVERIFIED")
    private var ifVerified: String? = null

    @TableField("identity_type")
    private var identityType: String? = null

    constructor(id: Int?, userId: String?, identity: String?, token: String?, tokenCreateTime: LocalDateTime?, ifVerified: String?, identityType: String?) {
        this.id = id
        this.userId = userId
        this.identity = identity
        this.token = token
        this.tokenCreateTime = tokenCreateTime
        this.ifVerified = ifVerified
        this.identityType = identityType
    }
}
