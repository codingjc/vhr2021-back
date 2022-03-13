package cn.codingjc.vhr2021.controller.system.basic;

import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.Role;
import cn.codingjc.vhr2021.service.PermissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{rid}")
    public List<Integer> getMemuIdByRid(@PathVariable("rid") int rid){
        return permissService.getMemuIdByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids){
        return permissService.updateMenuRole(rid, mids);
    }

    @PostMapping("/")
    public RespBean addMenuRole(@RequestBody Role role){
        if (permissService.addMenuRole(role) == 1) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable("rid") Integer rid){
        if (permissService.deleteRole(rid) == 1) {
            return RespBean.ok("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }
}
