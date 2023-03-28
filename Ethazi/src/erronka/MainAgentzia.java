package erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainAgentzia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Apartamentuak> a = new ArrayList<Apartamentuak>();
		ArrayList<Bezeroak> b = new ArrayList<Bezeroak>();
		ArrayList<Langileak> l = new ArrayList<Langileak>();
		ArrayList<Erreserba> e = new ArrayList<Erreserba>();
		ArrayList<Hotelak> h = new ArrayList<Hotelak>();
		ArrayList<Ostatuak> o = new ArrayList<Ostatuak>();
		ArrayList<Kruzeroak> k = new ArrayList<Kruzeroak>();
		int menu;
		boolean erreserbaldaketak = false;

		Scanner sc = new Scanner(System.in);

		// Datu basearekin konexioa
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agentzia", "root", "");
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");
			// Consulta
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM agentzia.apartamentuak;");
			while (rs.next()) {
				Apartamentuak a1 = new Apartamentuak(rs.getInt("kod_ostatua"), rs.getInt("komun_kop"),
						rs.getInt("logela_kop"));
				a.add(a1);
			}

			rs = st.executeQuery("SELECT * FROM agentzia.bezeroak;");
			while (rs.next()) {
				Bezeroak b1 = new Bezeroak(rs.getString("nan"), rs.getInt("bezero_zbk"));
				b.add(b1);
			}

			rs = st.executeQuery("SELECT * FROM agentzia.langileak;");
			while (rs.next()) {
				Langileak l1 = new Langileak(rs.getString("nan"), rs.getString("admin"), rs.getString("lan_postua"));
				l.add(l1);
			}

			rs = st.executeQuery("SELECT * FROM agentzia.erreserbak;");
			while (rs.next()) {
				Erreserba e1 = new Erreserba(rs.getString("nan"), rs.getInt("kod_ostatua"), rs.getDate("hasiera_data"),
						rs.getDate("amaiera_data"), rs.getInt("prezioa"));
				e.add(e1);
			}

			rs = st.executeQuery("SELECT * FROM agentzia.hotelak;");
			while (rs.next()) {
				Hotelak h1 = new Hotelak(rs.getInt("kod_ostatua"), rs.getString("gela_mota"), rs.getInt("gela_zenb"));
				h.add(h1);
			}

			rs = st.executeQuery("SELECT * FROM agentzia.ostatuak;");
			while (rs.next()) {
				Ostatuak o1 = new Ostatuak(rs.getInt("kod_ostatua"), rs.getInt("pertsona_kop_max"));
				o.add(o1);
			}

			rs = st.executeQuery("SELECT * FROM agentzia.kruzeroak;");
			while (rs.next()) {
				Kruzeroak k1 = new Kruzeroak(rs.getInt("kod_ostatua"), rs.getInt("kamarote_zenb"),
						rs.getString("klasea"), rs.getString("kamarote_mota"));
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

		do {
			System.out.println("1- Erreserbak bistaratu");
			System.out.println("8- Erreserba bat gehitu");
			System.out.println("0- Irten");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				for (Erreserba i : e) {
					i.pantailaratu();
					System.out.println("***************************");
				}
				break;

			case 8:
				Erreserba e2 = new Erreserba();
				e2.irakurri(sc);
				e.add(e2);
				erreserbaldaketak = true;
			}

		} while (menu != 0);

		// Programatik datu basera pasatu datuak
		try {
			String consulta = "";
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agentzia", "root", "");
			Statement st = conexion.createStatement();
			if (erreserbaldaketak == true) {
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
							+ "','" + amaiera_data + "'," + prezioa + ";";
					System.out.println(consulta);
					//st.executeUpdate(consulta);
				}
			}
		} catch (SQLException sqle) {
			// TODO: handle exception
		}

	}

}
