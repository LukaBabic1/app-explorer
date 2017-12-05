package com.hr.babic.domain.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ListUtilsImpl implements ListUtils {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(final List<T> list) {
        Collections.sort(list);

        return list;
    }

    @Override
    public <T> List<T> sort(final List<T> list, final Comparator<? super T> comparator) {
        Collections.sort(list, comparator);

        return list;
    }
}
