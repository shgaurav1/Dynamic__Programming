public class LongestCommonSubSeq {

	/**
	 * Author: Gaurav Shrivastava
	 */
	
	public static int LCS(char[] str1, char[] str2){
		int ans[][] = new int [str1.length + 1][str2.length + 1];
		
		for (int i = 0; i < str1.length + 1; i++) {
			
			for (int j = 0; j < str2.length + 1; j++) {
		
				
				if(i == 0|| j== 0){
					ans[i][j] = 0;
				}

				//m and n are len of str1 and str2 respectively
				//If last characters of both sequences match (or str1[m-1] == str2[n-1]) then
				//L(str1[0..m-1], str2[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

				else if (str1[i-1] == str2[j-1]){
					ans[i][j] = ans[i-1][j-1] + 1;
				}
				//If last characters of both sequences do not match (or str1[m-1] != str2[n-1]) then
				//L(str1[0..m-1], str2[0..n-1]) = MAX ( L(str1[0..m-2], str2[0..n-1]), L(str1[0..m-1], str2[0..n-2])
				
				else{
					ans[i][j] = Math.max(ans[i-1][j], ans[i][j-1]);
				}
			}
		}
		/*printing purpose
		 * for (int i = 0; i < str1.length+1; i++) {
			for (int j = 0; j < str2.length+1; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}*/
		return ans[str1.length][str2.length];
	}
	
	//Driver code
	public static void main(String[] args) {
		  String str1 = "AGGATAB";
		  String str2 = "GXTXAYB";
		  System.out.print(LCS(str1.toCharArray(), str2.toCharArray()));
	}

}
