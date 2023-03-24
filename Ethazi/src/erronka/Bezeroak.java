package erronka;

import java.util.Scanner;

public class Bezeroak extends Pertsonak {
	private int bezero_zbk;

	public Bezeroak() {
		super();
		this.bezero_zbk = 0;

	}

	public Bezeroak(String a, String b, String c, String d, String e, int f) {
		super(a, b, c, d, e);
		this.bezero_zbk = f;

	}

	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("Nan zenbakia: " + this.nan);
		System.out.println("Izena: " + this.izena);
		System.out.println("Abizena: " + this.abizena);
		System.out.println("Telefonoa: " + this.tfno);
		System.out.println("Email: " + this.email);
		System.out.println("xxx " + this.bezero_zbk);
	}

	@Override
	public void irakurri(Scanner teclado) {
		// TODO Auto-generated method stub
		System.out.println("Sartu NAN:");
		this.nan = teclado.next();
		System.out.println("Sartu Izena:");
		this.izena = teclado.next();
		System.out.println("Sartu Abizena:");
		this.abizena = teclado.next();
		System.out.println("Sartu telefonoa:");
		this.tfno = teclado.next();
		System.out.println("Sartu email:");
		this.email = teclado.next();
		System.out.println("Sartu bezero zenbakia:");
		this.bezero_zbk = teclado.nextInt();
	}

}
