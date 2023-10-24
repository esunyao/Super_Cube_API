package cn.esuny.super_cube.translation

import cn.esuny.super_cube.SuperCubeApplication
import cn.esuny.super_cube.constants.core_constant
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
}