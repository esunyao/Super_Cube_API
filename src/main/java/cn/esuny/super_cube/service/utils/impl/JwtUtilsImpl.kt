package cn.esuny.super_cube.service.utils.impl

import cn.esuny.super_cube.service.user_account.LoginMySQLInfoService
import cn.esuny.super_cube.service.utils.JwtUtils
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
open class JwtUtilsImpl : JwtUtils {
    @Autowired
    var loginMySQLInfoService: LoginMySQLInfoService? = null

    override fun createToken(UserID: String?, userName: String?, passwd: String?): String {
        val header: MutableMap<String, Any> = HashMap()
        header["typ"] = "JWT"
        header["alg"] = "HS256"
        //setID:用户ID
        //setExpiration:token过期时间  当前时间+有效时间
        //setSubject:用户名
        //setIssuedAt:token创建时间
        //signWith:加密方式
        val builder = Jwts.builder().setHeader(header)
            .setId(UserID)
            .setExpiration(Date(System.currentTimeMillis() + JwtUtils.EXPIRE_TIME))
            .setSubject(userName)
            .claim("passwd", passwd)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS256, JwtUtils.KEY)
        return builder.compact()
    }

    override fun verify(token: String?): Boolean? {
        var claims: Claims? = null
        claims = try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            Jwts.parser().setSigningKey(JwtUtils.KEY).parseClaimsJws(token).body
        } catch (e: ExpiredJwtException) {
            return null
        }
        if (claims == null)
            return null
        return true
//        val qw: QueryWrapper<UserInfoTable> = QueryWrapper<UserInfoTable>()
//        qw.eq("user_id", claims.id)
//        qw.eq("username", claims.subject)
//        qw.eq("password", claims.get("passwd"))
//        val res: UserInfoTable? = loginMySQLInfoService?.getOne(qw)
//        return res
    }
}