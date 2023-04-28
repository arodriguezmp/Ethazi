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
		Erreserba erreserba = new Erreserba("11111111A", 100, new Date(), new Date(), 1);

		assertEquals("11111111A", erreserba.getNan());

	}
}
