/* By: Glen Su
	Date: 18/09/15
	Program Function: A manual input program that compiles user information for a contest 
*/
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
		this.setAdNumber(adNumber);
		this.setAdName(adName);
		this.setCity(city);
		this.setProvince(province);
		this.setPostalCode(postalCode);
		this.setPhoneNumber(phoneNumber);
		this.setBirthDate(birthDate);

	}

	public  ContestantInformation (){

	}

	//set methods
	
	public void setFName(String newFName){

		newFName.toUpperCase().charAt(0);
		newFName.toLowerCase().substring(1);
		this.firstName = newFName;
	}

	public void setLName(String newLName){

		newLName.toUpperCase().charAt(0);
		newLName.toLowerCase().substring(1);
		this.lastName = newLName;
	}
	public void setAdNumber(String newAdNum){

		newAdNum.toUpperCase().charAt(0);
		newAdNum.toLowerCase().substring(1);
		this.addressNumber = newAdNum;
	}

	public void setAdName(String newAdName){

		newAdName.toUpperCase().charAt(0);
		newAdName.toLowerCase().substring(1);
		this.addressName = newAdName;
	}

	public void setCity(String newCity){

		newCity.toUpperCase().charAt(0);
		newCity.toLowerCase().substring(1);
		this.city = newCity;
	}


	public void setProvince(String newProvince){

		newProvince.toUpperCase().charAt(0);
		newProvince.toLowerCase().substring(1);
		this.province = newProvince;
	}

	public void setPostalCode(String newPCode){

		newPCode.toUpperCase().charAt(0);
		newPCode.toLowerCase().substring(1);
		this.postalCode = newPCode;
	}

	public void setPhoneNumber(String newPhoneNumber){

		newPhoneNumber.toUpperCase().charAt(0);
		newPhoneNumber.toLowerCase().substring(1);
		this.phoneNumber = newPhoneNumber;
	}

	public void setBirthDate(int newBDate){

		
		this.birthDate = newBDate;
	}
	
	//get methods
	
	public String getFName() {
				
		return this.firstName;
	}
	
	public String getLName() {
		
		return this.lastName;
	}
	
	public String getAdNumber() {
		
		return this.addressNumber;
	}
	
	public String getAdName() {
		
		return this.addressName;
	}
	
	public String getCity() {
		
		return this.city;
	}
	
	public String getProvince() {
		
		return this.province;
	}
	
	public String getPostalCode() {
		
		return this.postalCode;
	}
	
	public String getPhoneNumber() {
		
		return this.phoneNumber;
	}

	public int getBirthDate() {
		
		return this.birthDate;
	}
	
	//toString method
	
	public String toString(){
		
		return firstName + "" + lastName + "" + addressNumber + "" + addressName + "" + city + "" + province + "" + postalCode + "" + phoneNumber + "" + birthDate;
	}
}
