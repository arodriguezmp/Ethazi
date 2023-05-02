package erronka;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Erreserba implements Bez {
	private int prezioa;
	private Date hasiera_data;
	private Date amaiera_data;
	private String nan;
	private int kod_ostatua;

	/**
	 * Erreserba eraikitzen du balio gabe
	 */
	public Erreserba() {
		this.nan = "";
		this.kod_ostatua = 0;
		this.hasiera_data = new Date();
		this.amaiera_data = new Date();
		this.prezioa = 0;
	}

	/**
	 * Erreserba eraiki datuekin
	 * 
	 * @param p  prezioa sartzen du
	 * @param hd Hasiera_data Sartzen du
	 * @param ad amaiera_data Sartzen du
	 * @param n  nan Sartzen du
	 * @param ko kod_ostatua Sartzen du
	 */

	public Erreserba(String n, int ko, Date hd, Date ad, int p) {
		this.nan = n;
		this.kod_ostatua = ko;
		this.hasiera_data = hd;
		this.amaiera_data = ad;
		this.prezioa = p;
	}

	/**
	 * Prezioa hartzen duen getter bat
	 * 
	 * @return prezioa
	 */
	public int getPrezioa() {
		return prezioa;
	}

	/**
	 * Prezioa aldatzen duen setter bat
	 * 
	 * @param prezioa
	 */
	public void setPrezioa(int prezioa) {
		this.prezioa = prezioa;
	}

	/**
	 * Hasiera data hartzen duen getter bat
	 * 
	 * @return hasiera_data
	 */
	public Date getHasiera_data() {
		return hasiera_data;
	}

	/**
	 * Hasiera_data aldatzen duen setter bat
	 * 
	 * @param hasiera_data
	 */
	public void setHasiera_data(Date hasiera_data) {
		this.hasiera_data = hasiera_data;
	}

	/**
	 * amaiera_data hartzen duen getter bat
	 * 
	 * @return amaiera_data
	 */
	public Date getAmaiera_data() {
		return amaiera_data;
	}

	/**
	 * amaiera_data aldatzen duen setter bat
	 * 
	 * @param amaiera_data
	 */
	public void setAmaiera_data(Date amaiera_data) {
		this.amaiera_data = amaiera_data;
	}

	/**
	 * nan hartzen duen getter bat
	 * 
	 * @return nan
	 */
	public String getNan() {
		return nan;
	}

	/**
	 * nan aldatzen duen setter bat
	 * 
	 * @param nan
	 */
	public void setNan(String nan) {
		this.nan = nan;
	}

	/**
	 * kod_ostatua hartzen duen getter bat
	 * 
	 * @return kod_ostatua
	 */
	public int getKod_ostatua() {
		return kod_ostatua;
	}

	/**
	 * kod_ostatua aldatzen duen setter bat
	 * 
	 * @param kod_ostatua
	 */
	public void setKod_ostatua(int kod_ostatua) {
		this.kod_ostatua = kod_ostatua;
	}

	/**
	 * pantailaratu bat datu guztiak agertzeko
	 */
	public void pantailaratu() {
		// TODO Auto-generated method stub
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Bezeroaren NAN zenbakia: " + this.nan);
		System.out.println("Ostatu kodea: " + this.kod_ostatua);
		System.out.println("Hasiera Data: " + dt.format(hasiera_data));
		System.out.println("Amaiera Data: " + dt.format(amaiera_data));
		System.out.println("Prezioa: " + this.prezioa + " €");
	}

	/**
	 * irakurri datuak sartzeko eta try/catch bat dauka datentzat
	 * 
	 * @param teclado eskaner bidez
	 */
	public void irakurri(Scanner teclado) {

		boolean prezioa = false;
		while (!prezioa) {
			try {
				System.out.println("Sartu Prezioa:");
				this.prezioa = teclado.nextInt();
				prezioa = true;
			} catch (InputMismatchException ime) {
				System.out.println("ERROR! Prezioa zenbaki bat izan behar da.");
				teclado.next(); // limpia el buffer de entrada
			}
		}
		this.prezioa = this.prezioa * BEZ;
		System.out.println("Sartu NAN:");
		this.nan = teclado.next();
		System.out.println("Sartu Erreserbatu nahi duzun ostatuaren kodea:");
		this.kod_ostatua = teclado.nextInt();
		try {
			System.out.println("Sartu Hasiera data:");
			this.hasiera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
			System.out.println("Sartu Amaiera data:");
			this.amaiera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
