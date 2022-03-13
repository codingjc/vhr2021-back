package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.DepartmentMapper;
import cn.codingjc.vhr2021.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/2/13 7:47 下午
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> list() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }
}
