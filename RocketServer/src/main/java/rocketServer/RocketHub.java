package rocketServer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;
import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;

public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Autowired
	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			double payment = 0.0;
			double rate = 0.0;
			try{
				rate = _RateBLL.getRate(lq.getiCreditScore());
				payment = RateBLL.getPayment(lq.getiCreditScore(), lq.getiTerm(), lq.getdAmount(), 0, false);
				
			}
			// outputs error message if there is exception
			catch (RateException exception){
				sendToAll(exception);
				System.out.println("Error: No rate");
				}
			// update lq
			lq.setdRate(rate);
			lq.setdPayment(payment);
			// send back to caller
			sendToAll(lq);
		}
	}
}
