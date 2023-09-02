package com.hss.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 通用返回对象
 * </p>
 *
 * @author Hss
 * @date 2023-09-02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObj {

    /**
     * 返回标记 0成功 -1失败
     */
    private Integer code;

    /**
     * 提示
     */
    private String message;

    /**
     * 业务信息
     */
    private Object data;

    /**
     * 失败
     * @param message
     * @return
     */
    public static ResultObj fail(String message){
        return new ResultObj(-1,message,null);
    }

    /**
     * 成功
     * @param message
     * @return
     */
    public static ResultObj successByMsg(String message){
        return success(message,null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultObj successByData(Object data){
        return success(null,data);
    }

    /**
     * 成功
     * @param message
     * @param data
     * @return
     */
    public static ResultObj success(String message,Object data){
        return new ResultObj(0,message,data);
    }
}
