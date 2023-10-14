package cn.esuny.super_cube.Mapper.user_account;

import cn.esuny.super_cube.model.user_account.AccountTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<AccountTable> {
}