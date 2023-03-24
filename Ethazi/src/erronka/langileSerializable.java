package erronka;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class langileSerializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Langileak objeto = new Langileak("1111111A","Josu","Foruria","642272526","j_foruria@fpzornotza.com","Bai","Administratzailea");
		Langileak objeto1 = new Langileak("2222222B","Ugaitz","Bilbo","695232516","u_bilbao@fpzornotza.com","Bai","Administratzailea");
		Langileak objeto2 = new Langileak("3333333C","Aimar","Rodriguez","612561596","a_rodriguez@fpzornotza.com","Bai","Administratzailea");
		// lo guarda en el fichero fechas.dat
		try {
			FileOutputStream fos = new FileOutputStream("langile.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// lo grabo
			oos.writeObject(objeto);
			oos.writeObject(objeto1);
			oos.writeObject(objeto2);

			// cierro los recursos abiertos
			oos.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
