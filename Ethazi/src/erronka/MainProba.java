package erronka;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainProba {

	private static final Logger LOGGER = Logger.getLogger(MainProba.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Handler fileHandler = null;
		Handler fileHandler1 = null;
		int dni;

		try {

			fileHandler = new FileHandler("./logs/ficheroLogErrores.log", true);
			fileHandler1 = new FileHandler("./logs/ficheroLogActividades" + System.currentTimeMillis() + ".log", false);

			fileHandler1.setFormatter(new Formato());
			fileHandler.setFormatter(new SimpleFormatter());

			LOGGER.addHandler(fileHandler);
			fileHandler.setLevel(Level.SEVERE);
			LOGGER.addHandler(fileHandler1);
			fileHandler1.setLevel(Level.FINE);
			// Establecer niveles a handlers y LOGGER

			
			

			// Eliminamos handler de la consola

			Scanner scanner = new Scanner(System.in);
			Erreserba b1 = new Erreserba();
			System.out.println("hola:");
			dni = scanner.nextInt();
			LOGGER.log(Level.FINE, "Index vale: " + scanner);

			b1.pantailaratu();
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Ocurrió una Excepcion.", exception);

	
		}
	}

}
