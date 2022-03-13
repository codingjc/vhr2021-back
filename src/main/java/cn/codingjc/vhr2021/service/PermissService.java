package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.MenuMapper;
import cn.codingjc.vhr2021.mapper.MenuRoleMapper;
import cn.codingjc.vhr2021.mapper.RoleMapper;
import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private MenuRoleMapper menuRoleMapper;


    public List<Role> list() {
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMemuIdByRid(int rid) {
        return menuMapper.getMidByRid(rid);
    }

    /**
     * update menu by rid
     * @param rid
     * @param mids
     * @return
     */
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        int i = menuRoleMapper.insertRecord(rid, mids);
        if (mids.length == i) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    public int addMenuRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insertSelective(role);
    }

    @Transactional
    public int deleteRole(Integer rid) {
        try {
            roleMapper.deleteByPrimaryKey(rid);
            menuRoleMapper.deleteByRid(rid);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }
}
