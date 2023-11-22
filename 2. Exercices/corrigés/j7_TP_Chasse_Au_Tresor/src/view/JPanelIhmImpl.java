package view;

import javax.swing.*;

public final class JPanelIhmImpl extends AbstractIhm {


    @Override
    public void afficher(String msg) {
        //String nomClasse = this.getClass().getSimpleName();
        JOptionPane.showMessageDialog(null,msg);
    }

    @Override
    public int saisirEntier(String msg) {
        String str = JOptionPane.showInputDialog(msg);
        int nbSaisi = Integer.parseInt(str);

        return nbSaisi;
    }

    @Override
    public int saisirEntierBorne(String msg, int mini, int maxi)  {
        return super.saisirEntierBorne(msg,mini,maxi);
    }
}
