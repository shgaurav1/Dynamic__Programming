class LongestIncreasingSubSequence {

	/**
	 * Author:Gaurav Shrivastava
	 */
	
	//Function for finding Longest Increasing SubSequence in O(n^2)
	public static int LIS(int arr[]){
		int L[] = new int [arr.length];
		L[0] = 1;
		
		for (int i = 0; i < L.length; i++) {
			for (int j = 0; j < i; j++) {
				//Basically compare all the combination before
				// L[i] = Max( 1 + L[j]) where L[i] give me LIS till L[i] position
				
				if(arr[i] > arr[j]){
					if(L[i] < 1 + L[j])
					{
						L[i] = 1 + L[j];
					}
				}
				else{
					L[i] = 1;
				}
			}
		}
		return L[arr.length - 1];
	}
	
	//Drive Program
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60,80 };
	    System.out.println("Length of LIS is "+  LIS( arr));
	}

}
