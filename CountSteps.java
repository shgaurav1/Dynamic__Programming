class CountWays {

	/**
	 * Author: Gaurav Shrivastava
	 */
	 //Counting the number of ways to reach Nth step starting from bottom
	private static int Count(int n){
		int a[]  = new int [n+1];
		a[0] = 1;
		a[1] = 1;
		for (int i = 2; i < a.length; i++) {
			//a[i-1] -> ways to reach from N-1th step to Nth step
			//a[i-2] -> ways to reach from N-2th step to Nth step
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}
	
	public static void main(String[] args) {
		int s = 8;
		  System.out.println("Number of ways = " + Count(s));

	}

}
