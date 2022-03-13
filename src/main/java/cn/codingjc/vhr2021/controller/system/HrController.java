package cn.codingjc.vhr2021.controller.system;

import cn.codingjc.vhr2021.model.Hr;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/2/21 10:24 下午
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @GetMapping("/")
    public List<Hr> getAllHrs(){
        return hrService.getAllHrs(null);
    }

    @PutMapping("/")
    public RespBean update (@RequestBody Hr hr) {
        if (hrService.update(hr) == 1) {
            return RespBean.ok("修改成功");
        } else {
            return RespBean.error("修改失败");
        }
    }
}
