package erronka;

public abstract class Pertsonak {
	protected String nan;
	protected String izena;
	protected String abizena;
	protected String tfno;
	protected String email;

	/**
	 * Pertsonak default eraikitzeko
	 */
	public Pertsonak() {
		this.nan = "";
		this.izena = "";
		this.abizena = "";
		this.tfno = "";
		this.email = "";

	}

	/**
	 * Pertsonak parametro bidez eraikitzeko
	 */
	public Pertsonak(String n, String i, String a, String e, String t) {
		this.nan = n;
		this.izena = i;
		this.abizena = a;
		this.email = e;
		this.tfno = t;
	}

	/**
	 * Pertsona kopia eraikitzeko
	 * 
	 * @param nan
	 */
	public Pertsonak(String n) {
		this.nan = n;
	}

	/**
	 * Abstractua den pantailaratu bat
	 */
	public abstract void pantailaratu();

	/**
	 * nan hartzen duen getter bat
	 * 
	 * @return nan
	 */
	public String getNan() {
		return nan;
	}

	/**
	 * nan hartzen duen setter bat
	 * 
	 * @param nan
	 */
	public void setNan(String nan) {
		this.nan = nan;
	}

	/**
	 * izena hartzen duen getter bat
	 * 
	 * @return izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * izena hartzen duen getter bat
	 * 
	 * @param izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * abizena hartzen duen getter bat
	 * 
	 * @return abizena
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * abizena hartzen duen setter bat
	 * 
	 * @param abizena
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	/**
	 * tfno hartzen duen getter bat
	 * 
	 * @return tfno
	 */
	public String getTfno() {
		return tfno;
	}

	/**
	 * tfno hartzen duen setter bat
	 * 
	 * @param tfno
	 */
	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	/**
	 * email hartzen duen getter bat
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * email hartzen duen setter bat
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
