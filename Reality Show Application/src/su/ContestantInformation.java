package su;

public class ContestantInformation {

	//first name, last name, street address (street number and street name), city, province, postal code, phone number and birth date
	private String firstName;
	private String lastName;
	private String addressNumber;
	private String addressName;
	private String city;
	private String province;
	private String postalCode;
	private String phoneNumber;
	private int birthDate;
	
	public ContestantInformation (String fName,String lName,String adNumber, String adName, String city, String province, String postalCode, String phoneNumber,int birthDate){
	
		this.setFName(fName);
		this.setLName(lName);
		this.setadNumber(adNumber);
		this.setAdName(adName);
		this.setCity(city);
		this.setProvince(province);
		this.setPostalCode(postalCode);
		this.setPhoneNumber(phoneNumber);
		this.setBirthDate(birthDate);
		
	}
	
	public  ContestantInformation (){
		
	}
	
	public void setFName(String newFName){
	
		
		this.firstName = newFName;
	}
	
public void setLName(String newLName){
	
		
		this.lastName = newLName;
	}
public void setadNumber(String newAdNum){
	
	
	this.addressNumber = newAdNum;
}

public void setAdName(String newAdName){
	
	
	this.addressName = newAdName;
}

public void setCity(String newCity){
	
	
	this.city = newCity;
}


public void setProvince(String newProvince){
	
	
	this.province = newProvince;
}

public void setPostalCode(String newPCode){
	
	
	this.postalCode = newPCode;
}

public void setPhoneNumber(String newPhoneNumber){
	
	
	this.phoneNumber = newPhoneNumber;
}
	
public void setBirthDate(int newBDate){
	
	
	this.birthDate = newBDate;
}
	
}
