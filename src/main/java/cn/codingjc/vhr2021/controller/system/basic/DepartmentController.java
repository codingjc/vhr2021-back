package cn.codingjc.vhr2021.controller.system.basic;

import cn.codingjc.vhr2021.model.Department;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/2/13 7:46 下午
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> list () {
        return departmentService.list();
    }
}
