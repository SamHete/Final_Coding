package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void testRates1() {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		for(RateDomainModel tests: rates){
			System.out.println(tests);
		}
		assertTrue(rates.get(0).getdInterestRate() == 1.0);
		assertTrue(rates.get(1).getdInterestRate() == 1.5);
		assertTrue(rates.get(2).getdInterestRate() == 2.0);
		assertTrue(rates.get(4).getdInterestRate() == 3.0);
		
		assert(1==1);
	}
	public void testRates2() {
		ArrayList<RateDomainModel> allRates = RateDAL.getAllRates();
		assertTrue(allRates.get(-1).getdInterestRate() == 0 );
	}
}
