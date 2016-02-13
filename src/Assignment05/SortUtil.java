package Assignment05;
import java.util.*;

public class SortUtil {
	
	private static int threshold = 6;
	
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
	public static <T> void mergesort(ArrayList<T>, Comparator<? super T>)
	{
		for(int i = 0; i < 10; i++)
		{
			
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
	public static <T> void quicksort(ArrayList<T>, Comparator<? super T>)
	{
		
	}
	
	
	/**This method generates and returns an ArrayList of integers 1 to size in ascending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateBestCase(int size){
		
	}

	
	/**This method generates and returns an ArrayList of integers 1 to size in permuted order (i,e., randomly ordered).
	 *  
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateAverageCase(int size){
		
	}

	
	/**This method generates and returns an ArrayList of integers 1 to size in descending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateWorstCase(int size){
		
	}
	


}