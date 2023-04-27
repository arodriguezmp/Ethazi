package erronka;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ErreserbaTest {

	/**
	 * test bat konstruktorea aldatzeko
	 */
	@Test
	public void testConstructor() {
		Erreserba erreserba = new Erreserba("12345678A", 100, new Date(), new Date(), 1);
		assertEquals(100, erreserba.getPrezioa());
		assertEquals("12345678A", erreserba.getNan());
		assertEquals(1, erreserba.getKod_ostatua());
	}
}
