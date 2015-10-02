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
	private static String firstName;
	private static String lastName;
	private static String addressNumber;
	private static String addressName;
	private static String city;
	private static String province;
	private static String postalCode;
	private static String phoneNumber;
	private static String birthDate;
	private static String moreContestants;
	private static String output;
	private static String dateChecker;
	private static int yyyy;
	private static int mm;
	private static int dd;

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();
		ContestantInformation contestant1 = new ContestantInformation();
		
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
					contestant1.setyyyy(dateChecker);
					yyyy = Integer.parseInt(dateChecker);
					age = findAge();
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
			System.out.println("Is that all the contestants?");
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
		
		Label output = new Label(contestant1);
		System.out.println(contestant1.toString());
		System.out.println(output.toString());
		}

	public static int findAge() {
		// TODO Auto-generated method stub;
		return yyyy - 2015;
	}

}
