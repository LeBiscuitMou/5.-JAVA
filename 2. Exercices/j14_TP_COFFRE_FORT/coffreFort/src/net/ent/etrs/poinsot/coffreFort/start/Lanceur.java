package net.ent.etrs.poinsot.coffreFort.start;

import net.ent.etrs.poinsot.coffreFort.model.CoffreFort;
import net.ent.etrs.poinsot.coffreFort.model.exceptions.KeyAlreadyGivenException;
import net.ent.etrs.poinsot.coffreFort.model.exceptions.LockerAlreadyOpenException;
import net.ent.etrs.poinsot.coffreFort.model.exceptions.LockerNotOpenException;

import java.util.UUID;


public class Lanceur {

	public static void main(String[] args) {

		CoffreFort<String> monCoffre = new CoffreFort<> () ;
		UUID maCle = null;
		try {
			maCle = monCoffre.getKey();
			monCoffre.open(maCle) ;
			monCoffre.putElement("Garde moi cette phrase au chaud") ;
			System.out.printf("voici votre élément : %s%n",monCoffre.getElement());
			monCoffre.close(maCle) ;
		} 
		catch (KeyAlreadyGivenException | LockerNotOpenException | LockerAlreadyOpenException ex)
		{
			System.err.println(ex.getMessage());
		}



		try
		{
			monCoffre.putElement("Je tente de mettre qqch dedans, alors que c'est fermé") ;
		} 
		//Exception Runtime
		catch(LockerNotOpenException ex)
		{
			System.err.println(ex.getMessage());
		}

		
		monCoffre.open(maCle);
		try {
			String anciennePhrase = monCoffre.putElement("Ma nouvelle phrase à mettre au chaud") ;
			System.out.println(String.format("Phrase récupérée : %s", anciennePhrase));
		}
		catch (LockerNotOpenException ex) 
		{			
			System.err.println(ex.getMessage());
		}


		try
		{
			UUID nouvelleCle = monCoffre.getKey();
		}
		catch (KeyAlreadyGivenException e)
		{
			System.err.println(e.getMessage()) ;
		}		
	}

}
