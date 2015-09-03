class CuttingRod {

	/**
	 * Author:Gaurav Shrivastava
	 */
	
	public static int CutRod(int arr[]){
		int ans[] = new int [arr.length + 1];
		ans[0] = 0;
		ans[1] = arr[0];
		for (int i = 2; i < ans.length; i++) {
			ans[i] = arr[i-1];
			for (int j = 0; j <= i; j++) {
				if(ans[i] < ans[j] + ans[i-j])ans[i] = ans[j] + ans[i-j];
			}
		}
		
		return ans[arr.length];
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
	    System.out.println("Maximum Obtainable Value is " +  CutRod(arr));

	}

}
