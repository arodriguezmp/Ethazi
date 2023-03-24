package erronka;

import java.util.Scanner;

public class Hotelak extends Ostatuak{

	private String 	gela_mota;
	private int gela_zenbakia;
	
	
	public Hotelak() {
		super();
		this.gela_mota="";
		this.gela_zenbakia=0;
	}
	public Hotelak(int ko , int pk , String gm , int gz) {
		super(ko , pk );
		this.gela_mota=gm;
		this.gela_zenbakia=0;
	}
	public Hotelak(Hotelak h) {
		super(h);
		this.gela_mota=h.gela_mota;
		this.gela_zenbakia=h.gela_zenbakia;
	}
	public String getGela_mota() {
		return gela_mota;
	}
	public void setGela_mota(String gela_mota) {
		this.gela_mota = gela_mota;
	}
	public int getGela_zenbakia() {
		return gela_zenbakia;
	}
	public void setGela_zenbakia(int gela_zenbakia) {
		this.gela_zenbakia = gela_zenbakia;
	}
	@Override
	public String toString() {
		return  super.toString() +", gela_mota=" + gela_mota + ", gela_zenbakia=" + gela_zenbakia + "]";
	}
	

	public void pantailaratu(){
		System.out.println( kod_ostatua + "," + pertsona_kop + "," + gela_mota + "," + gela_zenbakia);
	}
	
	public void irakurri(Scanner teklatua) {
		System.out.println("Sartu gela mota:");
		this.gela_mota =teklatua.next();
		System.out.println("Sartu gela zenbakia:");
		this.gela_zenbakia =teklatua.nextInt();
	}
	
	
}
