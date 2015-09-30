/**
 * 
 */
package su;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Glen Su
 * Sept 28 2015
 */
public class Label {

	private ContestantInformation ci;
	
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
	
	private String output;
	
	public Label (ContestantInformation ci1){
		
		this.ci = ci1;
		formatName();
		formatAddress();
		formatNumber();
		
	}
	/**
	 * This method is used to format the name of the contestant
	 */
	private void formatName() {
		// TODO Auto-generated method stub
		firstName = ci.getFirstName();
		lastName = ci.getLastName();
		output = lastName + ", " + firstName + "/n";
	}
	/**
	 * This method is used to format the address information of the contestant
	 */
	private void formatAddress() {
		// TODO Auto-generated method stub
		addressNumber = ci.getAddressNumber();
		addressName = ci.getAddressName();
		city = ci.getCity();
		province = ci.getProvince();
		
		output = output + addressNumber + " " + addressName + " " + "/n" + city + province + "/n" + postalCode + "/n";
	}
	/**
	 * This method is used to format the phone number of the contestant
	 */
	private void formatNumber() {
		// TODO Auto-generated method stub
		phoneNumber = ci.getPhoneNumber();

		output = output + phoneNumber;
	}
	public String outputString() {
		
		return output;
		
	}
	
}
