/*
 * Copyright (c) 2016-2017 by Colley
 * All rights reserved.
 */
package Util;

public enum DFormatEnum {
	YYYYMMDD("yyyyMMdd"), 
	YYYYMMDDHHMMSS("yyyyMMddHHmmss"), 
	YYMMDDHHMMSS("yyMMddHHmmss"), 
    YYYY_MM_DDHH_MM_SS("yyyy-MM-dd HH:mm:ss"), 
    YYYY_MM_DD("yyyy-MM-dd"), 
    YYMMDD("yyMMdd"), 
    HHMMSS("HHmmss"), 
    HH_MM_SS("HH:mm:ss"), 
    YYYYMM("yyyyMM"), 
    YYYY_MM("yyyy-MM"), 
    YYMM("yyMM"),
    YYYYMMDD_DOT("yyyy.MM.dd");

    public String pattern;
    DFormatEnum(String pattern) {
        this.pattern = pattern;
    }

    private static DFormatEnum getDefaultEnum() {
        return YYYY_MM_DDHH_MM_SS;
    }

    public static String DATA_FORMAT_DEFAULT = getDefaultEnum().pattern;
}
