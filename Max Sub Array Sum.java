class MaxSubarraySum {

	/**
	 * Author:Gaurav Shrivastava
	 */
	
	//Will Return 0 if array contains all negative numbers
	//Gives answer in O(n)
	public static int maxSubArraySum(int a[], int size)
	{
	   int max_so_far = a[0], i;
	   int curr_max = a[0];
	 
	   for (i = 1; i < size; i++)
	   {
	        curr_max = Math.max(a[i], curr_max+a[i]);
	        max_so_far = Math.max(max_so_far, curr_max);
	   }
	   return max_so_far;
	}	
	
//	Driver Program to run test cases
	public static void main(String[] args) {
		 int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		   int max_sum = maxSubArraySum(a, a.length);
		   System.out.println("Maximum contiguous sum is " + max_sum);

	}

}
