class MaxProduct {

	/**
	 * Author:Gaurav Shrivastava
	 */
	
	public static int maxProduct(int n){
		int max[] =new int[n + 1];
		max[0] = 0;
		max[1] = 1;
		max[2] = 2;
		max[3] = 3;
		max[4] = 4;
		max[5] = 6;
		for (int i = 6; i < max.length; i++) {
			max[i] =i;
			for (int j = 1; j < i; j++) {
				if(max[i] < max[j]*max[i-j])max[i] = max[j] * max[i-j];
			}
		}
		return max[n];
	}
	
	public static void main(String[] args) {
		System.out.println(maxProduct(10));
	}

}
