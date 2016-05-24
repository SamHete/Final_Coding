package rocketBase;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import exceptions.RateException;
import rocketDomain.RateDomainModel;
import rocketData.LoanRequest;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test(expected = RateException.class) 
	public void testRate() throws RateException  {
		double rates;
		rates = RateBLL.getRate(10);
	}
	
	@Test (expected = RateException.class)
	public void testRateEx1() throws Exception {
		assertEquals(RateBLL.getRate(800), 4, 0.01);
	}
	
	@Test
	public void testRateEx2(){
		try {
			assertEquals(RateBLL.getRate(720), 4, 0.001);
		} catch (RateException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testPayment(){
		double payment = RateBLL.getPayment(0.04/12.0, 360.0, 300000.0, 0.0, false);
		assertEquals(payment, 1432.25, 0.01);
	}
	
}
	

	

