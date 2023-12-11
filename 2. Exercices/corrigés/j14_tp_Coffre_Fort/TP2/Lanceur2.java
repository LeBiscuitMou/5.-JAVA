package net.ent.etrs.model;


import net.ent.etrs.model.entities.CoffreFort;
import net.ent.etrs.model.entities.exception.KeyAlreadyGivenException;
import net.ent.etrs.model.entities.exception.LockerAlreadyOpenException;
import net.ent.etrs.model.entities.exception.LockerNotOpenException;

import java.util.UUID;

public class Lanceur {

	public static void main(String[] args) {

		CoffreFort<String> monCoffre = new CoffreFort<> () ;
		UUID maCle = null;
		try {
			maCle = monCoffre.getKey();
			monCoffre.open(maCle) ;
			monCoffre.putElement("Garde moi cette phrase au chaud") ;
			System.out.printf("voici votre élément : %s%n",monCoffre.getElementAt(0));
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
			monCoffre.putElement("Ma nouvelle phrase à mettre au chaud") ;
			System.out.printf("élément en position 1 : %s %n",monCoffre.getElementAt(1));
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
