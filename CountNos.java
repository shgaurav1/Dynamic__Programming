class CountNos {

	/**
	 * Author:Gaurav Shrivastava
	 */
	
	
	public static int Count(int n){
		int count[] = new int[n+1];
		
		count[0] = 1;
		
		for (int i = 3; i < count.length; i++) {
			count[i] += count[i -3];
		}
		for (int i = 5; i < count.length; i++) {
			count[i] += count[i -5];
		}
		for (int i = 10; i < count.length; i++) {
			count[i] += count[i -10];
		}
		
		return count[n];}	
	
	public static void main(String[] args) {
		int n = 20;
	    System.out.println("Count for "+n+" is " + Count(n));
	 
	    n = 13;
	    System.out.println("Count for " +n+ " is " + Count(n));

	}

}
