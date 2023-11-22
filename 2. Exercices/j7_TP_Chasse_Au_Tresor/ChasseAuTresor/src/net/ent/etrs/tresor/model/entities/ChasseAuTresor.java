package net.ent.etrs.tresor.model.entities;

public class ChasseAuTresor {
    private Carte laCarte;
    private Deplacant[] tabJoueurs;

    public ChasseAuTresor() {
        initialiserLeJeu();
    }

    public Carte getLaCarte() {
        return laCarte;
    }

    public void setLaCarte(Carte laCarte) {
        this.laCarte = laCarte;
    }

    public Deplacant[] getTabJoueurs() {
        return tabJoueurs;
    }

    public void setTabJoueurs(Deplacant[] tabJoueurs) {
        this.tabJoueurs = tabJoueurs;
    }

    @Override
    public String toString() {
        return "ChasseAuTresor{" +
                "laCarte=" + laCarte +
                '}';
    }

    private void initialiserLeJeu() {

    }
}