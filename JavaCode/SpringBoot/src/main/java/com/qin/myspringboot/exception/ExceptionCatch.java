package com.qin.myspringboot.exception;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionCatch {
    /**
     * 自定义异常的捕获方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public String customException(MyException e) {

        //记录日志
        log.error("catch exception : {}\r\nexception: ", e.getMessage(), e);

        //返回结果
        return "出自定义异常了，哈，哈，哈";
    }

    /**
     * 自定义异常的捕获方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String globalException(Exception e) {

        //记录日志
        log.error("catch exception : {}\r\nexception: ", e.getMessage(), e);

        //返回结果
        return "出全局异常了，哈，哈，哈";
    }


}
