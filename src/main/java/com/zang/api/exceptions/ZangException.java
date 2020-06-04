package com.zang.api.exceptions;

import org.codehaus.jackson.annotate.JsonProperty;

public class ZangException extends Exception {

    private static final long serialVersionUID = -5937845116814343506L;

    private Integer status;
    private Integer code;
    @JsonProperty(value = "more_info")
    private String moreInfo;
    private Exception innerException;

    public ZangException(String message, Exception ex) {
        super(message);
        this.innerException = ex;
    }

    public ZangException(String message) {
        super(message);
    }

    public ZangException(Integer status, String message, Integer code, String moreInfo) {
        super(message);
        this.status = status;
        this.code = code;
        this.moreInfo = moreInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Exception getInnerException() {
        return innerException;
    }

    public void setInnerException(Exception innerException) {
        this.innerException = innerException;
    }
}
