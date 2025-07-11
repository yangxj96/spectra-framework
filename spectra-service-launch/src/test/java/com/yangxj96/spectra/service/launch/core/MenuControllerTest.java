package com.yangxj96.spectra.service.launch.core;

import com.yangxj96.spectra.service.core.javabean.entity.Menu;
import com.yangxj96.spectra.service.core.service.MenuService;
import com.yangxj96.spectra.service.launch.SpectraApplication;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.Arrays;

/**
 * 菜单接口单元测试
 *
 * @author Jack Young
 * @version 1.0
 * @since 2025-6-14
 */
@SpringBootTest(classes = SpectraApplication.class)
class MenuControllerTest {

    @Resource
    private MenuService menuService;

    @DynamicPropertySource
    static void jasyptProperties(DynamicPropertyRegistry registry) {
        Dotenv dotenv = Dotenv.configure().directory("../.env").load();
        String jasyptPassword = dotenv.get("JASYPT_ENCRYPTOR_PASSWORD");
        registry.add("jasypt.encryptor.password", () -> jasyptPassword);
    }

    // 插入父级
    @Test
    void insertMenu() {
        var parent = Arrays.asList(
                // 1929928379575111682
                Menu.builder()
                        .pid(0L)
                        .icon("icon-setting")
                        .name("系统管理")
                        .path("/system")
                        .component("layout")
                        .layout("layout")
                        .build(),
                // 1929928379667386370
                Menu.builder()
                        .pid(0L)
                        .icon("icon-setting")
                        .name("组件示例")
                        .path("/example")
                        .component("layout")
                        .layout("layout")
                        .build()
        );
        var f = menuService.saveBatch(parent);
        Assertions.assertTrue(f, "插入失败");
    }

    // 插入子级
    @Test
    void insertMenu2() {
        var parent = Arrays.asList(
                // 系统管理下级
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("用户管理").path("user")
                        .component("/System/User/index").build(),
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("角色管理").path("role")
                        .component("/System/Role/index").build(),
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("权限管理").path("power")
                        .component("/System/Power/index").build(),
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("字典管理").path("dict")
                        .component("/System/Dict/index").build(),
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("定时任务").path("task")
                        .component("/System/Task/index").build(),
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("菜单管理").path("menu")
                        .component("/System/Menu/index").build(),
                Menu.builder().pid(1929928379575111682L)
                        .icon("icon-setting-role").name("文件存储").path("storage")
                        .component("/System/Storage/index").build(),
                // 组件示例下级
                Menu.builder().pid(1929928379667386370L)
                        .icon("icon-setting-role").name("图表示例").path("echarts")
                        .component("/Example/Echarts/index").build(),
                Menu.builder().pid(1929928379667386370L)
                        .icon("icon-setting-role").name("列表示例").path("table")
                        .component("/Example/Table/index").build(),
                Menu.builder().pid(1929928379667386370L)
                        .icon("icon-setting-role").name("表单示例").path("form")
                        .component("/Example/Form/index").build()
        );
        var f = menuService.saveBatch(parent);
        Assertions.assertTrue(f, "插入失败");
    }

}
