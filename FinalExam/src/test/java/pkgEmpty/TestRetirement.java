package pkgEmpty;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

import pkgCore.Retirement;

public class TestRetirement {

	@Test
	public void testRetirement() {
		Retirement r = new Retirement(40, 0.07, 20, 0.02, 10000, 2642);
		System.out.println(r.AmountToSave()); 
		System.out.println(r.TotalAmountSaved()); 
		assertTrue(554.1291237405718 == r.AmountToSave());
		assertTrue(1454485.5484009797 == r.TotalAmountSaved());

}
}