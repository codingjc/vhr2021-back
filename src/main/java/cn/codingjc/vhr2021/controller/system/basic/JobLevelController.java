package cn.codingjc.vhr2021.controller.system.basic;

import cn.codingjc.vhr2021.model.JobLevel;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.common.PageBean;
import cn.codingjc.vhr2021.model.common.ResultPageBean;
import cn.codingjc.vhr2021.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenjicheng
 * @create 2022/2/2 4:11 PM
 */
@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {

    @Autowired
    private JobLevelService jobLevelService;

    /**
     * query list by page
     * @param pageBean
     * @return
     */
    @PostMapping("/list")
    public ResultPageBean list(@RequestBody PageBean pageBean){
        return jobLevelService.list(pageBean);
    }

    /**
     * Add a jobLevel
     * @param jobLevel
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody JobLevel jobLevel) {
        if(jobLevelService.add(jobLevel) == 1){
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("职称名称已存在，添加失败！");
        }
    }

    /**
     * Update a joblevel
     * @param jobLevel
     * @return
     */
    @PutMapping("/")
    public RespBean update(@RequestBody JobLevel jobLevel){
        if(jobLevelService.update(jobLevel) == 1){
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    /**
     * Delete a joblevel by id
     * @param id
     * @return
     */
    @DeleteMapping("/")
    public RespBean delete(@RequestParam Integer id){
        if(jobLevelService.delete(id) == 1){
            return RespBean.ok("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }

    /**
     * Delete joblevels batch
     * @param ids
     * @return
     */
    @DeleteMapping("/batch")
    public RespBean deleteBatch(Integer[] ids){
        if(jobLevelService.deleteBatch(ids) == ids.length){
            return RespBean.ok("批量删除成功");
        } else {
            return RespBean.error("批量删除失败");
        }
    }
}
