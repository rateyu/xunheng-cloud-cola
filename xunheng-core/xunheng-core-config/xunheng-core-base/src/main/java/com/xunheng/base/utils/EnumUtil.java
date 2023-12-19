package com.xunheng.base.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @ClassName EnumUtil
 * @Description
 * @Author hhqkkr
 * @Date 2023/7/28 19:24
 */
@Slf4j
public class EnumUtil {

    public static <T extends Enum<T>> T getMyEnum(Class<T> enumType, int val) {
        return getMyEnum(enumType, val, null);
    }

    public static <T extends Enum<T>> T getMyEnum(Class<T> enumType, int val, T defaultT) {
        T ret = defaultT;
        try {
            T[] myEnums = enumType.getEnumConstants();
            Field fl = enumType.getDeclaredField("val");
            if(myEnums != null && myEnums.length > 0) {
                for(T t : myEnums) {
                    try {
                        int enumInt = fl.getInt(t);
                        if(val == enumInt) {
                            ret = t;
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                       e.printStackTrace();
                    } catch (IllegalAccessException e) {
                       e.printStackTrace();
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
