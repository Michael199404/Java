package com.chao.genericity;

import java.util.ArrayList;
import java.util.Collection;

public class TestGenericMethod {

    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for(T o : a) {
            c.add(o);
        }
    }

}
