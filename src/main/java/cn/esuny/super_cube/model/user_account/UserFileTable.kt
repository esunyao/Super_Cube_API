package cn.esuny.super_cube.model.user_account

import lombok.Data

@Data
data class UserFileTable(
    var first_name: String,
    var second_name: String,
    var age: Int,
    var sex: String,
    var weigh: Int,
//    var create_time: LocalDateTime?
)