package cn.codingjc.vhr2021.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 判断当前用户是否具备请求所需的角色
 * @author shenjicheng
 * @create 2022/1/3 9:59 下午
 */
@Configuration
public class MyDecisionManager implements AccessDecisionManager {

    //
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : collection) {
            // 需要的角色
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                // 当前用户是匿名用户
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登陆，请登录");
                }
                return;
            }
            // 获取当前登陆的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                     return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
