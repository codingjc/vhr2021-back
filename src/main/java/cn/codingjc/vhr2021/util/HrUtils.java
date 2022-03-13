package cn.codingjc.vhr2021.util;


import cn.codingjc.vhr2021.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author shenjicheng
 * @create 2022/2/21 10:28 下午
 */
public class HrUtils {

    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
