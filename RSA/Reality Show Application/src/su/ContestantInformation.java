package su;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class holds information for a contestant. It create fields for
 * first name, last name, street address (street number and street name), 
 * city, province, postal code, phone number and birth date.
 * 
 * @author Glen Su
 *	Sept 22 2015
 */
public class ContestantInformation {

	//initializations for first name, last name, street address (street number and street name), city, province, postal code, phone number and birth date
	private String firstName;
	private String lastName;
	private String addressNumber;
	private String addressName;
	private String city;
	private String province;
	private String postalCode;
	private String phoneNumber;
	private String birthDate;
	private Calendar calender = new GregorianCalendar();

	public ContestantInformation (String firstName,String lastName,String addressNumber, String addressName, String city, String province, String postalCode, String phoneNumber,String birthDate) throws InvalidInputException{

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddressNumber(addressNumber);
		this.setAddressName(addressName);
		this.setCity(city);
		this.setProvince(province);
		this.setPostalCode(postalCode);
		this.setPhoneNumber(phoneNumber);
		this.setBirthDate(birthDate);

	}

	public  ContestantInformation (){

	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		firstName.toUpperCase().charAt(0);
		firstName.toLowerCase().substring(1);
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		lastName.toUpperCase().charAt(0);
		lastName.toLowerCase().substring(1);
		this.lastName = lastName;
	}

	/**
	 * @return the addressNumber
	 */
	public String getAddressNumber() {
		return addressNumber;
	}

	/**
	 * @param addressNumber the addressNumber to set
	 */
	public void setAddressNumber(String addressNumber) {
		addressNumber.toUpperCase().charAt(0);
		this.addressNumber = addressNumber;
	}

	/**
	 * @return the addressName
	 */
	public String getAddressName() {
		return addressName;
	}

	/**
	 * @param addressName the addressName to set
	 */
	public void setAddressName(String addressName) {
		addressName.toUpperCase().charAt(0);
		addressName.toLowerCase().substring(1);
		this.addressName = addressName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		city.toUpperCase().charAt(0);
		city.toLowerCase().substring(1);
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		province.toUpperCase().charAt(0);
		province.toLowerCase().substring(1);
		this.province = province;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 * @throws InvalidInputException 
	 */
	public void setPostalCode(String postalCode) throws InvalidInputException {
		if(postalCode.length() >6 || postalCode.length()<6){

			throw new InvalidInputException("The input is not the correct length, please input only 6 characters.");

		}
		else if (Character.isSpaceChar(postalCode.charAt(3))){
			throw new InvalidInputException("Please remove the space inside the postal code and enter your input again.");
		}
		else{
			for(int i=0;i<5; i++){
				
				if(i == 0|| i ==2 || i == 4){
					if(!Character.isLetter(postalCode.charAt(i))){
						throw new InvalidInputException("The input does not have letters in the pattern such as: X#X #X# .");
					}
				}
				else if(i == 1|| i ==3 || i == 5){
					if(!Character.isDigit(postalCode.charAt(i))){
						throw new InvalidInputException("The input does not have letters in the pattern such as: X#X #X# .");
					}
				}
			}
		}
		postalCode.toUpperCase().charAt(0);
		this.postalCode = postalCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		phoneNumber.toUpperCase().charAt(0);
		phoneNumber.toLowerCase().substring(1);
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(int yyyy, int mm, int dd) {
		this.calender.set(yyyy, mm, dd);
		this.birthDate = calender.toString();
		
	}

	/**
	 * @return the firstName, lastName, addressNumber, addressName, city, province, postalCode, phoneNumber, and birthDate
	 */
	public String toString(){

		return firstName + " " + lastName + " " + addressNumber + " " + addressName + " " + city + " " + province + " " + postalCode + " " + phoneNumber + " " + birthDate;
	}
}
