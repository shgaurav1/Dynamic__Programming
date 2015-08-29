import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SegmentTrees {

	/**
	 * Gaurav Shrivastava
	 */
	 
	 // A utility function to print arrays
	public static void print(int a[]){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	// Program for range minimum query using segment tree

	 
	// A utility function to get minimum of two numbers
	public static int minVal(int x, int y) { return (x < y)? x: y; }
	 
	// A utility function to get the middle index from corner indexes.
	public static int getMid(int s, int e) {  return s + (e -s)/2;  }
	 
	/*  A recursive function to get the minimum value in a given range of array
	    indexes. The following are parameters for this function.
	 
	    st    --> Array of segment tree
	    index --> Index of current node in the segment tree. Initially 0 is
	             passed as root is always at index 0
	    ss & se  --> Starting and ending indexes of the segment represented by
	                 current node, i.e., st[index]
	    qs & qe  --> Starting and ending indexes of query range */
	public static int RMQUtil(int st[], int ss, int se, int qs, int qe, int index)
	{
	    // If segment of this node is a part of given range, then return the
	    // min of the segment
	    if (qs <= ss && qe >= se)
	        return st[index];
	 
	    // If segment of this node is outside the given range
	    if (se < qs || ss > qe)
	        return Integer.MAX_VALUE;
	 
	    // If a part of this segment overlaps with the given range
	    int mid = getMid(ss, se);
	    return minVal(RMQUtil(st, ss, mid, qs, qe, 2*index+1),
	                  RMQUtil(st, mid+1, se, qs, qe, 2*index+2));
	}
	 
	// Return minimum of elements in range from index qs (quey start) to
	// qe (query end).  It mainly uses RMQUtil()
	public static int RMQ(int st[], int n, int qs, int qe)
	{
	    // Check for erroneous input values
	    if (qs < 0 || qe > n-1 || qs > qe)
	    {
	        System.out.print("Invalid Input");
	        return -1;
	    }
	 
	    return RMQUtil(st, 0, n-1, qs, qe, 0);
	}
	 
	// A recursive function that constructs Segment Tree for array[ss..se].
	// si is index of current node in segment tree st
	public static int constructSTUtil(int arr[], int ss, int se, int st[], int si)
	{
	    // If there is one element in array, store it in current node of
	    // segment tree and return
	    if (ss == se)
	    {
	        st[si] = arr[ss];
	        return arr[ss];
	    }
	 
	    // If there are more than one elements, then recur for left and
	    // right subtrees and store the minimum of two values in this node
	    int mid = getMid(ss, se);
	    st[si] =  minVal(constructSTUtil(arr, ss, mid, st, si*2+1),constructSTUtil(arr, mid+1, se, st, si*2+2));
	    return st[si];
	}
	 
	/* Function to construct segment tree from given array. This function
	   allocates memory for segment tree and calls constructSTUtil() to
	   fill the allocated memory */
	public static int[] constructST(int arr[], int n)
	{
	    // Allocate memory for segment tree
	    //int x = (int)(Math.ceil(Math.log(n))); //Height of segment tree
	    //int max_size = 2*(int)Math.pow(2, x) - 1; //Maximum size of segment tree
	    int st[] = new int[n+n-1];
	 
	    // Fill the allocated memory st
	    constructSTUtil(arr, 0, n-1, st, 0);
	 
	    // Return the constructed segment tree
	    return st;
	}
	 
	// Driver program to test above functions
	public static void main(String[] args)throws Exception {
		int a[] = {4,15,20,27,29,18,30,55,60};
		int n = a.length;
		int tree[] =constructST(a, n);
		print(tree);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int query = Integer.parseInt(in.readLine());
		while(query-- >0){
			int l = Integer.parseInt(in.readLine());
			int r = Integer.parseInt(in.readLine());
			System.out.println("Minimum of values in range["+l+','+ r + "] is = "+RMQ(tree, n, l, r));
		}

	}

}
