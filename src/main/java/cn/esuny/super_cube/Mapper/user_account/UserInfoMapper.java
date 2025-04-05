package cn.esuny.super_cube.Mapper.user_account;

import cn.esuny.super_cube.model.user_account.UserInfoTable;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("sports")
public interface UserInfoMapper extends BaseMapper<UserInfoTable> {
}