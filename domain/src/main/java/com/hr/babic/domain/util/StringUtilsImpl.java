package com.hr.babic.domain.util;

public final class StringUtilsImpl implements StringUtils {

    @Override
    public boolean isEmpty(final String text) {
        return text == null || text.length() == 0;
    }
}

