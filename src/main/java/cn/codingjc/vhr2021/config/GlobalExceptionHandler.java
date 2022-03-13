package cn.codingjc.vhr2021.config;

import cn.codingjc.vhr2021.model.RespBean;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * Global exception handler
 * @author shenjicheng
 * @create 2022/2/1 2:05 PM
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean handlerMySQLException(SQLException e){
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            e.printStackTrace();
            return RespBean.error("当前数据被绑定，不可删除！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
}
