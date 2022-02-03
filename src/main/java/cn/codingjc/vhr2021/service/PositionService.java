package cn.codingjc.vhr2021.service;

import cn.codingjc.vhr2021.mapper.PositionMapper;
import cn.codingjc.vhr2021.model.Position;
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
 * @create 2022/1/29 12:11 上午
 */
@Service
public class PositionService {

    @Autowired
    private PositionMapper positionMapper;

    /**
     * Query positions by page
     * @return
     */
    public Object getPositionList(PageBean pageBean) {
        int pageNum = pageBean.getPageNum();
        int pageSize = pageBean.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        Page<Position> page = (Page<Position>) positionMapper.getAllPositions();
        long totalNum = page.getTotal();
        List<Position> result = page.getResult();
        ResultPageBean resultPageBean = new ResultPageBean(totalNum, result);
        return resultPageBean;
    }

    /**
     * Add position
     * @param position
     * @return
     */
    public int addPosition(Position position) {
        List<Position> positions = positionMapper.selectByName(position.getName());
        if (positions.size() > 0) {
            return -1;
        }
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    /**
     * update position
     * @param position
     * @return
     */
    public int update(Position position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    /**
     * delete position
     * @param id
     * @return
     */
    public int delete(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    /**
     * Delete positions batch
     * @param ids
     * @return
     */
    public int deleteBatch(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
