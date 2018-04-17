package gsu.edu.cis2370.DATABASE;

public class Customer extends User {
	
	private int customerID;
	
	public int getCustomerID(){
		return customerID;
	}
	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	Customer p1 = new Customer ();
	
}
