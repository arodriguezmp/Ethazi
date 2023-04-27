package erronka;

import java.util.Scanner;
/*
 * @author Josu,Ugaitz,Aimar
 * @Version 1.0
 * 
 */

public class Apartamentuak extends Ostatuak{

	private int kommun_kop;
	private int logela_kop;
	
	/**
	 * Apartamentuak eraikitzen ditu balio utzekin.
	 *
	 */ 
	
	public Apartamentuak() {
		super();
		this.kommun_kop=0;
		this.logela_kop=0;
	}
	/**
	 * Apartamentuak eraikitzen ditu
	 * @param ko atributuaren balioa ostatutik
	 * @param kk komun kopurua
	 * @param lk logela kopurua
	 */
	public Apartamentuak(int ko , int pk , int kk , int lk) {
		super(ko , pk);
		this.kommun_kop=kk;
		this.logela_kop=lk;
	}
	
	/**
	 * Apartamentuak konstruktorea
	 * @param a para hacer la copio
	 */
	public Apartamentuak(Apartamentuak a) {
		super(a);
		this.kommun_kop=a.kommun_kop;
		this.logela_kop=a.logela_kop;
	}

	/**
	 *Komun kopuruak hartzen dituen getter bat
	 * @return kommun_kop
	 */
	public int getKommun_kop() {
		return kommun_kop;
	}
	
	/**
	 * Kommun_kop aldatzen duen setter bat
	 * @param kommun_kop
	 */
	public void setKommun_kop(int kommun_kop) {
		this.kommun_kop = kommun_kop;
	}

	/**
	 * Logelak hartzen dituen getter bat
	 * @return logela_kop
	 */
	public int getLogela_kop() {
		return logela_kop;
	}

	/**
	 * Logela kopurua aldatzen duen setter bat
	 * @param logela_kop
	 */
	public void setLogela_kop(int logela_kop) {
		this.logela_kop = logela_kop;
	}

	/**
	 *@return To String bueltatzen du
	 */
	public String toString() {
		return super.toString() + ", kommun_kop=" + kommun_kop + ", logela_kop=" + logela_kop + "]";
	}
	
	/**
	 * Pantailaratu balio guztiak
	 * 
	 */
	public void pantailaratu() {
		super.pantailaratu();
		System.out.println("Apartamentuko komun kopurua:"+ this.kommun_kop);
		System.out.println("Apartamentuko logela kopurua: "+ this.logela_kop);
	}
	
	/**
	 * irakurri balioak
	 * @param teklatua eskanerra
	 */
	public void irakurri(Scanner teklatua) {
		super.irakurri(teklatua);
		System.out.println("Sartu komun kopurua:");
		this.kommun_kop = teklatua.nextInt();
		System.out.println("Sartu logela kopurua:");
		this.logela_kop = teklatua.nextInt();
	}
	
	
}
