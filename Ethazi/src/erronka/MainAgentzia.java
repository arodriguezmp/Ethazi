package erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainAgentzia {

	private static final Logger LOGGER = Logger.getLogger(MainAgentzia.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Handler fileHandler = null;
		Handler fileHandler1 = null;
		ArrayList<Apartamentuak> a = new ArrayList<Apartamentuak>();
		ArrayList<Bezeroak> b = new ArrayList<Bezeroak>();
		ArrayList<Langileak> l = new ArrayList<Langileak>();
		ArrayList<Erreserba> e = new ArrayList<Erreserba>();
		ArrayList<Hotelak> h = new ArrayList<Hotelak>();
		ArrayList<Ostatuak> o = new ArrayList<Ostatuak>();
		ArrayList<Kruzeroak> k = new ArrayList<Kruzeroak>();
		int menu;
		String telf;
		boolean erreserbaldaketak = false;
		boolean bezeroaldaketak = false;

		boolean admin = false;
		boolean bezero = true;
		String dni;
		boolean encontrado = false;
		int kont = 0, bezerokont = 0, langilekont = 0;
		String erabilsortu, erabilezabatu;

		// scanner
		Scanner sc = new Scanner(System.in);

		try {

			fileHandler = new FileHandler("./logs/ficheroLogErrores.log", true);
			fileHandler1 = new FileHandler("./logs/ficheroLogActividades" + System.currentTimeMillis() + ".log", false);

			fileHandler.setFormatter(new Formato());
			fileHandler1.setFormatter(new SimpleFormatter());

			LOGGER.addHandler(fileHandler);
			LOGGER.addHandler(fileHandler1);
			fileHandler.setLevel(Level.SEVERE);
			fileHandler1.setLevel(Level.FINE);
			LOGGER.setLevel(Level.FINE);
			// Establecer niveles a handlers y LOGGER

			// Datu basearekin konexioa
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agentzia", "root", "");
				// si se ha conectado correctamente
				System.out.println("Conexión Correcta.");
				// Consulta
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(
						"SELECT * FROM agentzia.apartamentuak a, agentzia.ostatuak o WHERE a.kod_ostatua=o.kod_ostatua;");
				while (rs.next()) {
					Apartamentuak a1 = new Apartamentuak(rs.getInt("kod_ostatua"), rs.getInt("pertsona_kop_max"),
							rs.getInt("komun_kop"), rs.getInt("logela_kop"));
					a.add(a1);
				}

				rs = st.executeQuery("SELECT * FROM agentzia.bezeroak b, agentzia.pertsonak p WHERE b.nan=p.nan;");
				while (rs.next()) {
					Bezeroak b1 = new Bezeroak(rs.getString("nan"), rs.getString("izena"), rs.getString("abizena"),
							rs.getString("email"), rs.getString("tfno"), rs.getInt("bezero_zbk"));
					b.add(b1);
				}

				rs = st.executeQuery("SELECT * FROM agentzia.langileak l, agentzia.pertsonak p WHERE l.nan=p.nan;");
				while (rs.next()) {
					Langileak l1 = new Langileak(rs.getString("nan"), rs.getString("izena"), rs.getString("abizena"),
							rs.getString("email"), rs.getString("tfno"), rs.getString("admin"),
							rs.getString("lan_postua"));
					l.add(l1);
				}

				rs = st.executeQuery("SELECT * FROM agentzia.erreserbak;");
				while (rs.next()) {
					Erreserba e1 = new Erreserba(rs.getString("nan"), rs.getInt("kod_ostatua"),
							rs.getDate("hasiera_data"), rs.getDate("amaiera_data"), rs.getInt("prezioa"));
					e.add(e1);
				}

				rs = st.executeQuery(
						"SELECT * FROM agentzia.hotelak h, agentzia.ostatuak o WHERE h.kod_ostatua=o.kod_ostatua;");
				while (rs.next()) {
					Hotelak h1 = new Hotelak(rs.getInt("kod_ostatua"), rs.getInt("pertsona_kop_max"),
							rs.getString("gela_mota"), rs.getInt("gela_zenb"));
					h.add(h1);
				}

				rs = st.executeQuery("SELECT * FROM agentzia.ostatuak;");
				while (rs.next()) {
					Ostatuak o1 = new Ostatuak(rs.getInt("kod_ostatua"), rs.getInt("pertsona_kop_max"));
					o.add(o1);
				}

				rs = st.executeQuery(
						"SELECT * FROM agentzia.kruzeroak k, agentzia.ostatuak o WHERE o.kod_ostatua=k.kod_ostatua;");
				while (rs.next()) {
					Kruzeroak k1 = new Kruzeroak(rs.getInt("kod_ostatua"), rs.getInt("pertsona_kop_max"),
							rs.getInt("kamarote_zenb"), rs.getString("klasea"), rs.getString("kamarote_mota"));
					k.add(k1);
				}
				// ResultSet itxi
				rs.close();
				// Statement itxi kontsulta bukatu ostean
				st.close();
				// cierro la conexion
				conexion.close();
			} catch (SQLException sqle) {
				// si NO se ha conectado correctamente
				sqle.printStackTrace();
				System.out.println("Error de Conexión");
			}

			// Saioa hasi
			System.out.println("Sartu erabiltzailea (NAN zenbakia):");
			dni = sc.next();
			// Bezeroa bada begiratzeko
			bezerokont = 0;
			encontrado = false;
			while (encontrado == false && bezerokont < b.size()) {

				if (dni.equalsIgnoreCase(b.get(bezerokont).getNan())) {
					encontrado = true;
					bezero = true;
					admin = false;
				} else {
					bezerokont++;
				}
			}
			// Langilea bada begiratzeko
			langilekont = 0;
			while (encontrado == false && langilekont < l.size()) {

				if (dni.equalsIgnoreCase(l.get(langilekont).getNan())) {
					encontrado = true;
					admin = true;
					bezero = false;
				} else {
					langilekont++;
				}
			}

			// Erabiltzailea datu basean ez badago
			if (encontrado == false) {
				System.out.println("Erabiltzaile hori ez da existitzen.");
				System.out.println("Kontu berria sortu nahi duzu? (BAI/EZ)");
				erabilsortu = sc.next();
				while (!erabilsortu.equalsIgnoreCase("ez") && !erabilsortu.equalsIgnoreCase("bai")) {
					System.out.println("ERROR! BAI edo EZ bakarrik!");
					erabilsortu = sc.next();
				}
				// Erabiltzaileak erabiltzaile berri bat sortu nahi ez badu
				if (erabilsortu.equalsIgnoreCase("ez")) {
					bezero = false;
					System.out.println("Agur");
					// Erabiltzaileak erabiltzaile berri bat sortzen badu
				} else {
					kont = 0;
					encontrado = false;
					while (encontrado == false && kont < b.size()) {
						if (dni.equalsIgnoreCase(b.get(kont).getNan())) {
							encontrado = true;
						} else {
							kont++;
						}
					}
					Bezeroak b1 = new Bezeroak();
					b1.irakurri(sc, b);
					LOGGER.log(Level.FINE, "Bezero berri bat erregistratu da du: " + b1);
					b.add(b1);
					bezeroaldaketak = true;

				}
			}

			if (admin == true) {
				System.out.println("Administrari menua");
				System.out.println(
						"Ongi etorri " + l.get(langilekont).getIzena() + " " + l.get(langilekont).getAbizena());
				do {
					System.out.println("1- Erreserbak bistaratu");
					System.out.println("2- Bezeroak bistaratu");
					System.out.println("3- Langileak bistaratu");
					System.out.println("4- Ostatuak bistaratu");
					System.out.println("5- Kruzeroak bistaratu");
					System.out.println("6- Apartamantuak bistaratu");
					System.out.println("7- Hotelak bistaratu");
					System.out.println("0- Irten");
					menu = sc.nextInt();
					LOGGER.log(Level.FINE, "Langileak menuan hurrengo aukera egin du: " + menu);
					switch (menu) {
					case 1:
						System.out.println("************Erreserbak bistaratu************");
						for (Erreserba i : e) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					case 2:
						System.out.println("************Bezeroak bistaratu************");
						for (Bezeroak i : b) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					case 3:
						System.out.println("************Langileak bistaratu************");
						for (Langileak i : l) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					case 4:
						System.out.println("************Ostatuak bistaratu************");
						for (Ostatuak i : o) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					case 5:
						System.out.println("************Kruzeroak bistaratu************");
						for (Kruzeroak i : k) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					case 6:
						System.out.println("************Apartamentuak bistaratu************");
						for (Apartamentuak i : a) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					case 7:
						System.out.println("************Hotelak bistaratu************");
						for (Hotelak i : h) {
							i.pantailaratu();
							System.out.println("***************************");
						}
						break;
					}

				} while (menu != 0);
			} else if (bezero == true) {
				System.out.println("Bezero menua:");
				System.out
						.println("Ongi etorri " + b.get(bezerokont).getIzena() + " " + b.get(bezerokont).getAbizena());

				do {
					System.out.println("0- Irten");
					System.out.println("1- Erreserba bat gehitu");
					System.out.println("2- Zure telefono zenbakia aldatu");
					System.out.println("3- Zure kontua ezabatu");
					menu = sc.nextInt();
					LOGGER.log(Level.FINE, "Bezeroak menuan hurrengo aukera egin du: " + menu);
					switch (menu) {
					case 1:
						System.out.println("************Erreserba bat gehitu************");
						Erreserba e2 = new Erreserba();
						e2.irakurri(sc);
						LOGGER.log(Level.FINE, "Bezeroak erreserbatu du: " + e2);
						e.add(e2);
						erreserbaldaketak = true;
						break;
					case 2:
						System.out.println("************Zure telefono zenbakia aldatu************");
						System.out.println(
								"Kaixo " + b.get(bezerokont).getIzena() + " " + b.get(bezerokont).getAbizena());
						System.out.println("Sartu zure telefono zenbaki berria:");
						telf = sc.next();
						while (telf.length() != 9) {
							System.out.println("ERROR! Telefono zenbakiak 9 digito izan behar ditu");
							System.out.println("Sartu zure telefono zenbaki berria:");
							telf = sc.next();
						}
						b.get(bezerokont).setTfno(telf);
						bezeroaldaketak = true;
						break;
					case 3:
						System.out.println("ADI! AKZIO HAU EZIN DA DESEGIN");
						System.out.println("Zihur zaude zure kontua ezabatu nahi duzula? (BAI/EZ)");
						erabilezabatu = sc.next();
						while (!erabilezabatu.equalsIgnoreCase("ez") && !erabilezabatu.equalsIgnoreCase("bai")) {
							System.out.println("ERROR! BAI edo EZ bakarrik!");
							erabilezabatu = sc.next();
						}
						if (erabilezabatu.equalsIgnoreCase("bai")) {
							b.remove(bezerokont);
							bezeroaldaketak = true;

							System.out.println("Agur");
							menu = 0;
						}
						break;
					}
				} while (menu != 0);

			}
			// Programatik datu basera pasatu datuak
			try {
				String consulta = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agentzia", "root", "");
				Statement st = conexion.createStatement();
				if (erreserbaldaketak) {
					consulta = "DELETE FROM erreserbak";
					st.executeUpdate(consulta);
					String nan;
					int kod_ostatua;
					Date hd;
					Date ad;
					int prezioa;
					String hasiera_data;
					String amaiera_data;
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

					for (Erreserba i : e) {
						nan = i.getNan();
						kod_ostatua = i.getKod_ostatua();
						hd = i.getHasiera_data();
						ad = i.getAmaiera_data();
						prezioa = i.getPrezioa();

						hasiera_data = dt.format(hd);
						amaiera_data = dt.format(ad);

						consulta = "INSERT INTO erreserbak VALUES ('" + nan + "'," + kod_ostatua + ",'" + hasiera_data
								+ "','" + amaiera_data + "'," + prezioa + ");";
						st.executeUpdate(consulta);
					}
				}
			} catch (SQLException sqle) {
				// TODO: handle exception
				System.out.println("Erreserbak: " + sqle.getMessage());
			}

			try {
				String consulta = "";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agentzia", "root", "");
				Statement st = conexion.createStatement();
				if (bezeroaldaketak) {
					// erreserbak>>langileak>>bezeroak>>pertsonak
					consulta = "DELETE FROM erreserbak";
					st.executeUpdate(consulta);

					consulta = "DELETE FROM langileak";
					st.executeUpdate(consulta);

					consulta = "DELETE FROM bezeroak";
					st.executeUpdate(consulta);

					consulta = "DELETE FROM pertsonak";
					st.executeUpdate(consulta);

					String nan;
					String izena;
					String abizena;
					String email;
					String tfno;

					// pertsonak>>bezeroak>>langileak>>erreserbak

					// Pertsonak
					for (Langileak i : l) {
						nan = i.getNan();
						izena = i.getIzena();
						abizena = i.getAbizena();
						email = i.getEmail();
						tfno = i.getTfno();

						consulta = "INSERT INTO pertsonak VALUES ('" + nan + "','" + izena + "','" + abizena + "','"
								+ email + "','" + tfno + "');";
						st.executeUpdate(consulta);
					}

					// Pertsonak
					for (Bezeroak j : b) {
						nan = j.getNan();
						izena = j.getIzena();
						abizena = j.getAbizena();
						email = j.getEmail();
						tfno = j.getTfno();

						consulta = "INSERT INTO pertsonak VALUES ('" + nan + "','" + izena + "','" + abizena + "','"
								+ email + "','" + tfno + "');";
						st.executeUpdate(consulta);
					}
					int bezero_zbk;
					// Bezeroak
					for (Bezeroak i : b) {
						nan = i.getNan();
						bezero_zbk = i.getBezero_zbk();

						consulta = "INSERT INTO bezeroak VALUES ('" + nan + "'," + bezero_zbk + ");";
						st.executeUpdate(consulta);
					}
					String administrator;
					String lan_postua;
					// Langileak
					for (Langileak i : l) {
						nan = i.getNan();
						administrator = i.getAdmin();
						lan_postua = i.getLan_postua();

						consulta = "INSERT INTO langileak VALUES ('" + nan + "','" + administrator + "','" + lan_postua
								+ "');";
						st.executeUpdate(consulta);
					}
					// Erreserbak
					int kod_ostatua;
					Date hd;
					Date ad;
					int prezioa;
					String hasiera_data;
					String amaiera_data;
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

					for (Erreserba i : e) {
						nan = i.getNan();
						kod_ostatua = i.getKod_ostatua();
						hd = i.getHasiera_data();
						ad = i.getAmaiera_data();
						prezioa = i.getPrezioa();

						hasiera_data = dt.format(hd);
						amaiera_data = dt.format(ad);

						consulta = "INSERT INTO erreserbak VALUES ('" + nan + "'," + kod_ostatua + ",'" + hasiera_data
								+ "','" + amaiera_data + "'," + prezioa + ");";
						st.executeUpdate(consulta);
					}
				}
			} catch (SQLException sqle) {
				// TODO: handle exception
				System.out.println("Bezeroak: " + sqle.getMessage());
			}
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Ocurrió una Excepcion.", exception);

		}

	}

}
