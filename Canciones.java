import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
Authors: Jose Gil, Santos Huchin, Luis Lopez.
Project: PianoRMI.
Course: Distributed Systems.
Undergraduate Program: Computer Systems Engineering.
University: Universidad Autonoma de Campeche.
All rights reserved.
*/

public class Canciones implements CancionesInterface {
    
    public Canciones() {}
    
    @Override
    public String [] getCancion1 () {
        String [] cancionEscala = {"si5", "mi5", "mi5", "fa5", "sol5", "sol5", "fa5", "mi5", "re5", "do5", "do5", "re5", "mi5", "mi5", "re5", "re5",
                "mi5", "mi5", "fa5", "sol5", "sol5", "fa5", "mi5", "re5", "do5", "do5", "re5", "mi5", "re5", "do5", "do5"};
        return cancionEscala;
    }

    @Override
    public int [] getSilencios1 () {
        int [] silenciosEscala = {1234, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 750, 250, 1000,
                500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 750, 250};
        return silenciosEscala;
    }

    @Override
    public String [] getCancion2 () {
        String [] cancionEscala = {"si5", "do7", "la6", "mi6", "do7", "si6", "sol6", "sol6", "do7", "si6", "la6", "si6", "do7", "sol6", "mi6", "do7",
        "si6", "sol6", "sol6", "do7", "si6", "la6", "sol6", "fa6", "do7", "do7", "do7", "fa6", "fa6", "do7", "do7", "do7", "si6", "do7", "si6", "do7",
        "si6", "sol6", "si6", "do7", "si6", "do7", "si6", "la6", "sol6", "la6"};
        return cancionEscala;
    }

    @Override
    public int [] getSilencios2 () {
        int [] silenciosEscala = {1234, 500, 500, 500, 250, 500, 500, 250, 250, 250, 250, 250, 500, 500, 500, 250, 500, 500, 250, 250,
        250, 250, 250, 375, 375, 250, 750, 250, 375, 375, 250, 750, 500, 250, 250, 250, 250, 500, 500, 250, 250, 250, 375, 375, 250};
        return silenciosEscala;
    }

    @Override
    public String [] getCancion3 () {
        String [] cancionEscala = {"si5", "sol5", "sol5", "do6", "do6", "si5", "do6", "re6", "si5", "do6", "re6", "mi6", "do6", "re6", "mi6", "fa6",
            "fa6", "fa6", "mi6", "re6", "do6", "si5", "re6", "do6", "si5", "do6", "re6", "mi6", "fa6", "re6", "do6", "mi6", "re6", "si5", "si5", "do6",
            "re6", "mi6", "do6", "mi6", "re6", "si5", "si5", "do6", "re6", "mi6", "do6", "do6", "fa6", "fa6", "sol6", "fa6", "mi6", "do6", "si5", "do6",
            "re6", "mi6", "fa6", "re6", "do6"};
        return cancionEscala;
    }

    @Override
    public int [] getSilencios3 () {
        int [] silenciosEscala = {1234, 500, 500, 1500, 375, 375, 375, 1125, 375, 375, 375, 1125, 375, 375, 375, 1500, 375, 375, 1125, 375, 375, 375,
        750, 375, 375, 375, 375, 750, 750, 750, 1500, 750, 750, 375, 375, 375, 375, 750, 750, 750, 750, 375, 375, 375, 375, 1500, 375, 375,
        1125, 375, 375, 375, 750, 375, 375, 375, 375, 750, 750, 750};
        return silenciosEscala;
    }

    @Override
    public String [] getCancion4 () {
        String [] cancionEscala = {"si5", "fa5", "sol5", "la5", "sol5","fa5", "sol5","do6", "la5", "do6", "re6", "do6", "sol5", "fa5", "fa5", "fa5",
            "fa5", "mi5","fa5", "fa5", "mi5", "fa5", "sol5","la5", "sol5","fa5", "fa5", "fa5", "fa5", "mi5", "fa5","fa5", "do5", "fa5", "fa5", "fa5",
            "fa5", "mi5", "fa5", "fa5", "mi5", "fa5", "sol5", "la5", "sol5", "fa5", "fa5", "fa5", "fa5", "mi5", "fa5", "fa5", "do5", "fa5", "sol5",
            "do5", "do6", "laSost5","la5", "sol5", "la5", "laSost5", "la5", "sol5", "fa5", "mi5", "fa5", "mi5", "re5", "do5", "fa5", "sol5", "do5",
            "do6", "laSost5", "la5", "sol5", "la5", "laSost5", "la5", "sol5", "fa5", "mi5", "fa5", "mi5", "mi5", "fa5", "sol5", "la5", "sol5", "fa5"};
        return cancionEscala;
    }

    @Override
    public int [] getSilencios4 () {
        int [] silenciosEscala = {1234, 500, 500, 3000, 500, 500, 1000, 2000, 500, 500, 3000, 1000, 4000, 750, 250, 500, 500, 500, 1000, 500, 500,
        1000, 500, 1000, 1000, 750, 250, 500, 500, 500, 1000, 500, 4000, 750, 250, 500, 500, 500, 1000, 500, 500, 1000, 500, 1000, 1000, 750, 250,
        500, 500, 500, 1000, 500, 4000, 2000, 1500, 500, 1000, 500, 500, 1000, 500, 500, 1000, 500, 500, 500, 1000, 500, 2000, 2000, 2000, 1500,
        500, 1000, 500, 500, 1000, 500, 500, 1000, 500, 500, 500, 1000, 500, 500, 1000, 500, 1000, 1000};
        return silenciosEscala;
    }

    @Override
    public String [] getCancion5 () {
        String [] cancionEscala = {"si5", "si5", "do6", "re6", "si5", "la5", "si5", "sol5", "si5", "si5", "la5", "sol5", "mi5", "mi5", "si5", "si5",
            "la5", "si5", "do6", "re6", "si5", "la5", "si5", "sol5", "si5", "si5", "la5", "sol5", "mi5", "mi5", "si5", "si5", "la5", "re6", "re6",
            "re6", "re6", "mi6", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "sol5", "sol5", "sol5", "sol5", "sol5", "re6",
            "re6", "re6", "re6", "mi6", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "la5", "sol5", "sol5", "sol5", "sol5", "sol5"};
	return cancionEscala;
    }

    @Override
    public int [] getSilencios5 () {
	int [] silenciosEscala = {1234, 500, 250, 2000, 250, 500, 250, 2250, 500, 250, 500, 250, 1300, 250, 500, 250, 2500, 500, 250,
 2000, 250, 500, 250, 2250, 500, 250, 500, 250, 1375, 250, 500, 250, 3000, 500, 500, 500, 375, 140, 375, 140, 375, 140, 1125, 375, 140,
 375, 140, 1125, 375, 140, 375, 140, 1000, 500, 500, 500, 375, 140, 375, 140, 375, 140, 1125, 375, 140, 375, 140, 1125, 375, 140, 375,
 140};
	return silenciosEscala;
    }

    @Override
    public String [] getCancion6 () {
        String [] cancionEscala = {"si6", "sol6", "si6", "sol6", "si6", "la6", "sol6", "do7", "la6", "faSost6", "la6", "faSost6", "la6", "sol6", "faSost6",
            "si6", "sol6", "mi6", "sol6", "mi6", "sol6", "faSost6", "mi6", "la6", "faSost6", "faSost6", "si6", "la6", "sol6", "faSost6", "faSost6",
            "mi6", "mi6", "si5", "sol5", "mi5", "mi6", "si5", "la5", "faSost5", "faSost5", "sol5", "la5", "do6", "si5", "la5", "do6", "si5", "si5",
            "si5", "reSost6", "reSost6", "doSost6", "reSost6", "mi6", "sol6", "si6", "sol6", "si6", "la6", "sol6", "do7", "la6", "faSost6", "la6",
            "faSost6", "la6", "sol6", "faSost6", "si6", "sol6", "mi6", "sol6", "mi6", "sol6", "faSost6", "mi6", "la6", "faSost6", "faSost6", "si6",
            "la6", "sol6", "faSost6", "faSost6", "mi6"};
        return cancionEscala;
    }

    @Override
    public int [] getSilencios6 () {
        int [] silenciosEscala = {1234, 1000, 500, 250, 500, 250, 500, 500, 1000, 500, 500, 250, 500, 250, 500, 500, 1000, 500, 500, 250, 500,
        250, 500, 1000, 500, 500, 2500, 500, 500, 500, 750, 3250, 1500, 500, 750, 1250, 1500, 500, 750, 750, 250, 250, 750, 250, 500, 250, 750,
                500, 500, 500, 2500, 500, 500, 500, 3500, 500, 500, 250, 500, 250, 500, 500, 1000, 500, 500, 250, 500, 250, 500, 500, 1000, 500, 500,
                250, 500, 250, 500, 1000, 500, 500, 2500, 500, 500, 500, 750};
        return silenciosEscala;
    }

	public static void main(String[] args) {
		try {
			Canciones obj = new Canciones();
			CancionesInterface stub = (CancionesInterface) UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("RepertorioService", stub);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
