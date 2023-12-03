package view;

import java.util.Scanner;

public final class ConsoleIhmImpl extends AbstractIhm{

    private Scanner scan = new Scanner(System.in);

    @Override
    public void afficher(String msg) {

        System.out.println(msg);
    }

    @Override
    public int saisirEntier(String msg) {
        return scan.nextInt();
    }

    @Override
    public int saisirEntierBorne(String msg, int mini, int maxi)  {
       return super.saisirEntierBorne(msg,mini,maxi);
    }
}
