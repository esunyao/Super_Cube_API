package cn.esuny.super_cube.Mapper;

import cn.esuny.super_cube.model.user_account.Account_Table;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<Account_Table> {
}