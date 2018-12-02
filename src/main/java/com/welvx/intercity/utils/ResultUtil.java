package com.welvx.intercity.utils;

import com.welvx.intercity.entity.Result;
import com.welvx.intercity.enums.ResultEnum;

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(ResultEnum.UNKONW_ERROR.getCode());
        result.setMsg(ResultEnum.UNKONW_ERROR.getMsg());
        result.setData(null);
        return result;
    }

    public static Result result(ResultEnum resultEnum,Object object){
        Result result=new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static Result result(ResultEnum resultEnum){
        return result(resultEnum,null);
    }

}
