package pkgApp.controller;   

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;  
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtSaveEachMonth;
	
	@FXML
	private TextField txtAnnualReturn;
	
	@FXML
	private TextField txtNeedToSave;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturn2;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Button btn_clear;

	@FXML 
	private Button btn_calculate;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		txtSaveEachMonth.clear();
		txtYearsToWork.clear();
		txtAnnualReturn.clear();
		txtNeedToSave.clear();
		txtYearsRetired.clear();
		txtAnnualReturn2.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
		
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		// Call AmountToSave and TotalAmountSaved and populate 
		if(txtYearsToWork.getText() == null || txtYearsToWork.getText().length() < 1){
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("FIX ME. or are you retired?");
            alert.setHeaderText("Years to Work=Empty. Change to: 0-100yrs");
            alert.showAndWait();
			
		}
		// annual return(Working)
		else if (txtAnnualReturn.getText() == null || txtAnnualReturn.getText().length() < 1) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Look what ya did you little gerk!");
            alert.setHeaderText("Annual Return for Working is Empty. Change to: 0-20%");
            alert.showAndWait();
		}
		// years retired
		else if(txtYearsRetired.getText() == null || txtYearsRetired.getText().length() <1){
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Kevin, your such a little disease!");
            alert.setHeaderText("Years Retired is Empty. Change to: 0-100yrs");
            alert.showAndWait();
			
		}
		// annual return(Retired) 
		else if (txtAnnualReturn2.getText() == null || txtAnnualReturn2.getText().length() < 1) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Oh wow. Way to go.");
            alert.setHeaderText("Annual Return for Retired is Empty. Change to: 0-3%");
            alert.showAndWait();
		}
		// Required Income 
		else if (txtRequiredIncome.getText() == null || txtRequiredIncome.getText().length() < 1) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("How many licks does it take to get to the center of a lolipop?");
            alert.setHeaderText("Required Income is Empty. Needs Input");
            alert.showAndWait();
		}
		// Monthly SSI
		else if (txtMonthlySSI.getText() == null || txtMonthlySSI.getText().length() < 1) {
			Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("FIX ME. unless you dont do your taxes.");
            alert.setHeaderText("Monthly SSI is Empty. Needs Input");
            alert.showAndWait();
		}
		
		else {

			// TODO: Call AmountToSave and TotalAmountSaved and populate
			DecimalFormat df = new DecimalFormat("###,##0.00");

			int iYearsToWork = Integer.valueOf(txtYearsToWork.getText());
			double dAnnualReturnWorking = Double.valueOf(txtAnnualReturn.getText());
			int iYearsRetired = Integer.valueOf(txtYearsRetired.getText());
			double dAnnualReturnRetired = Double.valueOf(txtAnnualReturn2.getText());
			double dRequiredIncome = Double.valueOf(txtRequiredIncome.getText());
			double dMonthlySSI = Double.valueOf(txtMonthlySSI.getText());
			Retirement retirement = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired,
					dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);

			txtNeedToSave.setText("$" + df.format(retirement.TotalAmountSaved()));
			txtSaveEachMonth.setText("$" + df.format(retirement.AmountToSave()));
			
		}
	}
	
	
	// alert message 
	public void alertMessage(String info, String help){
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("WARNING");
		alert.setHeaderText("INCORRECT");
		alert.setContentText("YOU NEED HELP");
		alert.showAndWait();
	}//i used one for each instead of this singular one.
	
	
}