package cn.esuny.super_cube.translation

import cn.esuny.super_cube.SuperCubeApplication
import cn.esuny.super_cube.constants.core_constant
import jakarta.annotation.Nullable
import org.springframework.beans.factory.config.YamlMapFactoryBean
import org.springframework.core.io.ClassPathResource

object language {
    fun LoadLanguage() {
        val yamlMapFactoryBean = YamlMapFactoryBean()
        //可以加载多个yml文件
        //可以加载多个yml文件
        yamlMapFactoryBean.setResources(ClassPathResource("language/" + core_constant.DEFAULT_LANGUAGE + core_constant.LANGUAGE_FILE_SUFFIX))
        //通过getObject()方法获取Map对象
        //通过getObject()方法获取Map对象
        SuperCubeApplication.language = yamlMapFactoryBean.getObject()
    }
    fun tr(translation_key: String, vararg args: Any?): String{
        val res: String = String.format(SuperCubeApplication.language.get(translation_key).toString(), args = args)
        if(res.equals("null"))
            SuperCubeApplication.logger.error(String.format("Translation key \"%s\" not found with language \"%s\"", translation_key, core_constant.DEFAULT_LANGUAGE))
        return res;
    }
}