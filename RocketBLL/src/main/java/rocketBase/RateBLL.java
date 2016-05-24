package rocketBase;

import org.apache.poi.ss.formula.functions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		// 
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		ArrayList<RateDomainModel> allRates = _RateDAL.getAllRates();
		double Interest= 0.0;
		for (Iterator iterator = allRates.iterator(); iterator.hasNext();) {
			RateDomainModel rate = (RateDomainModel) iterator.next();
			if(rate != null && (rate.getiMinCreditScore() == GivenCreditScore))
			{
				Interest = rate.getdInterestRate();
			}
			/*if(Interest == 0){
				
				//throw new RateException("Missing Interest rate corresponding to credit score.");
			}
			*/
			
		}
		return Interest;
		}
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
