package com.allen.util;

/**
 * @author Allen
 * @date 2021/5/21 21:57
 */
public enum LogEnum {
    /*
     *
     * @author allen
     * @date 2021/5/21 22:13
     * @param 本地日志枚举
     * @return null
     */

    BUSSINESS("bussiness"),

    PLATFORM("platform"),

    DB("db"),

    EXCEPTION("exception"),

    ;


    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
