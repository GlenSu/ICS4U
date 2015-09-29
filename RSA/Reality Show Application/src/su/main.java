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
		ContestantInformation contestant1 = null;
		
		int age = 0;
		int counter = 0;
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
					contestant1.setAddressName(addressNumber);
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
					contestant1.setAddressNumber(addressName);
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
					flag1 =false;
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
					System.out.println("Please enter your postal code again.");
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
		
			System.out.println("Please enter the year you were born in.");
			do{
				try{
					contestant1.setyyyy();
					yyyy = Integer.parseInt(scan.nextLine());
					flag1 =false;
				}catch(InvalidInputException e){
					System.out.println(e.getMessage());
					flag1 =true;
				}
			}
			while(flag1);
			
		age = findAge();
		contestants.add(contestant1);
		}
		while(flag2);
		
		
		}

	public static int findAge() {
		// TODO Auto-generated method stub;
		return yyyy - 2015;
	}

}
