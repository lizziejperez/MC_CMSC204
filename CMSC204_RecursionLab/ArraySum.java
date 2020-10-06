/**
 * ArraySum Class
 * @author Elizabeth Perez
 *
 */
public class ArraySum {
	/**
	 * Sums the integers in an array from the index
	 * @param a - an integer array
	 * @param index
	 * @return sum of array from index
	 */
	public int sumOfArray(Integer[] a,int index) {
		int sum;
		if(index == 0) {
			sum = a[index];
		} else {
			sum = a[index] + sumOfArray(a, --index);
		}
		return sum;
	}
}
