package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.MenuMapper;
import cn.codingjc.vhr2021.mapper.RoleMapper;
import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/2/7 3:57 下午
 */
@Service
public class PermissService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;


    public List<Role> list() {
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
