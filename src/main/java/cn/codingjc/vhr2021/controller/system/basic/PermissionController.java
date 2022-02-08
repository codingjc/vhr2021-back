package cn.codingjc.vhr2021.controller.system.basic;

import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.Role;
import cn.codingjc.vhr2021.service.PermissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/2/3 10:43 下午
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {

    @Autowired
    private PermissService permissService;

    @GetMapping("/")
    public List<Role> list(){
        return permissService.list();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return permissService.getAllMenus();
    }
}
