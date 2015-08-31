public class MinCost {

	/**
	 * Author:- Gaurav Shrivastava
	 */
	// This function returns the smallest possible cost to
	// reach station N-1 from station 0.
	public static int MinimumCost(int cost[][],int N){
		 // dist[i] stores minimum cost to reach station i
	    // from station 0.
	    int dist[] = new int[N];
	    for (int i=0; i<N; i++)
	       dist[i] = Integer.MAX_VALUE;
	    dist[0] = 0;
	 
	    // Go through every station and check if using it
	    // as an intermediate station gives better path
	    for (int i=0; i<N; i++)
	       for (int j=i+1; j<N; j++)
	          if (dist[j] > dist[i] + cost[i][j])
	             dist[j] = dist[i] + cost[i][j];
	 
	    return dist[N-1];
	}
	public static void main(String[] args) {
		int cost[][] = { {0, 15, 80, 90},
                {Integer.MAX_VALUE, 0, 40, 50},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 70},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
              };
		System.out.print(cost[0].length);
		System.out.println(  "The Minimum cost to reach station "
			    + cost[0].length + " is " + MinimumCost(cost,cost.length));

	}

}
