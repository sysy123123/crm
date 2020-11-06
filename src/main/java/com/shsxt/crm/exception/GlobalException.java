package com.shsxt.crm.exception;

import com.shsxt.crm.base.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultInfo exce(Exception e){
        System.out.println("已经进入全局异常处理");
        ResultInfo info = new ResultInfo();
        if(e instanceof ParamsException){
            info.setCode(500);
            info.setMsg("参数异常");
            info.setResult(((ParamsException) e).getMsg());
        }else if(e instanceof MyException){
           info.setCode(501);
           info.setMsg("自定义异常");
           info.setResult(((MyException) e).getMsg());
        }else if(e instanceof NullPointerException){
            info.setCode(503);
            info.setMsg("空指针异常");
        }

        return info;
    }






}
