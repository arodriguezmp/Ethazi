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
	private String kod_ostatua;

	public Erreserba() {
		this.prezioa = 0;
		this.hasiera_data = new Date();
		this.amaiera_data = new Date();
		this.nan = "";
		this.kod_ostatua = "";
	}

	public Erreserba(int a, Date b, Date c, String d, String e) {
		this.prezioa = a;
		this.hasiera_data = b;
		this.amaiera_data = c;
		this.nan = d;
		this.kod_ostatua = e;
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

	public String getKod_ostatua() {
		return kod_ostatua;
	}

	public void setKod_ostatua(String kod_ostatua) {
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
		System.out.println("Prezioa: " + this.prezioa);
		System.out.println("Hasiera Data: " + dt.format(hasiera_data));
		System.out.println("Amaiera Data: " + dt.format(amaiera_data));
		System.out.println("NAN zenbakia: " + this.nan);
		System.out.println("Kodea: " + this.kod_ostatua);


	}

	public void irakurri(Scanner teclado) {
		
		System.out.println("Sartu Prezioa:");
		this.prezioa = teclado.nextInt();
		System.out.println("Sartu NAN:");
		this.nan = teclado.next();
	


		try {
			System.out.println("Sartu Hasiera data:");
			this.hasiera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
			System.out.println("Sartu Amaiera data:");
			this.amaiera_data = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Sartu email:");
		this.nan = teclado.next();
		System.out.println("Sartu bezero zenbakia:");
		this.kod_ostatua = teclado.next();
	}

}
