package com.dyplom.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtil {
    public static String getIdentifier(final long id, final String abbr) {
        return abbr + getAppendZeroString(id, 8);
    }
    private static String getAppendZeroString(final Long value, final int size) {
        StringBuilder string = new StringBuilder(value.toString());
        int length = string.length();
        for (int i = 0; i < size - length; i++)
            string.insert(0, "0");
        return string.toString();
    }

}
