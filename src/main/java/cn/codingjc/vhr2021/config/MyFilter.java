package cn.codingjc.vhr2021.config;

import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.Role;
import cn.codingjc.vhr2021.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 用户传来的请求地址，分析出请求需要的角色
 * @author shenjicheng
 * @create 2021/12/26 9:26 下午
 */
@Configuration
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenus = menuService.getAllMenusWithRole();
        for (Menu menu : allMenus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleName = new String[roles.size()];
                for (int i = 0; i < roleName.length; i++) {
                    roleName[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleName);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
