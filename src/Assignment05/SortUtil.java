package Assignment05;
import java.util.*;

public class SortUtil <T>{
	
	private static int threshold = 3;	
	
	
	/**This is the insertionSort.  It will be used only when the other searches hit the item threshold.
	 * 
	 * @param sortAnagram
	 * @param comparator
	 */
	public static <T> void insertionSort(ArrayList<T> dataSet, int left, int right, Comparator<? super T> Comparator)
	{
		if(dataSet == null)
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
		
		if (dataSet.size() == 0)
		{
			 throw new NoSuchElementException();
		}
		
		ArrayList<T> temp = new ArrayList<T>();		
		int	left = 0;
		int right = dataSet.size()-1;
		for(int x = left; x <= right; x++)
		{
			temp.add(dataSet.get(x));
		}
		
		mergesort(dataSet, temp, left, right, Comparator);		
	}
	
	private static <T> void mergesort(ArrayList<T> dataSet, ArrayList<T> temp, int left, int right, Comparator<? super T> Comparator)
	{
		
		if  ((right-left) <= threshold)
		{
			insertionSort(temp, left, right, Comparator);
		}
		else
		{
			int midPoint = (left+right)/2;
			
			
			mergesort(dataSet, temp, left, midPoint, Comparator);
			mergesort(dataSet, temp, midPoint + 1, right, Comparator);
			merge(dataSet , temp, left, right, Comparator);
		}
	}


	private static <T> void merge(ArrayList<T> dataSet, ArrayList<T> temp, int left, int right, Comparator<? super T> Comparator)
	{
				
		int midPoint = (left + right)/2;
		int i = left;
		int j = midPoint + 1;
		int pointer = left;
		
		while (i <= midPoint || j <= right)
		{

			if (i <= midPoint && j > right)
			{
				dataSet.set(pointer, temp.get(i));
				i++;
				pointer++;
				continue;
			}

			if (i > midPoint && j <= right)
			{
				dataSet.set(pointer, temp.get(j));
				j++;
				pointer++;
				continue;
			}

			if (Comparator.compare(temp.get(i), temp.get(j)) < 0)
			{
				dataSet.set(pointer, temp.get(i));
				i++;
				pointer++;
				continue;
			}

			else if(Comparator.compare(temp.get(i), temp.get(j)) > 0)
			{
				dataSet.set(pointer, temp.get(j));
				j++;
				pointer++;
				continue;
			}

			else
			{
				dataSet.set(pointer, temp.get(i));
				i++;
				pointer++;
				dataSet.set(pointer, temp.get(j));
				j++;
				pointer++;
				continue;
			}
		}
		for (int k = left; k <= right; k++)
			temp.set(k, dataSet.get(k));
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
		int start = 0;
		int end = dataSet.size() -1;
		quicksorter(dataSet, start, end, Comparator);
		
	}
		
	private static <T> void quicksorter(ArrayList<T> dataSet, int start, int end, Comparator<? super T> Comparator) {
		if (start < end)
		{
			int partitionIndex = Partition(dataSet, start, end, Comparator);
			quicksorter(dataSet, start, partitionIndex - 1, Comparator);
			quicksorter(dataSet, partitionIndex + 1, end, Comparator);
		}
		
	}

	private static <T> int Partition(ArrayList<T> dataSet, int start, int end, Comparator<? super T> Comparator) {
		
		int partitionIndex = start;
		for(int i = start; i < end; i++)
		{
			if(Comparator.compare(dataSet.get(i), dataSet.get(end)) <= 0)
			{
				swap(dataSet, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(dataSet, partitionIndex, end);
		return partitionIndex;
	}

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
		T tempItem = array.get(first);
		array.set(first, array.get(second));
		array.set(second, tempItem);
		
	}

}
