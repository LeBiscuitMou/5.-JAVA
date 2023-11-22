package start;

import model.FacadeMetier;
import model.exceptions.EquipageException;
import model.exceptions.FacadeMetierException;
import model.exceptions.ScoreException;
import presenter.Presenter;
import presenter.exceptions.PresenterException;
import view.ConsoleIhmImpl;
import view.Ihm;

public class Lanceur {
    public static void main(String[] args) {

        try { //1) MEP de la vue
            Ihm vue = new ConsoleIhmImpl();
            //2) MEP de la Facade Metier
            FacadeMetier metier = new FacadeMetier();

            //3) Instanciation du Presenter(Vue et FM)
            Presenter pres = new Presenter(vue, metier);

            //4) appel de la méthode exec()
            pres.exec();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
