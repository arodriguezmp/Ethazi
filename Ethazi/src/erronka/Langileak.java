package erronka;

import java.io.Serializable;
import java.util.Scanner;

public class Langileak extends Pertsonak implements Serializable {
	private String admin;
	private String lan_postua;

	/**
	 * Langileak default eraikitzeko
	 */
	public Langileak() {
		super();
		this.admin = "";
		this.lan_postua = "";

	}

	/**
	 * Langileak parametro bidez eraikitzeko
	 * 
	 * @param n  nan Pertsonatik heredatzen du
	 * @param i  izena Pertsonatik heredatzen du
	 * @param a  abizena Pertsonatik heredatzen du
	 * @param e  email Pertsonatik heredatzen du
	 * @param t  tfno Pertsonatik heredatzen du
	 * @param ad Admin sartzen du
	 * @param lp lan_postua sarten du
	 */
	public Langileak(String n, String i, String a, String e, String t, String ad, String lp) {
		super(n, i, a, e, t);
		this.admin = ad;
		this.lan_postua = lp;
	}

	/**
	 * admin hartzen duen getter bat
	 * 
	 * @return admin
	 */
	public String getAdmin() {
		return admin;
	}

	/**
	 * admin hartzen duen setter bat
	 * 
	 * @param admin
	 */
	public void setAdmin(String admin) {
		this.admin = admin;
	}

	/**
	 * lan_postua hartzen duen getter bat
	 * 
	 * @return lan_postua
	 */
	public String getLan_postua() {
		return lan_postua;
	}

	/**
	 * lan_postua hartzen duen setter bat
	 * 
	 * @param lan_postua
	 */
	public void setLan_postua(String lan_postua) {
		this.lan_postua = lan_postua;
	}

	/**
	 * Pantalartu bat datu guztiak irakuzteko
	 */
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

	/**
	 * Irakurri bat datuak hartzeko
	 * 
	 * @param teclado
	 */
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
