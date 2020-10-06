public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3; //0
		myArray[index++] = 5; //1
		myArray[index++] = 2; //2
		myArray[index++] = 6; //3
		
		int sum = arraySum.sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7; //4
		myArray[index++] = 1; //5
		
		sum = arraySum.sumOfArray(myArray, 5);
		System.out.println(sum);
	}

}