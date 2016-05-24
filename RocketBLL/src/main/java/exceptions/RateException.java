package exceptions;
import rocketDomain.RateDomainModel;
public class RateException extends Exception {

RateDomainModel RDModel = new RateDomainModel();
	
	public RateException(RateDomainModel rateDomain){
		
		RDModel = rateDomain;
		
	}
	
	public RateException(String error) {
		super (error);
	}
	public RateDomainModel getRateDomain() {
		return RDModel;
	}
}
