package Assignment05;
import java.util.*;

public class SortUtil <T>{
	
	private static int threshold = 4;	
	ArrayList<T> dataSet;
	ArrayList<T> temp;
	
	
	
	public static <T> void insertionSort(ArrayList<T> dataSet, int left, int right, Comparator<? super T> Comparator)
	{
		if(dataSet == null || Comparator == null)
			return;
		
		for (int i = 0; i < dataSet.size(); i++) {
			T itemToBeSorted = dataSet.get(i);
			if(itemToBeSorted == null)
				continue;
			int sortIndex = i - 1;

			while (sortIndex >= 0) {

				if (dataSet.get(sortIndex) == null || Comparator.compare(itemToBeSorted, dataSet.get(sortIndex)) < 0) {
					dataSet.set(sortIndex + 1, dataSet.get(sortIndex));
					dataSet.set(sortIndex, itemToBeSorted);
					sortIndex--;
				} else {
					dataSet.set(sortIndex + 1, itemToBeSorted);
					break;
				}
			}

		}
		
	}


	/**
     * This method performs a mergesort on the generic ArrayList given as input.
     * For the mergesort algorithm, see the class notes and/or the textbook. 
     * There is pseudo code in the slides. Your mergesort implementation must switch over 
     * to insertion sort when the size of the sublist to be sorted meets a certain threshold 
     * (i.e., becomes small enough). Make this threshold value a private static variable that 
     * you can easily change. You will perform experiments to determine which threshold value 
     * works best (see the Analysis Document).
     * 
     * Don't forget to include the insertion sort in the program files you submit.
    */
	public static <T> void mergesort(ArrayList<T> dataSet, Comparator<? super T> Comparator)
	{
		
	//if (dataSet.size() == 0)
	//		 throw new NoSuchElementException();
		int left = 0;
		int right = dataSet.size();
		
		mergesort(dataSet, left, right, Comparator);
		
	}
	
	private static <T> void mergesort(ArrayList<T> dataSet, int left, int right, Comparator<? super T> Comparator)
	{
		if (left < right)
		{
			int middle = (left + right) / 2;
			mergesort(dataSet, left, middle, Comparator);
			mergesort(dataSet, middle + 1, right, Comparator);
			merge(dataSet, left, middle, right, Comparator);
		}
	}


	private static <T> void merge(ArrayList<T> dataSet, int left, int mid, int right, Comparator<? super T> Comparator)
	{
				
		int h, i, j, k;
		ArrayList<T> temp = new ArrayList<T>();
		h = left;
		i = left;
		j = mid +1;
		
		while ((h <= mid) && (j <= right))
		{
			if(Comparator.compare(dataSet.get(h), dataSet.get(j)) <= 0)
			{
				temp.set(i, dataSet.get(h));
				h++;
			}
			else
			{
				temp.set(i, dataSet.get(j));
				j++;
			}
			i++;
		}
		if (h > mid)
		{
			for(k = j; k <= right; k++)
			{
				temp.set(i, dataSet.get(k));
				i++;
			}
		}
		else
		{
			for(k = h; k <= mid; k++)
			{
				temp.set(i, dataSet.get(k));
				i++;
			}
		}
		for (k = left; k < right; k++)
		{
			dataSet.set(k, temp.get(k));
		}
	}

	
	
	
	
	
	
	/**This method performs a quicksort on the generic ArrayList given as input.
	 * 
	 * For the quicksort algorithm, see the class notes and/or the textbook. There is pseudo code 
	 * in the slides. You must implement three different strategies for determining the pivot. 
	 * Your quicksort implementation should be able to easily switch among these strategies. 
	 * (Consider using a few private helper methods for your different pivot selection strategies.) 
	 * You will perform experiments to determine which pivot strategy works best (see the Analysis Document). 
	 * Your quicksort may also switch to insertion sort on some small threshold if you wish.
	 * 
	 * In designing a strategy for choosing a pivot, keep in mind that its running time affects 
	 * the overall running time of the quicksort.
	*/
	public static <T> void quicksort(ArrayList<T> dataSet, Comparator<? super T> Comparator)
	{

		
	}
	

	
	/**This is the insertionSort.  It will be used only when the other searches hit the item threshold.
	 * 
	 * @param sortAnagram
	 * @param comparator
	 */
	
	
	
	/**This method generates and returns an ArrayList of integers 1 to size in ascending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateBestCase(int size)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < size; i++)
			temp.add(i);
		
		return temp;
		
	}

	
	/**This method generates and returns an ArrayList of integers 1 to size in permuted order (i,e., randomly ordered).
	 *  
	 * @param size
	 * @return temp
	 */
	public static ArrayList<Integer> generateAverageCase(int size)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < size; i++)
			temp.add(i);
		for (int i = 0; i < size; i++)
			swap(temp, i, (int)(Math.random() * size));
		return temp;	
		
	}

	
	/**This method generates and returns an ArrayList of integers 1 to size in descending order.
	 * 
	 * @param size
	 * @return 
	 */
	public static ArrayList<Integer> generateWorstCase(int size)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = size-1; i >= 0; i--)
			temp.add(i);
		return temp;
		
	}
	
	/**This method swaps two elements
	 * @param <T>
	 * 
	 * @param array
	 * @param first
	 * @param second
	 */
	public static <T> void swap(ArrayList<T> array, int first, int second)
	{
		T temp = array.get(first);
		array.set(first, array.get(second));
		array.set(second, temp);
		
	}

	
	

}
