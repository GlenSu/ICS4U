/**
 * 
 */
package Su;

/**
 * 
 * 
 * @author Glen Su
 *
 */
public class TowersOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(3,"A", "B", "C");
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
