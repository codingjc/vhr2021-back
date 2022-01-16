package cn.codingjc.vhr2021.controller;

import cn.codingjc.vhr2021.model.Hr;
import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2021/10/22 10:01 下午
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    /**
     * 根据用户角色获取菜单集合
     * @return
     */
    @GetMapping("/menu")
     public List<Menu> getMenusByHrId () {
        return menuService.getMenusByHrId(((Hr) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId());
     }
}
