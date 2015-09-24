/**
 * 
 */
package su;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author 322124942
 *
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
	 * 
	 */
	private void formatName() {
		// TODO Auto-generated method stub
		
		lastName = ci.getLastName();
	}
	/**
	 * 
	 */
	private void formatAddress() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 */
	private void formatNumber() {
		// TODO Auto-generated method stub
		
	}
	
}
