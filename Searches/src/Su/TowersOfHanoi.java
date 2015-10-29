/**
 * 
 */
package Su;

import java.util.Scanner;

/**
 * This is 
 * 
 * @author Glen Su
 * Oct 29 2015
 */
public class TowersOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the stack number.");
		solve(Integer.parseInt(scan.nextLine()),"A", "B", "C");
	}
	public static void solve(int N, String Src, String Dst, String Aux){
		if (N == 0){
			return;
		}
		else{
			solve(N - 1, Src, Dst, Aux);
			System.out.println("Move from " + Src + " to " + Dst);
			solve(N - 1, Aux, Src, Dst);
		}
		
	}
}
