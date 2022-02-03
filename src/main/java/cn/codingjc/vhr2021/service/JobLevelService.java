package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.JobLevelMapper;
import cn.codingjc.vhr2021.model.JobLevel;
import cn.codingjc.vhr2021.model.Position;
import cn.codingjc.vhr2021.model.RespBean;
import cn.codingjc.vhr2021.model.common.PageBean;
import cn.codingjc.vhr2021.model.common.ResultPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/2/2 4:14 PM
 */
@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;

    /**
     * Select list by page
     * @param pageBean
     * @return
     */
    public ResultPageBean list(PageBean pageBean) {
        int pageNum = pageBean.getPageNum();
        int pageSize = pageBean.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Page<JobLevel> page = (Page<JobLevel>) jobLevelMapper.getAllJobLevels();
        long totalNum = page.getTotal();
        List<JobLevel> result = page.getResult();
        ResultPageBean resultPageBean = new ResultPageBean(totalNum, result);
        return resultPageBean;
    }

    /**
     * Add a jobLevel
     * @param jobLevel
     * @return
     */
    public int add(JobLevel jobLevel) {
        List<JobLevel> jobLevels = jobLevelMapper.getJobLevelByName(jobLevel.getName());
        if (jobLevels.size() > 1) {
            return -1;
        }
        jobLevel.setEnabled(true);
        jobLevel.setCreateDate(new Date());
        return jobLevelMapper.insertSelective(jobLevel);
    }

    /**
     * Update a joblevel
     * @param jobLevel
     * @return
     */
    public int update(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    /**
     * Delete a joblevel by id
     * @param id
     * @return
     */
    public int delete(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    /**
     * Delete joblevels batch
     * @param ids
     * @return
     */
    public int deleteBatch(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }
}
