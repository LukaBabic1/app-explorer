package com.hr.babic.domain.util;

import java.util.Comparator;
import java.util.List;

public interface ListUtils {

    <T extends Comparable<? super T>> List<T> sort(List<T> list);

    <T> List<T> sort(List<T> list, Comparator<? super T> comparator);
}
