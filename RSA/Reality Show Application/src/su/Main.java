/**
 * 
 */
package su;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
/**
 * This class is used as the main functions of the program. 
 * 
 * @author Glen Su
 * Nov 11 2015
 */
public class Main {
	
	/**
	 * This is the main method of the program that holds the main menu and calls ofther methods
	 * to perform specific tasks that are involve to create and manage contestants
	 * @param args - arguments from the predefined source
	 * @throws InvalidInputException - If an input is not valid
	 */
	public static void main(String[] args) throws InvalidInputException{
		// TODO Auto-generated method stub
		boolean flag = true;
		
		String userAnswer = "";

		Scanner scan = new Scanner(System.in);
		ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();

		System.out.println("Welcome to the contestant application form.");
		System.out.println("Please enter the number corresponding to the option to choose that option.");
		System.out.println("1. Add a new contestant.");
		System.out.println("2. Print out all the contestant information.");
		System.out.println("3. Search for a contestant.");
		System.out.println("4. Delete a contestant.");
		System.out.println("5. Clear all data.");
		System.out.println("6. Save to a file.");
		System.out.println("7. Load from a save file.");
		System.out.println("8. Sort the list.");
		System.out.println("9. Exit the program.");
		System.out.println("-1. See available options.");
		
		do{
			userAnswer = scan.nextLine();
			for(int i = 0; i< userAnswer.length(); i++){
				if(!Character.isDigit(userAnswer.charAt(i)) && userAnswer.substring(i) == "." || userAnswer.substring(i) == ","){
					System.out.println("");
					i = userAnswer.length(); 
				}					
			}
			//Create and add a contestant to the array list
			if(userAnswer.equalsIgnoreCase("1") || userAnswer.equalsIgnoreCase("1.") || userAnswer.equalsIgnoreCase("1,")){
				System.out.println("Initiating option. \n");
				addContestant(contestants);
				flag = true;
				System.out.println("Task completed.");

			}
			//Print array list information
			else if(userAnswer.equalsIgnoreCase("2") || userAnswer.equalsIgnoreCase("2.") || userAnswer.equalsIgnoreCase("2,")){
				System.out.println("Initiating option. \n");
				if(contestants.size()> 0){
					displayLabel(contestants);
					flag = true;
					System.out.println("Task completed.");
				}
				else{
					System.out.println("The information list is currectly empty.");
				}

			}
			//Find a contestant
			else if(userAnswer.equalsIgnoreCase("3") || userAnswer.equalsIgnoreCase("3.") || userAnswer.equalsIgnoreCase("3,")){
				System.out.println("Initiating option. \n");
				searchContestant(contestants);
				flag = true;
			}
			//Delete a contestant from the array list
			else if(userAnswer.equalsIgnoreCase("4") || userAnswer.equalsIgnoreCase("4.") || userAnswer.equalsIgnoreCase("4,")){
				System.out.println("Initiating option.");
				deleteContestant(contestants);

				flag = true;
			}
			//Delete all contestant information from the array list
			else if(userAnswer.equalsIgnoreCase("5") || userAnswer.equalsIgnoreCase("5.") || userAnswer.equalsIgnoreCase("5,")){
				System.out.println("Initiating option. \n");
				deleteAll(contestants);
				flag = true;
			}
			//Save Information
			else if(userAnswer.equalsIgnoreCase("6") || userAnswer.equalsIgnoreCase("6.") || userAnswer.equalsIgnoreCase("6,")){
				System.out.println("Initiating option. \n");
				saveInformation(contestants);
				flag = true;
			}
			//Load Information
			else if(userAnswer.equalsIgnoreCase("7") || userAnswer.equalsIgnoreCase("7.") || userAnswer.equalsIgnoreCase("7,")){
				System.out.println("Initiating option. \n");
				loadInformation(contestants);
				flag = true;
			}
			//Exits the program
			else if(userAnswer.equalsIgnoreCase("8") || userAnswer.equalsIgnoreCase("8.") || userAnswer.equalsIgnoreCase("8,")){
				System.out.println("Initiating option. \n");
				System.out.println("Are you sure that you want to overwrite the overall contestant information?");
				System.out.println("Enter a [Y] for yes or an [N] for no.");
				do{
					userAnswer = scan.nextLine();
					if(userAnswer.equalsIgnoreCase("Y")){
						Collections.sort(contestants);
						System.out.println("Task completed.");
						flag = false;
					}
					else if(userAnswer.equalsIgnoreCase("N")){
						System.out.println("You have cancelled the overriding process.");
						flag = false;
					}
					else{
						System.out.println("Please enter a proper input. [Y] or [N]");
						flag = true;
					}
				}while(flag);
			}
			else if(userAnswer.equalsIgnoreCase("9") || userAnswer.equalsIgnoreCase("9.") || userAnswer.equalsIgnoreCase("9,")){
				System.out.println("Thank you for choosing this program for organising contestant data.");
				System.exit(0);
				flag = false;
			}
			//Help list
			else if(userAnswer.equalsIgnoreCase("-1") || userAnswer.equalsIgnoreCase("-1.") || userAnswer.equalsIgnoreCase("[-1]")){
				System.out.println("1. Add a new contestant.");
				System.out.println("2. Print out all the contestant information.");
				System.out.println("3. Search for a contestant.");
				System.out.println("4. Delete a contestant.");
				System.out.println("5. Clear all data.");
				System.out.println("6. Save to a file.");
				System.out.println("7. Load from a save file.");
				System.out.println("8. Sort the list.");
				System.out.println("9. Exit the program.");
				flag = true;
			}
			else{
				System.out.println("Please input a proper value. [1], [2], [3], [4], [5], [6], [7], [8], or [9]");
				System.out.println("If you have forgotten what the options were, input [-1] to veiw them.");
				flag = true;
			}
			if(userAnswer.equalsIgnoreCase("1") || userAnswer.equalsIgnoreCase("2") || userAnswer.equalsIgnoreCase("3") || userAnswer.equalsIgnoreCase("4") || userAnswer.equalsIgnoreCase("5") || userAnswer.equalsIgnoreCase("6") || userAnswer.equalsIgnoreCase("7") || userAnswer.equalsIgnoreCase("8") || userAnswer.equalsIgnoreCase("9")){
				System.out.println("Is there something else you would like to do?");
				System.out.println("Enter an input just like from the start.");
				flag = true;
			}

		}while(flag);
	}

	/**
	 * Adds a new contestant into and arraylist
	 * @param contestants - the arraylist containing all contestant information
	 */
	public static void addContestant(ArrayList<ContestantInformation> contestants){
		Scanner scan = new Scanner(System.in);
		ContestantInformation contestant1 = new ContestantInformation();
		
		String userAnswer;		
		Random rng = new Random();
		int selection = 0;
		int skillQuestionAnswer = 0;
		int skillQuestionNumber1 = (rng.nextInt(10)+1);
		int skillQuestionNumber2 = (rng.nextInt(10)+1);
		int skillQuestionNumber3 = (rng.nextInt(10)+1);
		String firstName;
		String lastName;
		String addressNumber;
		String addressName;
		String city;
		String province;
		String postalCode;
		String phoneNumber;
		String moreContestants;
		String dateChecker;
		int birthYear=0;
		int birthMonth=0;
		int birthDay=0;
		int age = 0;
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
					contestant1.setBirthYear(dateChecker);
					birthYear = Integer.parseInt(dateChecker);
					age = findAge(birthYear);
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
					contestant1.setBirthMonth(dateChecker);
					birthMonth = Integer.parseInt(dateChecker);
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
					contestant1.setBirthDay(dateChecker);
					birthDay = Integer.parseInt(dateChecker);
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);			
			
			contestant1.setBirthDate(birthYear, birthMonth, birthDay);
			age = findAge(birthYear);
			if(age<18){
				System.out.println("You are too young to be a contestant.");
				System.out.println("Would you like to add another contestant instead?");
			}
			else if(age>=18){
				System.out.println("To be added into the list, you must answer correctly a skill testing question.");
				selection = rng.nextInt(3)+1;
				if(selection == 1)
				{
					System.out.println("What is: " + skillQuestionNumber1 + " + " + skillQuestionNumber2 + " + " + skillQuestionNumber3);
					skillQuestionAnswer = skillQuestionNumber1 + skillQuestionNumber2 + skillQuestionNumber3;
				}
				else if(selection == 2)
				{
					System.out.println("What is: " + skillQuestionNumber1 + " - " + skillQuestionNumber2 + " - " + skillQuestionNumber3);
					skillQuestionAnswer = skillQuestionNumber1 - skillQuestionNumber2 - skillQuestionNumber3;
				}
				else if(selection == 3)
				{
					System.out.println("What is: " + skillQuestionNumber1 + " * " + skillQuestionNumber2 + " * " + skillQuestionNumber3);
					skillQuestionAnswer = skillQuestionNumber1 * skillQuestionNumber2 * skillQuestionNumber3;
				}
				userAnswer = scan.nextLine();
				do{
					flag1 = false;
					for(int i = 0; i<userAnswer.length(); i++){
						if(!Character.isDigit(userAnswer.charAt(i)) && !(userAnswer.charAt(i) == '-')){
							System.out.println("Please answer with a number.");
							flag1 = true;
							userAnswer = scan.nextLine();
						}
					}
				}while(flag1);

				if(Integer.parseInt(userAnswer) == skillQuestionAnswer){
					System.out.println("Correct! Your information is now added to the list.");
					System.out.println("Would you like to add another contestant?");
					contestants.add(contestant1);
				}
				else{
					System.out.println("You have failed to answer the question properly.");
					System.out.println("Your information will not be added as a new contestant.");
					System.out.println("Would you like to add another contestant?");
				}
			}
			else{
				System.out.println("An error has occured when trying to initiate the skill testing question.");
				System.out.println("Would you like to try to add another contestant instead?");
			}
			do{
			
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
		
		}
		while(flag2);
		
	}
	
	/**
	 * This method finds the age of a specified contestant.
	 * @param birthYear - the year when the contestant was born in
	 * @return - the age of the contestant
	 */
	public static int findAge(int birthYear) {
		// TODO Auto-generated method stub;
		return 2015 - birthYear;
	}
	
	/**
	 * This method prints out all the information of the inputed contestants.
	 * @param contestants - the arraylist containing all contestant information
	 */
	public static void displayLabel(ArrayList<ContestantInformation> contestants){
		for(int i =0; i< contestants.size(); i++){
			Label output = new Label(contestants.get(i));
			System.out.println(output.toString() + "\n");
		}
	}
	/**
	 * Searches for a specified contestant by the use of their first and last names.
	 * @param contestants - the arraylist containing all contestant information
	 */
	public static void searchContestant(ArrayList<ContestantInformation> contestants){
		boolean flag = false;
		int compareToValue = 0;
		
		String firstName = "";
		String lastName = "";
		Scanner scan = new Scanner(System.in);
		do{
			try{
				System.out.println("Enter a first name to search for.");
				firstName = scan.nextLine();
				firstName = Format.searchFormat(firstName);
				System.out.println(firstName);
				flag =false;
			}catch(InvalidInputException e){
				System.out.println(e.getMessage());
				flag =true;
			}
		}while(flag);
		do{
			try{
				System.out.println("Enter a last name to search for.");
				lastName = scan.nextLine();
				lastName = Format.searchFormat(lastName);
				System.out.println(lastName);
				flag =false;
			}catch(InvalidInputException e){
				System.out.println(e.getMessage());
				flag =true;
			}
		}while(flag);
		compareToValue = Searches.linearSearches(contestants,firstName,lastName);
		flag = true;
		
		System.out.println("Task completed.");
		
		if(compareToValue > -1){
			System.out.println("The contestant inforamtion has been found to be in the index of :" + compareToValue + " of the array list.");
		}
		else if(compareToValue == -1){
			System.out.println("This contestant does not exist in the data bank.");
		}
		else{
			System.out.println("An error has occured");
		}
	}
	/**
	 * Deletes a contestant from the arraylist by either inputting the index of where the 
	 * contestant is located inside the arraylist or by search of their first and last names.
	 * @param contestants - the arraylist containing all contestant information
	 */
	public static void deleteContestant(ArrayList<ContestantInformation> contestants){
		boolean flag = false;
		int compareToValue = 0;
		int removeElement = 0;
		String firstName = "";
		String lastName = "";
		String userAnswer = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to enter an index or search for a person to delete?");
		System.out.println("Enter a [1] for inputting an index or enter a [2] for searching for a contestant.");
		do{
		userAnswer = scan.nextLine();
		
			if(userAnswer.equalsIgnoreCase("1") || userAnswer.equalsIgnoreCase("1.") || userAnswer.equalsIgnoreCase("1,")){
				System.out.println("Please enter an index to delete the specified contestant.");
				System.out.println("Enter a [-1] to cancel the process.");
				do{
					do{
						try{
							userAnswer = scan.nextLine();
							removeElement = Integer.parseInt(userAnswer);
							flag = false;
						}catch(NumberFormatException e){
							System.out.println("This is not a number. Try again.");
							flag = true;
						}
					}while(flag);

					if(removeElement >= 0 && removeElement < contestants.size()){
						contestants.remove(userAnswer);
						System.out.println("A contestant information was deleted.");
						flag = false;
					}
					else if(removeElement == -1){
						System.out.println("The deletion process was cancelled.");
						flag = false;
					}
					else{
						System.out.println("Please enter a valid index.");
						flag = true;
					}

				}while(flag);
			}
			else if(userAnswer.equalsIgnoreCase("2") || userAnswer.equalsIgnoreCase("2.") || userAnswer.equalsIgnoreCase("2,")){
				do{
					try{
						System.out.println("Enter a first name to search for.");
						firstName = scan.nextLine();
						firstName = Format.searchFormat(firstName);
						System.out.println(firstName);
						flag =false;
					}catch(InvalidInputException e){
						System.out.println(e.getMessage());
						flag =true;
					}
				}while(flag);

				do{
					try{
						System.out.println("Enter a last name to search for.");
						lastName = scan.nextLine();
						lastName = Format.searchFormat(lastName);
						System.out.println(lastName);
						flag =false;
					}catch(InvalidInputException e){
						System.out.println(e.getMessage());
						flag =true;
					}
				}while(flag);

				compareToValue = Searches.linearSearches(contestants,firstName,lastName);
				flag = false;
				if (compareToValue > 0){
					System.out.println("Task completed.");
					contestants.remove(compareToValue);
				}
				else{
					System.out.println("The specified contestant was not found.");
				}
			}
			else{
				System.out.println("Please enter a valid input. [1 or 2]");
				flag = true;
			}
		}while(flag);
		
	}
	/**
	 * Deletes all information from every contestant that is inside the arraylist
	 * @param contestants - the arraylist containing all contestant information
	 */
	public static void deleteAll(ArrayList<ContestantInformation> contestants){
		boolean flag = false;
		String userAnswer = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Are you sure that you want to delete all the contestant information?");
		System.out.println("Enter a [Y] for yes or an [N] for no.");
		do{
			userAnswer = scan.nextLine();
			if(userAnswer.equalsIgnoreCase("Y")){
				System.out.println("Task completed.");
				flag = false;
				contestants.removeAll(contestants);
			}
			else if(userAnswer.equalsIgnoreCase("N")){
				System.out.println("You have cancelled the deletion process.");
				flag = false;
			}
			else{
				System.out.println("Please enter a proper input. [Y or N]");
				flag = true;
			}
		}while(flag);
	}
	/**
	 * Used to save contestant information from a ContestantInformation arraylist into a text document.
	 * @param contestants - the arraylist containing all contestant information
	 * @throws IOException - If the specified file does not exist
	 */
	public static void saveInformation(ArrayList<ContestantInformation> contestants){

		boolean flag = false;
		String userAnswer = "";
		Scanner scan = new Scanner(System.in);

		try {
			if(contestants.size()>0){
				Collections.sort(contestants);
				FileOutputStream fileOutputStream = new FileOutputStream("contestants.txt");
				PrintStream fps = new PrintStream(fileOutputStream);
				System.out.println("Are you sure that you want to overwrite the overall contestant information?");
				System.out.println("Enter a [Y] for yes or an [N] for no.");
				do{
					userAnswer = scan.nextLine();
					if(userAnswer.equalsIgnoreCase("Y")){
						fps.println(contestants.size());
						for(int i = 0; i<contestants.size();i++){
							fps.println(contestants.get(i).getFirstName());
							fps.println(contestants.get(i).getLastName());
							fps.println(contestants.get(i).getAddressNumber());
							fps.println(contestants.get(i).getAddressName());
							fps.println(contestants.get(i).getCity());
							fps.println(contestants.get(i).getProvince());
							fps.println(contestants.get(i).getPostalCode());
							fps.println(contestants.get(i).getPhoneNumber());
							fps.println(contestants.get(i).getBirthYear());
							fps.println(contestants.get(i).getBirthMonth());
							fps.println(contestants.get(i).getBirthDay());
						}
						try {
							fileOutputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						System.out.println("Task completed.");
						flag = false;
					}
					else if(userAnswer.equalsIgnoreCase("N")){
						System.out.println("You have cancelled the deletion process.");
						flag = false;
					}
					else{
						System.out.println("Please enter a proper input. [Y] or [N]");
						flag = true;
					}
				}while(flag);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There was an error when trying to save the information.");
		}
		
	}
	/**
	 * Used to load contestant information from a text document into a ContestantInformation arraylist.
	 * @param contestants - the arraylist containing all contestant information
	 * @throws IOException - If the text document does not exist
	 * @throws InvalidInputException - if the input is invalid
	 */
	public static void loadInformation(ArrayList<ContestantInformation> contestants) throws InvalidInputException{
		Scanner scan = new Scanner(System.in);
		
		boolean flag = false;		
		String firstName = "";
		String lastName = "";
		String addressNumber = "";
		String addressName = "";
		String city = "";
		String province = "";
		String postalCode = "";
		String phoneNumber = "";
		String birthDate = "";
		String output = "";
		String dateChecker = "";
		String birthYear = "";
		String birthMonth = "";
		String birthDay = "";

		String userAnswer = "";
		String loadInfo = "";
		int loadLimit = 0;
		
		try {
			BufferedReader fbr = new BufferedReader(new FileReader("contestants.txt"));
			System.out.println("Are you sure that you want to overwrite the current contestant information?");
			System.out.println("Enter a [Y] for yes or an [N] for no.");
			do{
				userAnswer = scan.nextLine();
				if(userAnswer.equalsIgnoreCase("Y")){
					
					loadLimit = Integer.parseInt(fbr.readLine());
					for(int i = 0; i < loadLimit;i++){
						firstName = fbr.readLine().trim();
						lastName = fbr.readLine().trim();
						addressNumber = fbr.readLine();
						addressName = fbr.readLine().trim();
						city =fbr.readLine().trim();
						province = fbr.readLine().trim();
						postalCode =fbr.readLine().trim();
						phoneNumber = fbr.readLine();
						birthYear = fbr.readLine();
						birthMonth = fbr.readLine();
						birthDay = fbr.readLine();
						ContestantInformation contestant = new ContestantInformation(firstName, lastName, addressNumber, addressName, city, province, postalCode, phoneNumber, birthYear, birthMonth, birthDay);
						contestants.add(contestant);
						
					}
					System.out.println("Task completed.");
					flag = false;
				}
				else if(userAnswer.equalsIgnoreCase("N")){
					System.out.println("You have cancelled the overriding process.");
					flag = false;
				}
				else{
					System.out.println("Please enter a proper input. [Y] or [N]");
					flag = true;
				}
			}while(flag);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There was an error when opening the file.");
			System.out.println("The specified file may have been moved or does not exist.");
		} catch (IOException e){
			System.out.println("There was an error when trying to read the information.");
			System.out.println("The file might be empty or corrupted.");
		}
	}		
}
