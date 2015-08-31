mport java.io.BufferedReader;
import java.io.InputStreamReader;
public class NonDecreasingSeqNdigit {

	/**
	 * Author:Gaurav Shrivastava
	 */
	/*Basic of the problem is create a matrix 
	 *   0   1  2  3  4  5  6  7  8  9
	 * 1 1   1  1  1  1  1  1  1  1  1
	 * 2 10  9  8  7  6  5  4  3  2  1
	 * 3 55  45 36 28 21 15 10 6  3  1
	 * 4 220 -> as ans for n = 3 and submission of previous row
	 */  
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(in.readLine());
		while(test-->0){
			int n = Integer.parseInt(in.readLine());
			int arr[][] = new int [n+2][10];
			for (int i = 0; i < 10; i++) {
				arr[1][i] = 1;
			}
			for (int i = 2; i < n+2; i++) {
				for (int j = 0; j < 10; j++) {
					for (int j2 = j; j2 < 10; j2++) {
						arr[i][j] = arr[i][j] + arr[i-1][j2];
					}
				}
			}
			System.out.println(arr[n+1][0]);
		}
	}

}
