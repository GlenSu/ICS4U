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
 * Nov 4 2015
 */
public class main {
	

	
	
	/**
	 * This is the main method of the program
	 * @param args
	 * @throws InvalidInputException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InvalidInputException, IOException{
		// TODO Auto-generated method stub
		BufferedReader fbr = new BufferedReader(new FileReader("contestants.txt"));
		FileOutputStream fileOutputStream = new FileOutputStream("contestants.txt");
		PrintStream fps = new PrintStream(fileOutputStream);
		
		boolean flag1 = true;
		int compareToValue = 0;
		int removeElement = 0;
		int loadLimit = 0;
		String userAnswer = "";
		String firstName = "";
		String lastName = "";
		String loadInfo = "";
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
		System.out.println("8. Exit the program.");

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
				System.out.println("Enter an input just like from the start.");
			}
			else if(userAnswer.equalsIgnoreCase("2") || userAnswer.equalsIgnoreCase("2.") || userAnswer.equalsIgnoreCase("2,")){
				System.out.println("Initiating option.");
				System.out.println();
				if(contestants.size()< 0){
					displayLabel(contestants);
					flag1 = true;
					System.out.println("Task completed.");
				}
				else{
					System.out.println("The information list is currectly empty.");
				}
				System.out.println("Is there something else you would like to do?");
				System.out.println("Enter an input just like from the start.");
			}
			else if(userAnswer.equalsIgnoreCase("3") || userAnswer.equalsIgnoreCase("3.") || userAnswer.equalsIgnoreCase("3,")){
				System.out.println("Initiating option.");
				System.out.println();
				do{
					try{
						System.out.println("Enter a first name to search for.");
						firstName = scan.nextLine();
						Format.searchFormat(firstName);
						System.out.println(firstName);
						flag1 =false;
					}catch(InvalidInputException e){
						System.out.println(e.getMessage());
						flag1 =true;
					}
				}while(flag1);
				do{
					try{
						System.out.println("Enter a last name to search for.");
						lastName = scan.nextLine();
						Format.searchFormat(lastName);
						System.out.println(lastName);
						flag1 =false;
					}catch(InvalidInputException e){
						System.out.println(e.getMessage());
						flag1 =true;
					}
				}while(flag1);
				compareToValue = Searches.linearSearches(contestants,firstName,lastName);
				flag1 = true;
				
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
				
				System.out.println("Is there something else you would like to do?");
				System.out.println("Enter an input just like from the start.");
			}
			else if(userAnswer.equalsIgnoreCase("4") || userAnswer.equalsIgnoreCase("4.") || userAnswer.equalsIgnoreCase("4,")){
				System.out.println("Initiating option.");
				System.out.println();
				System.out.println("Would you like to enter an index or search for a person to delete?");
				System.out.println("Enter a [1] for inputting an index or enter a [2] for searching for a contestant.");
				do{
				userAnswer = scan.nextLine();
				
					if(userAnswer.equalsIgnoreCase("1") || userAnswer.equalsIgnoreCase("1.") || userAnswer.equalsIgnoreCase("1,")){
						System.out.println("Please enter an index to delete the specified contestant.");
						do{
							do{
								try{
									userAnswer = scan.nextLine();
									for (int i = 0; i< userAnswer.length(); i++){
										if (!Character.isDigit(userAnswer.charAt(i))){
											throw new InvalidInputException("Please enter only digits.");
										}
									}
									removeElement = Integer.parseInt(userAnswer);
									flag1 = true;
								}catch(InvalidInputException e){
									System.out.println(e.getMessage());
									flag1 = false;
								}
							}while(flag1);

							if(removeElement > 0){
								contestants.remove(userAnswer);
								flag1 = false;
							}
							else if(removeElement == -1){
								System.out.println("A contestant information was not deleted.");
								flag1 = false;
							}
							else{
								System.out.println("Please enter only digits.");
								flag1 = true;
							}

						}while(flag1);
					}
					else if(userAnswer.equalsIgnoreCase("2") || userAnswer.equalsIgnoreCase("2.") || userAnswer.equalsIgnoreCase("2,")){
						do{
							try{
								System.out.println("Enter a first name to search for.");
								firstName = scan.nextLine();
								Format.searchFormat(firstName);
								System.out.println(firstName);
								flag1 =false;
							}catch(InvalidInputException e){
								System.out.println(e.getMessage());
								flag1 =true;
							}
						}while(flag1);

						do{
							try{
								System.out.println("Enter a last name to search for.");
								lastName = scan.nextLine();
								Format.searchFormat(lastName);
								System.out.println(lastName);
								flag1 =false;
							}catch(InvalidInputException e){
								System.out.println(e.getMessage());
								flag1 =true;
							}
						}while(flag1);

						compareToValue = Searches.linearSearches(contestants,firstName,lastName);
						flag1 = false;
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
						flag1 = true;
					}
				}while(flag1);
				
				System.out.println("Is there something else you would like to do?");
				System.out.println("Enter an input just like from the start.");
				flag1 = true;
			}
			//Delete all Information
			else if(userAnswer.equalsIgnoreCase("5") || userAnswer.equalsIgnoreCase("5.") || userAnswer.equalsIgnoreCase("5,")){
				System.out.println("Initiating option.");
				System.out.println();
				System.out.println("Are you sure that you want to delete all the contestant information?");
				System.out.println("Enter a [Y] for yes or an [N] for no.");
				do{
					userAnswer = scan.nextLine();
					if(userAnswer.equalsIgnoreCase("Y")){
						System.out.println("Task completed.");
						flag1 = false;
						contestants.removeAll(contestants);
					}
					else if(userAnswer.equalsIgnoreCase("N")){
						System.out.println("You have cancelled the deletion process.");
						flag1 = false;
					}
					else{
						System.out.println("Please enter a proper input. [Y or N]");
						flag1 = true;
					}
				}while(flag1);
				
				System.out.println("Is there something else you would like to do?");
				System.out.println("Enter an input just like from the start.");
				flag1 = true;
			}
			//Save Information
			else if(userAnswer.equalsIgnoreCase("6") || userAnswer.equalsIgnoreCase("6.") || userAnswer.equalsIgnoreCase("6,")){
				System.out.println("Saving contestants...");
				System.out.println();
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
						}
						fileOutputStream.close();
						System.out.println("Task completed.");
						flag1 = false;
					}
					else if(userAnswer.equalsIgnoreCase("N")){
						System.out.println("You have cancelled the deletion process.");
						flag1 = false;
					}
					else{
						System.out.println("Please enter a proper input. [Y] or [N]");
						flag1 = true;
					}
				}while(flag1);
				
				System.out.println("Is there something else you would like to do?");
				System.out.println("Enter an input just like from the start.");
			}
			//Load Information
			else if(userAnswer.equalsIgnoreCase("7") || userAnswer.equalsIgnoreCase("7.") || userAnswer.equalsIgnoreCase("7,")){
				System.out.println("Initiating option.");
				System.out.println();
				System.out.println("Are you sure that you want to overwrite the current contestant information?");
				System.out.println("Enter a [Y] for yes or an [N] for no.");
				do{
					userAnswer = scan.nextLine();
					if(userAnswer.equalsIgnoreCase("Y")){
						loadInfo = fbr.readLine();
						loadLimit = Integer.parseInt(loadInfo);
						for(int i = 0; i<loadLimit;i++){
							
						}
						System.out.println("Task completed.");
						flag1 = false;
					}
					else if(userAnswer.equalsIgnoreCase("N")){
						System.out.println("You have cancelled the deletion process.");
						flag1 = false;
					}
					else{
						System.out.println("Please enter a proper input. [Y] or [N]");
						flag1 = true;
					}
				}while(flag1);
			}
			else if(userAnswer.equalsIgnoreCase("8") || userAnswer.equalsIgnoreCase("8.") || userAnswer.equalsIgnoreCase("8,")){
				System.out.println("Thank you for choosing this program for organising contestant data.");
				System.exit(0);
				flag1 = false;
			}
			else{
				System.out.println("Please input a proper value. [1], [2], [3], [4], [5], [6], [7] or [8]");
				flag1 = true;
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
