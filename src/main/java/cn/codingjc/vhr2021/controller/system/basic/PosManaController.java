package cn.codingjc.vhr2021.controller.system.basic;

import cn.codingjc.vhr2021.model.Position;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.common.PageBean;
import cn.codingjc.vhr2021.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenjicheng
 * @create 2022/1/29 12:06 上午
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PosManaController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/list")
    public Object list(@RequestBody PageBean pageBean){
        return positionService.getPositionList(pageBean);
    }

    @PostMapping("/add")
    public RespBean add(@RequestBody Position position){
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("职位名称已存在！");
        }
    }

    @PutMapping("/")
    public RespBean update(@RequestBody Position position){
        if (positionService.update(position) == 1) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @DeleteMapping("/")
    public RespBean delete(@RequestParam("id") Integer id) {
        if (positionService.delete(id) == 1) {
            return RespBean.ok("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }

    @DeleteMapping("/batch")
    public RespBean deleteBatch(Integer [] ids){
        if(positionService.deleteBatch(ids) == ids.length){
            return RespBean.ok("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }

}
