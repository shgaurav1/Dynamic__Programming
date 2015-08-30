import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MinNumbers {

	/**
	 * Author: Gaurav Shrivastava
	 */
	// m is size of coins array (number of different coins)
	public static int minCoins(int coins[], int V)
	{
	    // table[i] will be storing the minimum number of coins
	    // required for i value.  So table[V] will have result
	    int table[] = new int [V+1];
	 
	    // Base case (If given value V is 0)
	    table[0] = 0;
	 
	    // Initialize all table values as Infinite
	    for (int i=1; i<=V; i++)
	        table[i] = Integer.MAX_VALUE;
	 
	    // Compute minimum coins required for all
	    // values from 1 to V
	    for (int i=1; i<=V; i++)
	    {
	        // Go through all coins smaller than i
	        for (int j=0; j<coins.length; j++)
	          if (coins[j] <= i)
	          {
	              int sub_res = table[i-coins[j]];
	              if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
	                  table[i] = sub_res + 1;
	          }
	    }
	    return table[V];
	}
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	//give input to the function here!!	

	}

}
