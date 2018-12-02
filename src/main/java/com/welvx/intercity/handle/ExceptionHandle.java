package com.welvx.intercity.handle;

import com.welvx.intercity.entity.Result;
import com.welvx.intercity.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(Exception e){
        return ResultUtil.error(100,e.getMessage());
    }
}
