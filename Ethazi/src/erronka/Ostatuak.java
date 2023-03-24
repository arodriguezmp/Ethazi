package erronka;

import java.util.Scanner;

public class Ostatuak {

	protected int kod_ostatua;
	protected int pertsona_kop;
	
	public Ostatuak() {
		this.kod_ostatua=0;
		this.pertsona_kop=0;
	}
	
	public Ostatuak( int ko , int pk) {
		this.kod_ostatua=ko;
		this.pertsona_kop=pk;
	}
	
	public Ostatuak(Ostatuak o) {
		this.kod_ostatua=o.kod_ostatua;
		this.pertsona_kop=o.pertsona_kop;
	}

	public int getKod_ostatua() {
		return kod_ostatua;
	}

	public void setKod_ostatua(int kod_ostatua) {
		this.kod_ostatua = kod_ostatua;
	}

	public int getPertsona_kop() {
		return pertsona_kop;
	}

	public void setPertsona_kop(int pertsona_kop) {
		this.pertsona_kop = pertsona_kop;
	}

	@Override
	public String toString() {
		return "Ostatuak [kod_ostatua=" + kod_ostatua + ", pertsona_kop=" + pertsona_kop;
	}
	
	public void pantailaratu(){
		System.out.println( kod_ostatua + "," + pertsona_kop);
	}
	
	public void irakurri(Scanner teklatua) {
		System.out.println("Sartu ostatuaren kodea:");
		this.kod_ostatua =teklatua.nextInt();
		System.out.println("Sartu pertsona kopurua:");
		this.pertsona_kop =teklatua.nextInt();
	}
}
