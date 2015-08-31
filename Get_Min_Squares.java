public class GetMinSquares {

	/**
	 * Author: Gaurav  Shrivastava
	 */
	public static void main(String[] args) {
		int arr[] = new int [1000001];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		for (int i = 4; i < arr.length; i++) {
			int k = i - (int)Math.pow((int)Math.sqrt(i), 2);
			arr[i] = 1 + arr[k];
		}
		for (int i = 0; i < 11; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		for (int i = 10; i < 21; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		for (int i = 20; i < 31; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		for (int i = 30; i < 41; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		for (int i = 40; i < 51; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();

	}

}
