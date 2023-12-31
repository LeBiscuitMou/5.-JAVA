package net.ent.etrs.poeleague.model.commons;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    private Utils() {
    }

    public static <T> List<T> iterableToList(Iterable<T> iterable) {
        List<T> result = new ArrayList<T>();
        for (T t : iterable) {
            result.add(t);
        }
        return result;
    }
}
