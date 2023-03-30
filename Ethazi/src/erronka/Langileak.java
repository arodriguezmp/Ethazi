package erronka;

import java.io.Serializable;
import java.util.Scanner;

public class Langileak extends Pertsonak implements Serializable {
	private String admin;
	private String lan_postua;

	public Langileak() {
		super();
		this.admin = "";
		this.lan_postua = "";

	}

	public Langileak(String n, String i, String a, String e, String t, String ad, String lp) {
		super(n, i, a, e, t);
		this.admin = ad;
		this.lan_postua = lp;
	}

	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("Nan zenbakia: " + this.nan);
		System.out.println("Izena: " + this.izena);
		System.out.println("Abizena: " + this.abizena);
		System.out.println("Telefonoa: " + this.tfno);
		System.out.println("Email: " + this.email);
		System.out.println("Admin: " + this.admin);
		System.out.println("Lan postua: " + this.lan_postua);
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
		System.out.println("Sartu admin:");
		this.admin = teclado.next();
		System.out.println("Sartu lan postua:");
		this.lan_postua = teclado.next();

	}



}
