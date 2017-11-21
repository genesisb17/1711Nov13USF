package warmup;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class test {
	
	WarmUp warm = new WarmUp();
	@Test
	public void oddEven() throws Exception{
		String actual = "odd";
		String expected = warm.oddOrEven(5);
		assertEquals(expected, actual);
		
	}

}
