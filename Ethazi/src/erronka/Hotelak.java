package erronka;

import java.util.Scanner;

public class Hotelak extends Ostatuak {

	private String gela_mota;
	private int gela_zenbakia;

	/**
	 * Hotelak default eraikitzeko
	 */
	public Hotelak() {
		super();
		this.gela_mota = "";
		this.gela_zenbakia = 0;
	}

	/**
	 * Hotelak parametro bidez eraikitzeko
	 * 
	 * @param ko kod_ostatua Ostatutik heredatzen du
	 * @param pk pertsona_kop Ostatutik heredatzen du
	 * @param gm gela_mota Sartzen da
	 * @param gz gela_zenbakia Sartzen da
	 */
	public Hotelak(int ko, int pk, String gm, int gz) {
		super(ko, pk);
		this.gela_mota = gm;
		this.gela_zenbakia = gz;
	}

	/**
	 * Hotelak kopia eraikizeko
	 * 
	 * @param h Hotelak
	 */
	public Hotelak(Hotelak h) {
		super(h);
		this.gela_mota = h.gela_mota;
		this.gela_zenbakia = h.gela_zenbakia;
	}

	/**
	 * Gela_mota hartzen duen getter bat
	 * 
	 * @return gela_mota
	 */
	public String getGela_mota() {
		return gela_mota;
	}

	/**
	 * Gela_mota hartzen duen setter bat
	 * 
	 * @param gela_mota
	 */
	public void setGela_mota(String gela_mota) {
		this.gela_mota = gela_mota;
	}

	/**
	 * gela_zenbakia hartzen duen getter bat
	 * 
	 * @return gela_zenbakia
	 */
	public int getGela_zenbakia() {
		return gela_zenbakia;
	}

	/**
	 * gela_zenbakia hartzen duen setter bat
	 * 
	 * @param gela_zenbakia
	 */
	public void setGela_zenbakia(int gela_zenbakia) {
		this.gela_zenbakia = gela_zenbakia;
	}

	public String toString() {
		return super.toString() + ", gela_mota=" + gela_mota + ", gela_zenbakia=" + gela_zenbakia + "]";
	}

	/**
	 * Pantailaratu bat datu guztiak irakuzteko konsolatik
	 */
	public void pantailaratu() {
		super.pantailaratu();
		System.out.println("Gelaren mota: " + this.gela_mota);
		System.out.println("Gelaren zenbakia: " + this.gela_zenbakia);
	}

	/**
	 * Irakurri bat datu guztiak hartzeko
	 * 
	 * @param teklatua scanner bidez
	 */
	public void irakurri(Scanner teklatua) {
		super.irakurri(teklatua);
		System.out.println("Sartu gela mota:");
		this.gela_mota = teklatua.next();
		System.out.println("Sartu gela zenbakia:");
		this.gela_zenbakia = teklatua.nextInt();
	}

}
