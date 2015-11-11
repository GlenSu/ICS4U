package su;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * This class holds information for a contestant. It creates fields for
 * first name, last name, street address (street number and street name), 
 * city, province, postal code, phone number and birth date.
 * 
 * @author Glen Su
 * Nov 11 2015
 */

@SuppressWarnings("rawtypes")
public class ContestantInformation implements Comparable{

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
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String birthDate;
	private Calendar calender;

	/**
	 * This method is a constructor for a set of variables
	 * @param firstName - first name of the contestant
	 * @param lastName - last name of the contestant
	 * @param addressNumber - address number of the contestant
	 * @param addressName - address name of the contestant
	 * @param city - city name of the contestant
	 * @param province - province name of the contestant
	 * @param postalCode - postal code of the contestant
	 * @param phoneNumber - phone number of the contestant
	 * @param yyyy - birth year of the contestant
	 * @param mm - birth month of the contestant
	 * @param dd - birth day of the contestant
	 * @throws InvalidInputException - If a variable can not be set
	 */
	public ContestantInformation (String firstName,String lastName,String addressNumber, String addressName, String city, String province, String postalCode, String phoneNumber, String yyyy, String mm, String dd) throws InvalidInputException{

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddressNumber(addressNumber);
		this.setAddressName(addressName);
		this.setCity(city);
		this.setProvince(province);
		this.setPostalCode(postalCode);
		this.setPhoneNumber(phoneNumber);
		this.setBirthYear(yyyy);
		this.setBirthMonth(mm);
		this.setBirthDay(dd);
		this.setBirthDate(yyyy, mm, dd);
	}

	/**
	 * This method is a constructor to initialize the variables
	 */
	public  ContestantInformation (){
		
		String firstName = "";
		String lastName = "";
		String addressNumber = "";
		String addressName = "";
		String city = "";
		String province = "";
		String postalCode = "";
		String phoneNumber = "";
		int yyyy = 0000;
		int mm = 00;
		int dd = 00;
		String birthDate = "";
		Calendar calender = new GregorianCalendar();
	}
	
	/**
	 * This method returns the first name of the contestant
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This method is used to set the first name of the contestant.
	 * @param firstName - the contestant's firstName
	 * @throws InvalidInputException - If input contains anything but letters
	 */
	public void setFirstName(String firstName) throws InvalidInputException {
		if(firstName.length() <= 0){
			throw new InvalidInputException("Please enter your first name.");
		}
		for(int i = 0; i < firstName.length(); i++){
			if(!Character.isLetter(firstName.charAt(i))){
				throw new InvalidInputException("Digits do not exist in names. Enter a proper name.");
			}
		}
		firstName = Format.genericFormat(firstName);
		this.firstName = firstName;
	}
	
	/**
	 * Returns the last name of the contestant.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * This method is used to set the last name of the contestant.
	 * @param lastName - the contestant's lastName
	 * @throws InvalidInputException - If input contains anything but letters
	 */
	public void setLastName(String lastName) throws InvalidInputException {
		if(lastName.length() <= 0){
			throw new InvalidInputException("Please enter your last name.");
		}
		for(int i = 0; i < lastName.length(); i++){
			if(!Character.isLetter(lastName.charAt(i))){
				throw new InvalidInputException("Digits do not exist in names. Enter a proper name.");
			}
		}
		lastName = Format.genericFormat(lastName);
		this.lastName = lastName;
	}

	/**
	 * Returns the address number of the contestant.
	 * @return the addressNumber
	 */
	public String getAddressNumber() {
		return addressNumber;
	}

	/**
	 * This is used to set the street number of the contestant.
	 * @param addressNumber the addressNumber to set
	 * @throws InvalidInputException - If input contains anything but letters
	 */
	public void setAddressNumber(String addressNumber) throws InvalidInputException {
		int adlength = addressNumber.length();
		if(adlength <= 0){
			throw new InvalidInputException("Please enter your street address number.");
		}
		else if(adlength > 10){
			throw new InvalidInputException("This address seems a little too long. Please input a smaller address");
		}
		else if(adlength > 2){
			for(int i = adlength - 2; i > 0; i--){
				if(!Character.isDigit(addressNumber.charAt(adlength - i))){
					throw new InvalidInputException("This address does not exist in Canada. Please enter a proper address.");
				}
			}
		}
		else if(adlength <= 1){
			for(int i = 0; i< adlength; i++){
				if(!Character.isDigit(addressNumber.charAt(i))){
					throw new InvalidInputException("This address does not exist in Canada. Please enter a proper address.");
				}
			}
		}
		addressNumber.toUpperCase();
		this.addressNumber = addressNumber;
	}

	/**
	 * Returns the address name of the contestant.
	 * @return the addressName
	 */
	public String getAddressName() {
		return addressName;
	}

	/**
	 * This method is used to set the street name of the contestant. 
	 * The user inputs their street name and suffix
	 * @param addressName - the contestant's addressName
	 * @throws InvalidInputException - If input contains anything but letters or digits
	 */
	//may include an option to choose the suffix from a selection box.
	public void setAddressName(String addressName) throws InvalidInputException {
		int count = 0;
		int space = 0;
		if(addressName.length() <= 0){
			throw new InvalidInputException("Please enter your street address name.");
		}
		for(int i = 0; i< addressName.length(); i++){
			if(!Character.isLetterOrDigit(addressName.charAt(i)) && !Character.isSpaceChar(addressName.charAt(i))){
				throw new InvalidInputException("This address does not exist in Canada. Please enter a proper address.");
			}
		}	
		addressName = Format.genericFormat(addressName);
		this.addressName = addressName;
	}

	/**
	 * Returns the city of the contestant.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**	
	 * This method is used to set the city name of the contestant.
	 * @param city - the contestant's city
	 * @throws InvalidInputException - If input contains anything but letters
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
		city = Format.genericFormat(city);
		this.city = city;
	}

	/**	 
	 * Returns the province of the contestant.
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * This method is used to set the province name of the contestant. 
	 * @param province - the contestant's province
	 * @throws InvalidInputException - If input is nvalid
	 */
	public String setProvince(String province) throws InvalidInputException {
		boolean flag = false;
		do{
			if(province.length() <= 0){
				throw new InvalidInputException("Please enter the province or territory you are from.");
			}
			for(int i = 0; i< province.length(); i++){
				if(Character.isDigit(province.charAt(i))){
					throw new InvalidInputException("This is not a province name. Please only enter letters.");
				}
			}
			//province = Format.genericFormat(province);

			if(province.equalsIgnoreCase("Ontario")|| province.equalsIgnoreCase("Ont.") || province.equalsIgnoreCase("ON")){
				this.province = "ON";
				flag = false;
			}
			else if(province.equalsIgnoreCase("British Columbia")|| province.equalsIgnoreCase("B.C.") || province.equalsIgnoreCase("BC")){
				this.province = "BC";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Alberta")|| province.equalsIgnoreCase("Alta.") || province.equalsIgnoreCase("AB")){
				this.province = "AB";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Manitoba")|| province.equalsIgnoreCase("Man.") || province.equalsIgnoreCase("MB")){
				this.province = "MB";
				flag = false;
			}
			else if(province.equalsIgnoreCase("New Brunswick")|| province.equalsIgnoreCase("N.B.") || province.equalsIgnoreCase("NB")){
				this.province = "NB";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Newfoundland and Labrador")|| province.equalsIgnoreCase("Newfoundland") || province.equalsIgnoreCase("Labrador") ||  province.equalsIgnoreCase("LB") || province.equalsIgnoreCase("NL") || province.equalsIgnoreCase("NF") ||  province.equalsIgnoreCase("Nfld.")){
				this.province = "NL";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Nova Scotia")|| province.equalsIgnoreCase("N.S.") || province.equalsIgnoreCase("NS")){
				this.province = "NS";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Northwest Territories")|| province.equalsIgnoreCase("N.W.T.") || province.equalsIgnoreCase("NT") || province.equalsIgnoreCase("NWT")){
				this.province = "NT";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Nunavut")|| province.equalsIgnoreCase("Nun.") || province.equalsIgnoreCase("Nvt.") || province.equalsIgnoreCase("NU")){
				this.province = "NU";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Quebec")|| province.equalsIgnoreCase("Que.") || province.equalsIgnoreCase("QC")){
				this.province = "QC";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Prince Edward Island")|| province.equalsIgnoreCase("P.E.I.") || province.equalsIgnoreCase("PEI") || province.equalsIgnoreCase("PE")){
				this.province = "PE";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Saskatchewan")|| province.equalsIgnoreCase("Sask.") || province.equalsIgnoreCase("SK")){
				this.province = "SK";
				flag = false;
			}
			else if(province.equalsIgnoreCase("Yukon Territories")|| province.equalsIgnoreCase("Yukon") || province.equalsIgnoreCase("YT")){
				this.province = "YT";
				flag = false;
			}
			else {
				System.out.println("Your input was not in the database, please check your spelling and try again.");
				province = "NA";
				flag = true;
			}
			if (flag){
				province = scan.nextLine();
			}
		}
		while(flag);
		return province;	
		//this.province = province.;
	}

	/**
	 * Returns the postal code of the contestant.
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * This method is used to set the postal code of the contestant. 
	 * Input must be in the format of: X#X#X# where 'X' is a letter and # is a number.
	 * @param postalCode - the contestant's postalCode
	 * @throws InvalidInputException - If input is not in order or has too many/few characters
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
		postalCode.toUpperCase();

		this.postalCode = postalCode;
	}

	/**
	 * Returns the phone number of the contestant.
	 * @return - the contestant's phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method is used to set the phone number of the user.
	 * Information must be in the format of: ########## where '#' is a number.
	 * This will also format the phone number.
	 * @param phoneNumber - phone number of the contestant
	 * @throws InvalidInputException - If input contains too many/few numbers or non-integer values
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
		this.phoneNumber = phoneNumber;
	}


	/**
	 * Returns the year the contestant was born in.
	 * @return - the contestant's year of birth
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * This method is used to format the year the contestant was born in.
	 * @param dateChecker - the year of birth to verify if it is a legitimate year
	 * @throws InvalidInputException 
	 */
	public void setBirthYear(String dateChecker) throws InvalidInputException {
		if(dateChecker.length() <= 0){
			throw new InvalidInputException("Please enter your year of birth.");
		}
		else if(Integer.parseInt(dateChecker) >= 2016){
			throw new InvalidInputException("This year is too far in the future. Please enter a proper value.");
		}
		for (int i = 0; i< dateChecker.length(); i++){
			if(!Character.isDigit(dateChecker.charAt(i))){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		this.birthYear = Integer.parseInt(dateChecker);
	}

	/**
	 * Returns the month the contestant was born in.
	 * @return  - the contestant's birth month
	 */
	public int getBirthMonth() {
		return birthMonth;
	}

	/**
	 * This method is used to format the month the contestant was born in.
	 * @param dateChecker - the month of birth to verify if it is a legitimate month
	 * @throws InvalidInputException 
	 */
	public void setBirthMonth(String dateChecker) throws InvalidInputException {
		if(dateChecker.length() <= 0){
			throw new InvalidInputException("Please enter your month of birth.");
		}
		else if(Integer.parseInt(dateChecker) >= 13){
			throw new InvalidInputException("This month does not exist. Please enter a proper value.");
		}
		for (int i = 0; i < dateChecker.length(); i++){
			if(!Character.isDigit(dateChecker.charAt(i))){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		this.birthMonth = Integer.parseInt(dateChecker);
	}

	/**
	 * Returns the day the contestant was born in.
	 * @return - the contestant's birth day
	 */
	public int getBirthDay() {
		return birthDay;
	}

	/**
	 * This method is used to format the day the contestant was born on.
	 * @param dateChecker - the day of birth to verify if it is a legitimate day
	 * @throws InvalidInputException 
	 */
	public void setBirthDay(String dateChecker) throws InvalidInputException {
		if(dateChecker.length() <= 0){
			throw new InvalidInputException("Please enter your day of birth.");
		}
		
		for (int i = 0; i < dateChecker.length(); i++){
			if(!Character.isDigit(dateChecker.charAt(i))){
				throw new InvalidInputException("One of the characters you inputted is not digit. Please re-enter with digits only and try again.");
			}
		}
		if(Integer.parseInt(dateChecker) >= 32){
			throw new InvalidInputException("This day does not exist. Please enter a proper value.");
		}
		else if(Integer.parseInt(dateChecker) >= 32 && birthMonth == 01 && birthMonth == 03 && birthMonth == 05 && birthMonth == 07 && birthMonth == 10 && birthMonth == 12){
			throw new InvalidInputException("This day does not exist. Please enter a proper value.");
		}
		else if(Integer.parseInt(dateChecker) >= 31 && birthMonth == 04 && birthMonth == 06 && birthMonth == 8 && birthMonth == 9 && birthMonth == 11){
			throw new InvalidInputException("This day does not exist. Please enter a proper value.");
		}
		else if(Integer.parseInt(dateChecker) >= 29 && birthMonth == 02){
			throw new InvalidInputException("This day does not exist. Please enter a proper value.");
		}
		this.birthDay = Integer.parseInt(dateChecker);
	}

	/**
	 * Returns a formatted date the contestant was born in.
	 * @return - formatted birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * This method is used to format the full date the contestant was born in.
	 * @param birthYear - the year the contestant was born in
	 * @param birthMonth - the month the contestant was born in
	 * @param birthDay - the day the contestant was born in
	 */
	public void setBirthDate(String birthYear, String birthMonth, String birthDay) {
		this.birthDate = birthYear + "/" + birthMonth + "/" + birthDay;
		
	}
	
	/**
	 * This method is used to format the full date the contestant was born in.
	 * @param birthYear - the year the contestant was born in
	 * @param birthMonth - the month the contestant was born in
	 * @param birthDay - the day the contestant was born in
	 */
	public void setBirthDate(int birthYear, int birthMonth, int birthDay) {
		this.birthDate = birthYear + "/" + birthMonth + "/" + birthDay;
		
	}

	/**
	 * This method compiles all the information into a single string
	 * @return the firstName, lastName, addressNumber, addressName, city, province, postalCode, phoneNumber, and birthDate
	 */
	public String toString(){

		return firstName + " " + lastName + " " + addressNumber + " " + addressName + " " + city + " " + province + " " + postalCode + " " + phoneNumber + " " + birthDate;
	}
	
	/**
	 * This method checks the array of ContestantInformation objects to see if a specified object is found
	 * @param target - the object to search for
	 * @return - a boolean value
	 */
	public boolean equals(ContestantInformation target){

			if(this.getFirstName().equals(target.getFirstName()) && this.getLastName().equals(target.getLastName())){				
				return true;
			}

		return false;
	}
	/**
	 * Compares two ContestantInformation objects by use of the first and last names 
	 * associated with them respectively and orders the objects based on the Unicode 
	 * values of each character in the strings of first and last names.
	 * @param args - the object 
	 * @return - the index of the arraylist or -1 if not found
	 */
	public int compareTo(Object args){
		ContestantInformation ci = (ContestantInformation)args;
		int compareTo = 0;
		compareTo = ci.getFirstName().compareTo(this.getFirstName());
		if(compareTo == 0)
		{				
			compareTo = ci.getLastName().compareTo(this.getLastName());
			if(compareTo == 0){				
				return 0;
			}
			else if (compareTo > 0)
			{
				return 1;
			}
			else //if (compareTo < 0)
			{
				return -1;
			}
		}
		else if (compareTo > 0)
		{
			return 1;
		}
		else //if (compareTo < 0)
		{
			return -1;
		}
	}
	
	
	
}
