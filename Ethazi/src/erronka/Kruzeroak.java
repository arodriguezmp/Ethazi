package erronka;

import java.util.Scanner;

public class Kruzeroak extends Ostatuak{

	private int kamarote_zenb;
	private String klasea;
	private String kamarote_mota;
	
	
	public Kruzeroak() {
		super();
		this.kamarote_zenb= 0;
		this.klasea="";
		this.kamarote_mota="";
	}
	
	public Kruzeroak(int ko , int pk , int kz , String k , String km) {
		super(ko , pk);
		this.kamarote_zenb=kz;
		this.klasea=k;
		this.kamarote_mota=km;
	}
	
	public Kruzeroak(Kruzeroak k) {
		super(k);
		this.kamarote_zenb=k.kamarote_zenb;
		this.klasea=k.klasea;
		this.kamarote_mota=k.kamarote_mota;
	}

	public int getKamarote_zenb() {
		return kamarote_zenb;
	}

	public void setKamarote_zenb(int kamarote_zenb) {
		this.kamarote_zenb = kamarote_zenb;
	}

	public String getKlasea() {
		return klasea;
	}

	public void setKlasea(String klasea) {
		this.klasea = klasea;
	}

	public String getKamarote_mota() {
		return kamarote_mota;
	}

	public void setKamarote_mota(String kamarote_mota) {
		this.kamarote_mota = kamarote_mota;
	}

	
	public String toString() {
		return super.toString() + ", kamarote_zenb=" + kamarote_zenb + ", klasea=" + klasea + ", kamarote_mota=" + kamarote_mota
				+ "]";
	}
	
	
	public void pantailaratu(){
		super.pantailaratu();
		System.out.println("Kamarotearen zenbakia: "+ this.kamarote_zenb);
		System.out.println("Kamarotearen klasea: "+ this.klasea);
		System.out.println("Kamarotearen mota: "+ this.kamarote_mota);
	}
	
	public void irakurri(Scanner teklatua) {
		super.irakurri(teklatua);
		System.out.println("Sartu kamarote zenbakia:");
		this.kamarote_zenb =teklatua.nextInt();
		System.out.println("Sartu klasea:");
		this.klasea =teklatua.next();
		System.out.println("Sartu kamarote mota:");
		this.kamarote_mota=teklatua.next();
		
	}
	
}
