package cn.codingjc.vhr2021.controller;

import cn.codingjc.vhr2021.model.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjicheng
 * @create 2021/6/21 11:34 下午
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登陆，请登录");
    }
}
