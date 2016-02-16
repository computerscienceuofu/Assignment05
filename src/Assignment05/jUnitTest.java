package Assignment05;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class jUnitTest {
	

	@Test
	public void test(){
		
		
		//Here's the comparator that is passed in
		Comparator<Integer> comp = new Comparator<Integer>() {
		    public int compare(Integer i1, Integer i2) {
		    	return i1 - i2;
		    }
		};
		
		//size of list to generate
		int size = 100;
		
		//generates Best, Worst, and Average lists
		ArrayList<Integer> mergeBest = SortUtil.generateBestCase(size);
		ArrayList<Integer> mergeWorst = SortUtil.generateWorstCase(size);
		ArrayList<Integer> mergeAverage = SortUtil.generateAverageCase(size);
		
		ArrayList<Integer> quickBest = SortUtil.generateBestCase(size);
		ArrayList<Integer> quickWorst = SortUtil.generateWorstCase(size);
		ArrayList<Integer> quickAverage = SortUtil.generateAverageCase(size);
		
		//sorts using mergesort
		SortUtil.mergesort(mergeBest, comp);
		SortUtil.mergesort(mergeWorst, comp);
		SortUtil.mergesort(mergeAverage, comp);
		
		//sorts using quicksort
		SortUtil.quicksort(quickBest, comp);
		SortUtil.quicksort(quickWorst, comp);
		SortUtil.quicksort(quickAverage, comp);
		
		//here it generates Worst case lists that aren't sorted
		ArrayList<Integer> mergeWorstNotSorted = SortUtil.generateWorstCase(size);
		ArrayList<Integer> quickWorstNotSorted = SortUtil.generateWorstCase(size);
		
		for(int i = 0; i < size - 1; i++)
		{
			//tests whether they're sorted properly
			assertEquals(true, compare(mergeBest.get(i), mergeBest.get(i+1)) <= 0);
			assertEquals(true, compare(mergeWorst.get(i), mergeWorst.get(i+1)) <= 0);
			assertEquals(true, compare(mergeAverage.get(i), mergeAverage.get(i+1)) <= 0);
			assertEquals(true, compare(quickBest.get(i), quickBest.get(i+1)) <= 0);
			assertEquals(true, compare(quickWorst.get(i), quickWorst.get(i+1)) <= 0);
			assertEquals(true, compare(quickAverage.get(i), quickAverage.get(i+1)) <= 0);
			
			//tests the for loop to make sure it's working
			assertEquals(false, compare(mergeWorstNotSorted.get(i), mergeWorstNotSorted.get(i+1)) <= 0);
			assertEquals(false, compare(quickWorstNotSorted.get(i), quickWorstNotSorted.get(i+1)) <= 0);
		}
				
	}

	//separate comparator - does the same thing as the other, but can be used in the @test
	private int compare(Integer integer, Integer integer2) {
		return integer - integer2;
	}

}