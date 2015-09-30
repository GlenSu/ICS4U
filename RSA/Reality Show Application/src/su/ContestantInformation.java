package su;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * This class holds information for a contestant. It create fields for
 * first name, last name, street address (street number and street name), 
 * city, province, postal code, phone number and birth date.
 * 
 * @author Glen Su
 *	Sept 28 2015
 */
public class ContestantInformation {

	//initializations for first name, last name, street address (street number and street name), city, province, postal code, phone number and birth date

	Scanner scan = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private String addressNumber;
	private String addressName;
	private String city;
	private String province;
	private String postalCode;
	private String phoneNumber;
	private int yyyy;
	private int mm;
	private int dd;
	private String birthDate;
	private Calendar calender = new GregorianCalendar();

	public ContestantInformation (String firstName,String lastName,String addressNumber, String addressName, String city, String province, String postalCode, String phoneNumber,int yyyy, int mm, int dd) throws InvalidInputException{

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddressNumber(addressNumber);
		this.setAddressName(addressName);
		this.setCity(city);
		this.setProvince(province);
		this.setPostalCode(postalCode);
		this.setPhoneNumber(phoneNumber);
		this.setyyyy(yyyy);
		this.setmm(mm);
		this.setdd(dd);
		this.setBirthDate(yyyy, mm, dd);

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
	 * This method is used to send the first name of the contestant.
	 * @param firstName the firstName to set
	 * @throws InvalidInputException 
	 */
	public void setFirstName(String firstName) throws InvalidInputException {
		if(firstName.length() <= 0){
			throw new InvalidInputException("Please enter your first name.");
		}
		for(int i = 0; i < firstName.length(); i++){
			if(Character.isDigit(firstName.charAt(i))){
				throw new InvalidInputException("Please do not enter digits in your name. Enter a proper name.");
			}
		}
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
	 * This method is used to send the last name of the contestant.
	 * @param lastName the lastName to set
	 * @throws InvalidInputException 
	 */
	public void setLastName(String lastName) throws InvalidInputException {
		if(lastName.length() <= 0){
			throw new InvalidInputException("Please enter your last name.");
		}
		for(int i = 0; i < lastName.length(); i++){
			if(Character.isDigit(lastName.charAt(i))){
				throw new InvalidInputException("Please do not enter digits in your name.");
			}
		}
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
	 * This is used to send the street number of the contestant.
	 * @param addressNumber the addressNumber to set
	 * @throws InvalidInputException 
	 */
	public void setAddressNumber(String addressNumber) throws InvalidInputException {
		if(addressNumber.length() <= 0){
			throw new InvalidInputException("Please enter your street number.");
		}
		else if(addressNumber.length() > 2){
			if(Character.isLetter(addressNumber.charAt(addressNumber.length() - 2))){
				throw new InvalidInputException("This address does not exist in Canada. Please enter a proper address.");
			}
		}
		else if(addressNumber.length() < 1){
			for(int i = 0; i< addressNumber.length(); i++){
				if(!Character.isLetter(addressNumber.charAt(i))){
					throw new InvalidInputException("This address does not exist in Canada. Please enter a proper address.");
				}
			}
		}
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
	 * This method is used to send the street name of the contestant. 
	 * The user inputs their street name but has to choose the suffix from a selection box. 
	 * @param addressName the addressName to set
	 * @throws InvalidInputException 
	 */
	public void setAddressName(String addressName) throws InvalidInputException {
		if(addressName.length() <= 0){
			throw new InvalidInputException("Please enter your street name.");
		}
		for(int i = 0; i< addressName.length(); i++){
			if(!Character.isLetterOrDigit(addressName.charAt(i))){
				throw new InvalidInputException("This address does not exist in Canada. Please enter a proper address.");
			}
		}
		
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
	 * This method is used to send the city name of the contestant.
	 * @param city the city to set
	 * @throws InvalidInputException 
	 */
	public void setCity(String city) throws InvalidInputException {
		if(city.length() <= 0){
			throw new InvalidInputException("Please enter your city name.");
		}
		for(int i = 0; i< city.length(); i++){
			if(!Character.isLetter(city.charAt(i))){
				throw new InvalidInputException("This is not a city name. Please only enter letters.");
			}
		}
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
	 * This method is used to send the province name of the contestant. 
	 * @param province the province to set
	 * @throws InvalidInputException 
	 */
	public void setProvince(String province) throws InvalidInputException {
		if(province.length() <= 0){
			throw new InvalidInputException("Please enter the province or territory name you are from.");
		}
		for(int i = 0; i< province.length(); i++){
			if(Character.isDigit(province.charAt(i))){
				throw new InvalidInputException("This is not a province name. Please only enter letters.");
			}
		}
		province.toUpperCase().charAt(0);
		province.toLowerCase().substring(1);
		
		if(province.equalsIgnoreCase("Ontario")|| province.equalsIgnoreCase("Ont.") || province.equalsIgnoreCase("ON")){
			this.province = "ON";
		}
		else if(province.equalsIgnoreCase("British Columbia")|| province.equalsIgnoreCase("B.C.") || province.equalsIgnoreCase("BC")){
			this.province = "BC";
		}
		else if(province.equalsIgnoreCase("Alberta")|| province.equalsIgnoreCase("Alta.") || province.equalsIgnoreCase("AB")){
			this.province = "AB";
		}
		else if(province.equalsIgnoreCase("Manitoba")|| province.equalsIgnoreCase("Man.") || province.equalsIgnoreCase("MB")){
			this.province = "MB";
		}
		else if(province.equalsIgnoreCase("New Brunswick")|| province.equalsIgnoreCase("N.B.") || province.equalsIgnoreCase("NB")){
			this.province = "NB";
		}
		else if(province.equalsIgnoreCase("Newfoundland and Labrador")|| province.equalsIgnoreCase("Newfoundland") || province.equalsIgnoreCase("Labrador") ||  province.equalsIgnoreCase("LB") || province.equalsIgnoreCase("NL") || province.equalsIgnoreCase("NF") ||  province.equalsIgnoreCase("Nfld.")){
			this.province = "NL";
		}
		else if(province.equalsIgnoreCase("Nova Scotia")|| province.equalsIgnoreCase("N.S.") || province.equalsIgnoreCase("NS")){
			this.province = "NS";
		}
		else if(province.equalsIgnoreCase("Northwest Territories")|| province.equalsIgnoreCase("N.W.T.") || province.equalsIgnoreCase("NT") || province.equalsIgnoreCase("NWT")){
			this.province = "NT";
		}
		else if(province.equalsIgnoreCase("Nunavut")|| province.equalsIgnoreCase("Nun.") || province.equalsIgnoreCase("Nvt.") || province.equalsIgnoreCase("NU")){
			this.province = "NU";
		}
		else if(province.equalsIgnoreCase("Quebec")|| province.equalsIgnoreCase("Que.") || province.equalsIgnoreCase("QC")){
			this.province = "QC";
		}
		else if(province.equalsIgnoreCase("Prince Edward Island")|| province.equalsIgnoreCase("P.E.I.") || province.equalsIgnoreCase("PEI") || province.equalsIgnoreCase("PE")){
			this.province = "PE";
		}
		else if(province.equalsIgnoreCase("Saskatchewan")|| province.equalsIgnoreCase("Sask.") || province.equalsIgnoreCase("SK")){
			this.province = "SK";
		}
		else if(province.equalsIgnoreCase("Yukon Territories")|| province.equalsIgnoreCase("Yukon") || province.equalsIgnoreCase("YT")){
			this.province = "YT";
		}
		else {
			System.out.println("Your input was not in the database, please check your spelling and try again.");
			this.province = "null";
		}

		//this.province = province.;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * This method is used to send the postal code of the contestant. 
	 * Input must be in the format: X#X#X#.
	 * @param postalCode the postalCode to set
	 * @throws InvalidInputException 
	 */
	public void setPostalCode(String postalCode) throws InvalidInputException {
		if(postalCode.length() <= 0){
			throw new InvalidInputException("Please enter your postal code.");
		}
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
	 * This method is used to send the phone number of the user.
	 * Information must be in the format: ##########.
	 * @param phoneNumber the phoneNumber to set
	 * @throws InvalidInputException 
	 */

	public void setPhoneNumber(String phoneNumber) throws InvalidInputException {
		if(phoneNumber.length() <= 0){
			throw new InvalidInputException("Please enter your phonenumber.");
		}
		if(phoneNumber.length() < 10){
			throw new InvalidInputException("This phone number is too short. Please enter 10 digits only.");
		}
		else if(phoneNumber.length() > 10){
			throw new InvalidInputException("This phone number is too long. Please enter 10 digits only.");
		}
		else{
		for (int i = 0; i < phoneNumber.length(); i++)
			if(!Character.isDigit(phoneNumber.charAt(i))){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		String areaCode = "(";
		for (int i = 0; i< phoneNumber.length(); i++){
			if(i < 4){
				
				areaCode = areaCode + phoneNumber.charAt(i);
			}
			else if(i==4){
				areaCode = areaCode + ") " + phoneNumber.charAt(i);
			}
			else if(i == 5 || i== 6){
				areaCode = areaCode + phoneNumber.charAt(i);
			}
			else if(i == 7){
				areaCode = areaCode + " - " + phoneNumber.charAt(i);
			}
			else if(i>7){
				areaCode = areaCode + phoneNumber.charAt(i);
			}
		}
	}


	/**
	 * @return the yyyy
	 */
	public int getyyyy() {
		return yyyy;
	}

	/**
	 * @param yyyy the yyyy to set
	 * @throws InvalidInputException 
	 */
	public void setyyyy(int yyyy) throws InvalidInputException {
		if(yyyy <= 0){
			throw new InvalidInputException("Please enter your year of birth.");
		}
		for (int i = 0; i < yyyy; i++){
			if(!Character.isDigit(yyyy)){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		this.yyyy = yyyy;
	}

	/**
	 * @return the mm
	 */
	public int getmm() {
		return mm;
	}

	/**
	 * @param mm the mm to set
	 * @throws InvalidInputException 
	 */
	public void setmm(int mm) throws InvalidInputException {
		if(mm <= 0){
			throw new InvalidInputException("Please enter your month of birth.");
		}
		for (int i = 0; i < mm; i++){
			if(!Character.isDigit(mm)){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		this.mm = mm;
	}

	/**
	 * @return the dd
	 */
	public int getdd() {
		return dd;
	}

	/**
	 * @param dd the dd to set
	 * @throws InvalidInputException 
	 */
	public void setdd(int dd) throws InvalidInputException {
		if(dd <= 0){
			throw new InvalidInputException("Please enter your day of birth.");
		}
		for (int i = 0; i < dd; i++){
			if(!Character.isDigit(dd)){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		this.dd = dd;
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
