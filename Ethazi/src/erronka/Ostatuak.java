package erronka;

import java.util.Scanner;

public class Ostatuak {

	protected int kod_ostatua;
	protected int pertsona_kop;

	/**
	 * Ostatuak default eraikitzeko
	 */
	public Ostatuak() {
		this.kod_ostatua = 0;
		this.pertsona_kop = 0;
	}

	/**
	 * Ostatuak parmetro bidez eraikitzeko
	 * @param ko kod_ostatua Sartzen du
	 * @param pk
	 */
	public Ostatuak(int ko, int pk) {
		this.kod_ostatua = ko;
		this.pertsona_kop = pk;
	}

	/**
	 * Ostatuak kopia eraikitzeko
	 * @param o Ostatuak
	 */
	public Ostatuak(Ostatuak o) {
		this.kod_ostatua = o.kod_ostatua;
		this.pertsona_kop = o.pertsona_kop;
	}

	/**
	 * kod_ostatua hartzen duen getter bat
	 * @return kod_ostatua
	 */
	public int getKod_ostatua() {
		return kod_ostatua;
	}

	/**
	 * kod_ostatua hartzen duen setter bat
	 * @param kod_ostatua
	 */
	public void setKod_ostatua(int kod_ostatua) {
		this.kod_ostatua = kod_ostatua;
	}

	/**
	 * pertsona_kop hartzen duen getter bat
	 * @return pertsona_kop
	 */
	public int getPertsona_kop() {
		return pertsona_kop;
	}

	/**
	 * pertsona_kop hartzen duen setter bat
	 * @param pertsona_kop
	 */
	public void setPertsona_kop(int pertsona_kop) {
		this.pertsona_kop = pertsona_kop;
	}


/**
 * Pantailaratu bat datu guztiak agertzeko
 */
	public void pantailaratu() {
		System.out.println("Ostatu kodea: " + this.kod_ostatua);
		System.out.println("Gehienezko pertsona kopurua: " + this.pertsona_kop);
	}

	/**
	 * Irakurri bat dena agertzeko
	 * @param teklatua
	 */
	public void irakurri(Scanner teklatua) {
		System.out.println("Sartu ostatuaren kodea:");
		this.kod_ostatua = teklatua.nextInt();
		System.out.println("Sartu pertsona maximo kopurua:");
		this.pertsona_kop = teklatua.nextInt();
	}
}
