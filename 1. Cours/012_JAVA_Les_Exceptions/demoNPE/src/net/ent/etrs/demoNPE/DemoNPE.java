package net.ent.etrs.demoNPE;

public class DemoNPE {

    public static void main(String[] args) {

        ClasseB b = new ClasseB();
        ClasseC c = new ClasseC(b);

        System.out.println(c.cB.cA.getNom());

    }
}
