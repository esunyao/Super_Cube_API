package cn.esuny.super_cube.controller.weixin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

class WXController {
    @GetMapping("/wx")
    fun wx(@RequestParam info: String): String {
        // 这里的 appId 和 path 应该替换为你的小程序的实际 appId 和路径
        val appId = "wxcf381a11b2490818"
        val path = "pages/login/login"
        return """
            <html>
            <body>
            <script type="text/javascript">
            // 当页面加载完成后，跳转到小程序
            window.onload = function() {
                wx.miniProgram.navigateTo({url: '/${path}?info=${info}'});
            }
            </script>
            </body>
            </html>
        """.trimIndent()
    }
}