package rocket.app.view;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;
import java.text.DecimalFormat;
import java.awt.Button;


import java.text.NumberFormat;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	TextField txtCreditScore;
	@FXML
	TextField txtHouseCost;
	@FXML
	TextField txtIncome;
	@FXML
	TextField txtExpenses;
	@FXML
	ComboBox<String> cmbTerm;
	@FXML
	Label lblMortgagePayment;
	@FXML
	private Label Errors;
	@FXML
	private Button button;
	
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	
	@FXML
	private void initiailize(){
		ObservableList<String> cmbBox = FXCollections.observableArrayList("15 years ", "30 years ");
		cmbTerm.setItems(cmbBox);
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq
		lblMortgagePayment.setText("");
		
		//Text Input
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		
		//Term select
		int Term = 0;
		if(cmbTerm.getValue() == "15 years"){
			Term = 15;
		}else{
			Term = 30;
		}
		lq.setiTerm(Term);
		System.out.println(Term);
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		
		NumberFormat number = NumberFormat.getCurrencyInstance();
		Label Rate = null;
		if (lRequest.getdRate() < 0) 
		{
			System.out.println("You cannot afford this house.");	
		
		}
		else 
		{
			number.format(lRequest.getdPayment());
			Rate.setText(number.format(lRequest.getdRate()/100));
		}
		Rate.setText("");
		
	}
}
