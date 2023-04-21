package erronka;

import java.io.IOException;
import java.io.InputStream;
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
		Scanner sc = new Scanner(System.in);
		Handler fileHandler = null;
		Handler fileHandler1 = null;
		int dni;

		
		try {
            // Crea un FileHandler para guardar los mensajes de error
            Handler fileHandlerError = new FileHandler("./logs/errores.log", true);
            fileHandlerError.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandlerError);
            LOGGER.setLevel(Level.SEVERE);
  
            // Crea otro FileHandler para guardar la actividad del usuario
            Handler fileHandlerActividad = new FileHandler("./logs/actividad"+System.currentTimeMillis()+".log", false);
            fileHandlerActividad.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandlerActividad);
            LOGGER.setLevel(Level.FINE);
  
            LOGGER.info("El programa ha iniciado"); // Mensaje para el handler de actividad
            System.out.println("Sartu zenbakia");
            int numero; // Genera una excepción para el handler de errores
            numero=sc.nextInt();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ocurrió una excepción al crear el logger", e);
        }
	}

}
