package cn.esuny.super_cube.model.user_account;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_user")
public class Account_Table {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    @TableField("account")
    private String name;
    @TableField("password")
    private String password;
}
