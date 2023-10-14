package cn.esuny.super_cube.model.user_account

import cn.esuny.super_cube.constants.core_constant
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data


@Data
@TableName(value = core_constant.AccountTableName)
open class AccountTable_ACK {
    @TableId(value = "id", type = IdType.AUTO)
    private var id: Int? = null

    @TableField("account")
    private var account: String? = null

    @TableField("passwd")
    private var passwd: String? = null

    constructor(id: Int?, account: String?, passwd: String?) {
        this.id = id
        this.account = account
        this.passwd = passwd
    }
}