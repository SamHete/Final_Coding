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
	
	
		}
	

	

