package erronka;

import java.util.ArrayList;
import java.util.Scanner;

public class Bezeroak extends Pertsonak {
	private int bezero_zbk;

	/**
	 * Bezeroak defaul eraikitzeko
	 */
	public Bezeroak() {
		super();
		this.bezero_zbk = 0;

	}

	/**
	 * Bezeroak datuekin eraikitzeko pertsonatik hartuz
	 * 
	 * @param n  Pertsonako nan hartzen du
	 * @param i  Pertsonako izena hartzen du
	 * @param a  Pertsonako abizena hartzen du
	 * @param t  Pertsonako tfno hartzen du
	 * @param e  Pertsonako email hartzen du
	 * @param bz Bezero zzenbakia ezartzen du
	 */
	public Bezeroak(String n, String i, String a, String t, String e, int bz) {
		super(n, i, a, t, e);
		this.bezero_zbk = bz;
	}

	/**
	 * Bezero zenbakia hartzeko
	 * 
	 * @return bezero zenbakia
	 */
	public int getBezero_zbk() {
		return bezero_zbk;
	}

	/**
	 * Bezeroak aldatzeko
	 * 
	 * @param bezero_zbk
	 */
	public void setBezero_zbk(int bezero_zbk) {
		this.bezero_zbk = bezero_zbk;
	}

	/**
	 * Pantailaratu balio guztiak
	 */
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("Nan zenbakia: " + this.nan);
		System.out.println("Bezero zenbakia: " + this.bezero_zbk);
		System.out.println("Izena: " + this.izena);
		System.out.println("Abizena: " + this.abizena);
		System.out.println("Telefonoa: " + this.tfno);
		System.out.println("Email: " + this.email);
	}

	/**
	 * irakurri balioak
	 * 
	 * @param teklatua  eskanerra
	 * @param ArrayList bat sartzen du Bezero motakoa
	 */

	public void irakurri(Scanner teclado, ArrayList<Bezeroak> arraybezero) {
		// TODO Auto-generated method stub
		boolean aurkituta = false;
		int kont = 0;
		System.out.println("Sartu NAN:");
		this.nan = teclado.next();
		while (this.nan.length() != 9) {
			System.out.println("ERROR! NAN zenbakia 9 digitokoa izan behar da (8 zenbaki, letra 1)");
			System.out.println("Sartu NAN:");
			this.nan = teclado.next();
		}
		while (aurkituta == false && kont < arraybezero.size()) {
			if (this.nan.equals(arraybezero.get(kont).getNan())) {
				aurkituta = true;
				System.out.println("NAN hori duen pertsona bat existitzen da jada");
				System.out.println("Sartu NAN:");
				this.nan = teclado.next();
				while (this.nan.length() != 9) {
					System.out.println("ERROR! NAN zenbakia 9 digitokoa izan behar da (8 zenbaki, letra 1)");
					System.out.println("Sartu NAN:");
					this.nan = teclado.next();
				}
				kont = 0; // kontadorea 0-ra jarri array-a berriro begiratzeko
				aurkituta = false; // berriro jarri false moduan buklea berriro ejekutatzeko
			} else {
				kont++;
			}
		}
		this.bezero_zbk = (arraybezero.get(arraybezero.size() - 1).getBezero_zbk() + 1);
		System.out.println("Zure bezero zenbakia: " + this.bezero_zbk);
		System.out.println("Sartu Izena:");
		this.izena = teclado.next();
		System.out.println("Sartu Abizena:");
		this.abizena = teclado.next();
		System.out.println("Sartu telefonoa:");
		this.tfno = teclado.next();
		System.out.println("Sartu email:");
		this.email = teclado.next();
	}

	@Override
	public String toString() {
		return super.toString() + " bezero_zbk=" + bezero_zbk + "]";
	}

}
