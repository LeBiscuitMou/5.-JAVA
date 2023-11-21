package net.ent.etrs.rafale.start;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> t = new ArrayList<>(5);
        System.out.println(t.size());
        t.add("a");
        t.add("b");
        System.out.println(t.size());
        t.add("b");
        System.out.println(t.size());
    }
}
