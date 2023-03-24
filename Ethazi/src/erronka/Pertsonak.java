package erronka;

import java.util.Scanner;

public abstract class Pertsonak {
	protected String nan;
	protected String izena;
	protected String abizena;
	protected String tfno;
	protected String email;

	public Pertsonak() {
		this.nan = "";
		this.izena = "";
		this.abizena = "";
		this.tfno = "";
		this.email = "";

	}

	public Pertsonak(String a, String b, String c, String d, String e) {
		this.nan = a;
		this.izena = b;
		this.abizena = c;
		this.tfno = d;
		this.email = e;

	}

	public abstract void pantailaratu();

	public abstract void irakurri(Scanner teclado);

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pertsonak [nan=" + nan + ", izena=" + izena + ", abizena=" + abizena + ", tfno=" + tfno + ", email="
				+ email + "]";
	}

}
