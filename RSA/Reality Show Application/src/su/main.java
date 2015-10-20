/**
 * 
 */
package su;
import java.util.*;
/**
 * This class is used as the main functions of the program. 
 * 
 * @author Glen Su
 * Sept 29 2015
 */
public class main {
	

	
	
	/**
	 * This is the main method of the program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag1 = true;
		String userAnswer;
		Scanner scan = new Scanner(System.in);
		ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();

		System.out.println("Welcome to the contestant application form.");
		System.out.println("Please enter the number corresponding to the option to choose that option.");
		System.out.println("1. Add a new contestant.");
		System.out.println("2. Print out all the contestant information.");
		System.out.println("3. Exit the program.");
		System.out.println("4. Search for a contestant.");

		do{
			userAnswer = scan.nextLine();
			for(int i = 0; i< userAnswer.length(); i++){
				if(!Character.isDigit(userAnswer.charAt(i)) && userAnswer.substring(i) == "." || userAnswer.substring(i) == ","){
					System.out.println("");
					i = userAnswer.length(); 
				}					
			}
			if(userAnswer.equalsIgnoreCase("1") || userAnswer.equalsIgnoreCase("1.") || userAnswer.equalsIgnoreCase("1,")){
				System.out.println("Initiating option.");
				System.out.println();
				addContestant(contestants);
				flag1 = true;
				System.out.println("Task completed.");
				System.out.println("Is there something else you would like to do?");
			}
			else if(userAnswer.equalsIgnoreCase("2") || userAnswer.equalsIgnoreCase("2.") || userAnswer.equalsIgnoreCase("2,")){
				System.out.println("Initiating option.");
				System.out.println();
				displayLabel(contestants);
				flag1 = true;
				System.out.println("Task completed.");
				System.out.println("Is there something else you would like to do?");
			}
			else if(userAnswer.equalsIgnoreCase("3") || userAnswer.equalsIgnoreCase("3.") || userAnswer.equalsIgnoreCase("3,")){
				System.out.println("Thank you for choosing this program for organising contestant data.");
				flag1 = false;
			}
			else if(userAnswer.equalsIgnoreCase("3") || userAnswer.equalsIgnoreCase("3.") || userAnswer.equalsIgnoreCase("3,")){
				System.out.println("Initiating option.");
				System.out.println();
				displayLabel(contestants);
				flag1 = true;
				System.out.println("Task completed.");
				System.out.println("Is there something else you would like to do?");
			}
			else{
				System.out.println("That was not a valid option.");
				System.out.println("Please input a proper value. [1, 2, or 3]");
			}
		}while(flag1);
	}

	public static void addContestant(ArrayList<ContestantInformation> contestants){
		Scanner scan = new Scanner(System.in);
		ContestantInformation contestant1 = new ContestantInformation();
		
		int age = 0;
		String firstName;
		String lastName;
		String addressNumber;
		String addressName;
		String city;
		String province;
		String postalCode;
		String phoneNumber;
		String birthDate;
		String moreContestants;
		String output;
		String dateChecker;
		int yyyy=0;
		int mm=0;
		int dd=0;
		boolean flag1 = false;
		boolean flag2 = false;
		do{
			flag2 = false;
			
			System.out.println("Please enter your first name.");
			do{
				try{
					firstName = scan.nextLine();
					contestant1.setFirstName(firstName);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter your last name.");
			do{
				try{
					lastName = scan.nextLine();
					contestant1.setLastName(lastName);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter your street address number.");
			do{
				try{
					addressNumber = scan.nextLine();
					contestant1.setAddressNumber(addressNumber);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
		
			System.out.println("Please enter your street address name.");
			do{
				try{
					addressName = scan.nextLine();
					contestant1.setAddressName(addressName);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter the city you are from.");
			do{
				try{
					city = scan.nextLine();
					contestant1.setCity(city);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter the province or territory you are from.");
			do{
				try{
					province = scan.nextLine();
					contestant1.setProvince(province);
					if (province.equals("NA")){
						flag1 =true;
					}
					else{
						flag1 =false;
					}
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter your postal code.");
			do{
				try{
					postalCode = scan.nextLine();
					contestant1.setPostalCode(postalCode);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter your phone number.");
			do{
				try{
					phoneNumber = scan.nextLine();
					contestant1.setPhoneNumber(phoneNumber);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
		
			System.out.println("Please enter the year you were born in using 4 numeric values.");
			
			do{
				try{
					dateChecker = scan.nextLine();
					contestant1.setyyyy(dateChecker);
					yyyy = Integer.parseInt(dateChecker);
					age = findAge(yyyy);
					flag1 =false;
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
			System.out.println("Please enter the month you were born in using only 2 numeric values.");

			do{
				try{
					dateChecker = scan.nextLine();
					contestant1.setmm(dateChecker);
					mm = Integer.parseInt(dateChecker);
					flag1 =false;
				} catch (InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);

			System.out.println("Please enter the day you were born in using only 2 numeric values.");

			do{
				try{
					dateChecker = scan.nextLine();
					contestant1.setdd(dateChecker);
					dd = Integer.parseInt(dateChecker);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);			
			
			contestant1.setBirthDate(yyyy, mm, dd);

			do{
			System.out.println("Would you like to add another contestant?");
			System.out.println("Please enter [1] for yes or [2] for no.");
			moreContestants = scan.nextLine();
			
				if (moreContestants.equals("1") || moreContestants.equals("[1]")){
					flag1 = false;
					flag2 = true;
				}
				else if (moreContestants.equals("2") || moreContestants.equals("[2]")){
					flag1 = false;
					flag2 = false;
				}
				else{
					System.out.println("Please enter a proper input of [1] for yes or [2] for no.");
					flag1 = true;
					flag2 = true;
				}
			}
			while(flag1);	
		contestants.add(contestant1);
		}
		while(flag2);
	}
	
	/**
	 * This method finds the age of a specified contestant.
	 * @param yyyy
	 * @return
	 */
	public static int findAge(int yyyy) {
		// TODO Auto-generated method stub;
		return yyyy - 2015;
	}
	
	/**
	 * This method prints out all the information of the inputed contestants.
	 * @param contestants
	 */
	public static void displayLabel(ArrayList<ContestantInformation> contestants){
		for(int i =0; i< contestants.size(); i++){
			Label output = new Label(contestants.get(i));
			System.out.println(contestants.get(i).toString());
			System.out.println(output.toString());
			System.out.println();
		}
	}
}
