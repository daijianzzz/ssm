package com.test.domain;

public class Code {
    private Code() {}

    // 定义变量
    public static final int QUERY_OK = 2001;
    public static final int QUERY_FAIL = 2002;
    public static final int SAVE_OK = 2003;
    public static final int SAVE_FAIL = 2004;
    public static final int UPDATE_OK = 2005;
    public static final int UPDATE_FAIL = 2006;
    public static final int DELETE_OK = 2007;
    public static final int DELETE_FAIL = 2008;
    public static final int LOGIN_OK = 2009;
    public static final int LOGIN_FAIL = 2010;
    // 业务异常系列
    public static final int OPERATOR_EXCEPTION = 5001;
    // 系统异常系列
    public static final int SYSTEM_EXCEPTION = 5000;
    // 未知
    public static final int OTHER_EXCEPTION = 5002;

}
