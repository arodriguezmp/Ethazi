package erronka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OstatuakTest {

	/**
	 * Ostatuak test bat constructore kopiarena
	 */
	@Test
	public void testOstatuakCopyConstructor() {
		Ostatuak o1 = new Ostatuak(1, 10);
		Ostatuak o2 = new Ostatuak(o1);
		assertEquals(o1.getKod_ostatua(), o2.getKod_ostatua());
		assertEquals(o1.getPertsona_kop(), o2.getPertsona_kop());
	}

}
