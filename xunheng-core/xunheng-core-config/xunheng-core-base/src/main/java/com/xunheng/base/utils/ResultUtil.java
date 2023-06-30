package com.xunheng.base.utils;

import com.xunheng.base.vo.ResultVO;

public class ResultUtil<T> {

    private ResultVO<T> result;

    public ResultUtil(){
        result=new ResultVO<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(200);
    }

    public ResultVO<T> setData(T t){
        this.result.setData(t);
        this.result.setCode(200);
        return this.result;
    }

    public ResultVO<T> setDataWithPermission(T t, String permissionLevel){
        this.result.setData(t);
        this.result.setCode(200);
        return this.result;
    }

    public ResultVO<T> setSuccessMsg(String msg){
        this.result.setSuccess(true);
        this.result.setMessage(msg);
        this.result.setCode(200);
        this.result.setData(null);
        return this.result;
    }

    public ResultVO<T> setData(T t, String msg){
        this.result.setData(t);
        this.result.setCode(200);
        this.result.setMessage(msg);
        return this.result;
    }

    public ResultVO<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(500);
        return this.result;
    }

    public ResultVO<T> setErrorMsg(Integer code, String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(code);
        return this.result;
    }

    public static <T> ResultVO<T> data(T t){
        return new ResultUtil<T>().setData(t);
    }

    public static <T> ResultVO<T> data(T t, String msg){
        return new ResultUtil<T>().setData(t, msg);
    }

    public static <T> ResultVO<T> success(String msg){
        return new ResultUtil<T>().setSuccessMsg(msg);
    }

    public static <T> ResultVO<T> error(String msg){
        return new ResultUtil<T>().setErrorMsg(msg);
    }

    public static <T> ResultVO<T> error(Integer code, String msg){
        return new ResultUtil<T>().setErrorMsg(code, msg);
    }
}
