package erronka;

import java.util.Scanner;

public class Kruzeroak extends Ostatuak {

	private int kamarote_zenb;
	private String klasea;
	private String kamarote_mota;

	/**
	 * Kruzeroak default eraikitzeko
	 */
	public Kruzeroak() {
		super();
		this.kamarote_zenb = 0;
		this.klasea = "";
		this.kamarote_mota = "";
	}

	/**
	 * Kruzeroak parametro bidez eraikitzeko
	 * 
	 * @param ko kod_ostatua Ostatutik heredatzen du
	 * @param pk pertsona_kop Ostatutik heredatzen du
	 * @param kz kamarote_zenb Sartzen du
	 * @param k  klasea sartzen du
	 * @param km kamarote_mota satzen du
	 */
	public Kruzeroak(int ko, int pk, int kz, String k, String km) {
		super(ko, pk);
		this.kamarote_zenb = kz;
		this.klasea = k;
		this.kamarote_mota = km;
	}

	/**
	 * Kruzeroak kopia eraikitzeko
	 * 
	 * @param k Kruzeroak motakoa
	 */
	public Kruzeroak(Kruzeroak k) {
		super(k);
		this.kamarote_zenb = k.kamarote_zenb;
		this.klasea = k.klasea;
		this.kamarote_mota = k.kamarote_mota;
	}

	/**
	 * kamarote_zenb hartzen duen getter bat
	 * 
	 * @return kamarote_zenb
	 */
	public int getKamarote_zenb() {
		return kamarote_zenb;
	}

	/**
	 * kamarote_zenb hartzen duen setter bat
	 * 
	 * @param kamarote_zenb
	 */
	public void setKamarote_zenb(int kamarote_zenb) {
		this.kamarote_zenb = kamarote_zenb;
	}

	/**
	 * klasea hartzen duen getter bat
	 * 
	 * @return
	 */
	public String getKlasea() {
		return klasea;
	}

	/**
	 * klasea hartzen duen setter bat
	 * 
	 * @param klasea
	 */
	public void setKlasea(String klasea) {
		this.klasea = klasea;
	}

	/**
	 * kamarote_mota hartzen duen getter bat
	 * 
	 * @return kamarote_mota
	 */
	public String getKamarote_mota() {
		return kamarote_mota;
	}

	/**
	 * kamarote_mota hartzen duen setter bat
	 * 
	 * @param kamarote_mota
	 */
	public void setKamarote_mota(String kamarote_mota) {
		this.kamarote_mota = kamarote_mota;
	}

	/**
	 * to String bat
	 */
	public String toString() {
		return super.toString() + ", kamarote_zenb=" + kamarote_zenb + ", klasea=" + klasea + ", kamarote_mota="
				+ kamarote_mota + "]";
	}

	/**
	 * pantailaratu bat datu guztiak agertzeko
	 */
	public void pantailaratu() {
		super.pantailaratu();
		System.out.println("Kamarotearen zenbakia: " + this.kamarote_zenb);
		System.out.println("Kamarotearen klasea: " + this.klasea);
		System.out.println("Kamarotearen mota: " + this.kamarote_mota);
	}

	/**
	 * irakurri datuak sartzeko eta try/catch bat dauka datentzat
	 * 
	 * @param Teklata Scanner bidez
	 */
	public void irakurri(Scanner teklatua) {
		super.irakurri(teklatua);
		System.out.println("Sartu kamarote zenbakia:");
		this.kamarote_zenb = teklatua.nextInt();
		System.out.println("Sartu klasea:");
		this.klasea = teklatua.next();
		System.out.println("Sartu kamarote mota:");
		this.kamarote_mota = teklatua.next();

	}

}
