package erronka;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Erreserba implements Bez{
	private int prezioa;
	private Date hasiera_data;
	private Date amaiera_data;
	private String nan;
	private int kod_ostatua;

	public Erreserba() {
		this.nan = "";
		this.kod_ostatua = 0;
		this.hasiera_data = new Date();
		this.amaiera_data = new Date();
		this.prezioa = 0;
	}

	public Erreserba(int p, Date hd, Date ad, String n, int ko) {
		this.prezioa = p;
		this.hasiera_data = hd;
		this.amaiera_data = ad;
		this.nan = n;
		this.kod_ostatua = ko;
	}
	
	public Erreserba(String n, int ko, Date hd, Date ad, int p) {
		this.nan=n;
		this.kod_ostatua=ko;
		this.hasiera_data=hd;
		this.amaiera_data=ad;
		this.prezioa=p;
	}

	public int getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(int prezioa) {
		this.prezioa = prezioa;
	}

	public Date getHasiera_data() {
		return hasiera_data;
	}

	public void setHasiera_data(Date hasiera_data) {
		this.hasiera_data = hasiera_data;
	}

	public Date getAmaiera_data() {
		return amaiera_data;
	}

	public void setAmaiera_data(Date amaiera_data) {
		this.amaiera_data = amaiera_data;
	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public int getKod_ostatua() {
		return kod_ostatua;
	}

	public void setKod_ostatua(int kod_ostatua) {
		this.kod_ostatua = kod_ostatua;
	}

	@Override
	public String toString() {
		return "erreserba [prezioa=" + prezioa + ", hasiera_data=" + hasiera_data + ", amaiera_data=" + amaiera_data
				+ ", nan=" + nan + ", kod_ostatua=" + kod_ostatua + "]";
	}

	public void pantailaratu() {
		// TODO Auto-generated method stub
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Bezeroaren NAN zenbakia: " + this.nan);
		System.out.println("Ostatu kodea: " + this.kod_ostatua);
		System.out.println("Hasiera Data: " + dt.format(hasiera_data));
		System.out.println("Amaiera Data: " + dt.format(amaiera_data));
		System.out.println("Prezioa: " + this.prezioa+" €");
	}

	public void irakurri(Scanner teclado) {
		
		System.out.println("Sartu Prezioa:");
		this.prezioa = teclado.nextInt();
		System.out.println("Sartu NAN:");
		this.nan = teclado.next();
		System.out.println("Sartu Erreserbatu nahi duzun ostatuaren kodea:");
		this.kod_ostatua=teclado.nextInt();
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
