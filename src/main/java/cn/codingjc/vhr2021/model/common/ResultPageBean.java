package cn.codingjc.vhr2021.model.common;

import java.util.List;

/**
 * @author shenjicheng
 * @create 2022/1/30 2:04 下午
 */
public class ResultPageBean<T> {

    /**
     * 总数
     */
    private long totalNum;

    /**
     * 结果
     */
    private List<T> data;

    public ResultPageBean(long totalNum, List<T> data) {
        this.totalNum = totalNum;
        this.data = data;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
