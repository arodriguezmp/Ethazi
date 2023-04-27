package erronka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ApartamentuakTest {

	@Test
	void testIrakurri() {
		String input = "1\n1\n2\n3\n";
		Scanner scanner = new Scanner(input);
		Apartamentuak apartamentu = new Apartamentuak();
		apartamentu.irakurri(scanner);
		assertEquals(2, apartamentu.getKommun_kop());
		assertEquals(3, apartamentu.getLogela_kop());
	}

}
