package erronka;

import java.util.Scanner;

public class Hotelak extends Ostatuak {

	private String gela_mota;
	private int gela_zenbakia;

	public Hotelak() {
		super();
		this.gela_mota = "";
		this.gela_zenbakia = 0;
	}

	public Hotelak(int ko, int pk, String gm, int gz) {
		super(ko, pk);
		this.gela_mota = gm;
		this.gela_zenbakia = gz;
	}

	public Hotelak(Hotelak h) {
		super(h);
		this.gela_mota = h.gela_mota;
		this.gela_zenbakia = h.gela_zenbakia;
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
		return super.toString() + ", gela_mota=" + gela_mota + ", gela_zenbakia=" + gela_zenbakia + "]";
	}

	public void pantailaratu() {
		super.pantailaratu();
		System.out.println("Gelaren mota: "+ this.gela_mota);
		System.out.println("Gelaren zenbakia: "+ this.gela_zenbakia);
	}

	public void irakurri(Scanner teklatua) {
		super.irakurri(teklatua);
		System.out.println("Sartu gela mota:");
		this.gela_mota = teklatua.next();
		System.out.println("Sartu gela zenbakia:");
		this.gela_zenbakia = teklatua.nextInt();
	}

}
