package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.MenuMapper;
import cn.codingjc.vhr2021.model.Hr;
import cn.codingjc.vhr2021.model.Menu;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.Role;
import cn.codingjc.vhr2021.model.common.WeatherBean;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2021/10/22 10:06 下午
 */
@Service
public class MenuService {

    private static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RestTemplate restTemplate;

    public List<Menu> getMenusByHrId(Integer id) {
        List<Menu> menus = menuMapper.getMenusByHrId(id);
        return menus;
    }

    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

    public Object queryWeather() {
        String url = "http://t.weather.itboy.net/api/weather/city/101210101";
        ResponseEntity<WeatherBean> responseEntity = restTemplate.getForEntity(url, WeatherBean.class);
        System.out.println(JSON.toJSONString(responseEntity.getBody()));
        return RespBean.ok(null, responseEntity.getBody());
    }
}
