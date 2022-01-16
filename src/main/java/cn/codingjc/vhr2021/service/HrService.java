package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.HrMapper;
import cn.codingjc.vhr2021.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author shenjicheng
 * @create 2021/6/14 10:34 下午
 */
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(userName);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.setHrRolesByHrid(hr.getId()));
        return hr;
    }
}
