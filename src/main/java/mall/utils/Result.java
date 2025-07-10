package mall.utils;

import java.io.Serializable;

public class Result<T> implements Serializable {
    /**
     * 是否响应成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 错误信息
     */
    private String message;

    // 构造器开始
    /**
     * 无参构造器(构造器私有，外部不可以直接创建)
     */
    private Result() {
        this.code = 200;
        this.success = true;
    }
    /**
     * 有参构造器
     * @param obj
     */
    private Result(T obj) {
        this.code = 200;
        this.data = obj;
        this.success = true;
    }

    /**
     * 有参构造器
     * @param resultCode
     */
    private Result(ResultCodeEnum resultCode) {
        this.success = false;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * 有参构造器
     * @param resultCode
     * @param message
     */
    private Result(ResultCodeEnum resultCode,String message) {
        this.success = false;
        this.code = resultCode.getCode();
        this.message = message;
    }


    /**
     * 通用返回成功（没有返回结果）
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(){
        return new Result();
    }

    /**
     * 返回成功（有返回结果）
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 通用返回失败
     * @param resultCode
     * @param <T>
     * @return
     */
    public static<T> Result<T> failure(ResultCodeEnum resultCode){
        return  new Result<T>(resultCode);
    }

    /**
     * 通用返回失败
     * @param resultCode
     * @param message
     * @param <T>
     * @return
     */
    public static<T> Result<T> failure(ResultCodeEnum resultCode,String message){
        return  new Result<T>(resultCode,message);
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
