package cn.esuny.super_cube.service.user_account.impl

import cn.esuny.super_cube.Mapper.user_account.UserInfoMapper
import cn.esuny.super_cube.model.user_account.UserInfoTable
import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service


//@Component
@Service
open class LoginMySQLInfoServiceImpl : ServiceImpl<UserInfoMapper, UserInfoTable?>(), LoginMySQLInfoService{
}