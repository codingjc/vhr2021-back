package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.MenuMapper;
import cn.codingjc.vhr2021.model.Hr;
import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2021/10/22 10:06 下午
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getMenusByHrId(Integer id) {
        List<Menu> menus = menuMapper.getMenusByHrId(id);
        return menus;
    }

    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

}
