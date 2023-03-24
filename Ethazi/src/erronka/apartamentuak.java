package erronka;

import java.util.Scanner;

public class apartamentuak extends Ostatuak{

	private int kommun_kop;
	private int logela_kop;
	
	
	public apartamentuak() {
		super();
		this.kommun_kop=0;
		this.logela_kop=0;
	}
	
	public apartamentuak(int ko , int pk , int kk , int lk) {
		super(ko , pk);
		this.kommun_kop=kk;
		this.logela_kop=lk;
	}
	
	public apartamentuak(apartamentuak a) {
		super(a);
		this.kommun_kop=a.kommun_kop;
		this.logela_kop=a.logela_kop;
	}

	public int getKommun_kop() {
		return kommun_kop;
	}

	public void setKommun_kop(int kommun_kop) {
		this.kommun_kop = kommun_kop;
	}

	public int getLogela_kop() {
		return logela_kop;
	}

	public void setLogela_kop(int logela_kop) {
		this.logela_kop = logela_kop;
	}

	@Override
	public String toString() {
		return super.toString() + ", kommun_kop=" + kommun_kop + ", logela_kop=" + logela_kop + "]";
	}
	public void pantailaratu() {
		System.out.println( super.kod_ostatua + "," + super.pertsona_kop + "," +  kommun_kop + "," + logela_kop );
	}
	
	public void irakurri(Scanner teklatua) {
		
		super.irakurri(teklatua);
		System.out.println("Sartu komun kopurua:");
		this.kommun_kop = teklatua.nextInt();
		System.out.println("Sartu logela kopurua:");
		this.logela_kop = teklatua.nextInt();
	}
	
	
}
