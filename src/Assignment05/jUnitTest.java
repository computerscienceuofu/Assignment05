package Assignment05;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class jUnitTest {
	
	long startTime = 0;
	long stopTime = 0;
	long aveTime = 0;
	
	//Here's the comparator that is passed in
		Comparator<Integer> comp = new Comparator<Integer>() 
		{
			public int compare(Integer i1, Integer i2) 
			{
			return i1 - i2;
			}
		};
		
		//separate comparator - does the same thing as the other, but can be used in the @test
		private int compare(Integer integer, Integer integer2) {
			return integer - integer2;
		}

	@Test
	public void mergeBestThresholdTest(){

		int size = 10_000;
		
		//generates Best, Worst, and Average lists
		for(int j = 1; j < 200; j*=2) 
	    { 
	            SortUtil.changethreshold(j); 
	            System.out.printf("threshold is at %d", j); 
	            System.out.println("\n"); 
	            for(int i = 10; i <= size; i*=10)
	            	{			
	            		ArrayList<Integer> mergeBest = SortUtil.generateBestCase(i);			
	            		startTime = System.nanoTime();
	            		SortUtil.mergesort(mergeBest, comp);
	            		stopTime = System.nanoTime();
	            		aveTime = stopTime - startTime;
	            		System.out.printf("Time for mergeBest case with size %d is: %d \n", i, aveTime);		
	            	}
	            System.out.println("\n");
	    }
	}

		
	@Test
	public void mergeAverageThresholdTest(){

		int size = 10_000;		
		for(int j = 1; j < 200; j*=2) 
	    { 
	            SortUtil.changethreshold(j); 
	            System.out.printf("threshold is at %d", j); 
	            System.out.println("\n"); 
	            for(int i = 10; i <= size; i*=10)
	            {
	            	ArrayList<Integer> mergeAverage = SortUtil.generateAverageCase(i);			
	            	startTime = System.nanoTime();
	            	SortUtil.mergesort(mergeAverage, comp);
	            	stopTime = System.nanoTime();
	            	aveTime = stopTime - startTime;
	            	System.out.printf("Time for mergeAverage case with size %d is: %d \n", i, aveTime);
	            }
	            System.out.println("\n");
	    }
	}

		@Test
		public void mergeWorstThresholdTest(){

		int size = 10_000;
		for(int j = 1; j < 200; j*=2) 
	    { 
	            SortUtil.changethreshold(j); 
	            System.out.printf("threshold is at %d", j); 
	            System.out.println("\n"); 			
	            for(int i = 10; i <= size; i*=10)
	            {
	            	ArrayList<Integer> mergeWorst = SortUtil.generateWorstCase(i);			
	            	startTime = System.nanoTime();
	            	SortUtil.mergesort(mergeWorst, comp);
	            	stopTime = System.nanoTime();
	            	aveTime = stopTime - startTime;
	            	System.out.printf("Time for mergeWorst case with size %d is: %d \n", i, aveTime);
	            }
	            System.out.println("\n");
	    }
		}

		
		@Test
		public void quickBestThresholdTest(){

		int size = 10_000;			
		for(int j = 1; j < 200; j*=2) 
	    { 
	            SortUtil.changethreshold(j); 
	            System.out.printf("threshold is at %d", j); 
	            System.out.println("\n"); 
	            for(int i = 10; i <= size; i*=10)
	            {	
	            	ArrayList<Integer> quickBest = SortUtil.generateBestCase(i);			
	            	startTime = System.nanoTime();
	            	SortUtil.quicksort(quickBest, comp);
	            	stopTime = System.nanoTime();
	            	aveTime = stopTime - startTime;
	            	System.out.printf("Time for quickBest case with size %d is: %d \n", i, aveTime);
	            }
	            System.out.println("\n");
	    }
		}

		@Test
		public void quickAverageThresholdTest(){

		int size = 10_000;	
		for(int j = 1; j < 200; j*=2) 
	    { 
	            SortUtil.changethreshold(j); 
	            System.out.printf("threshold is at %d", j); 
	            System.out.println("\n"); 		
	            for(int i = 10; i <= size; i*=10)
	            {
	            	ArrayList<Integer> quickAverage = SortUtil.generateAverageCase(i);
	            	startTime = System.nanoTime();
	            	SortUtil.quicksort(quickAverage, comp);
	            	stopTime = System.nanoTime();
	            	aveTime = stopTime - startTime;
	            	System.out.printf("Time for quickAverage case with size %d is: %d \n", i, aveTime);
	            }
	            System.out.println("\n");
	    }
		}

		@Test
		public void quickWorstThresholdTest(){

		int size = 10_000;	
		for(int j = 1; j < 200; j*=2) 
	    { 
	            SortUtil.changethreshold(j); 
	            System.out.printf("threshold is at %d", j); 
	            System.out.println("\n"); 				
	            for(int i = 10; i <= size; i*=10)
	            {
	            	ArrayList<Integer> quickWorst = SortUtil.generateWorstCase(i);
	            	startTime = System.nanoTime();
	            	SortUtil.quicksort(quickWorst, comp);
	            	stopTime = System.nanoTime();
	            	aveTime = stopTime - startTime;
	            	System.out.printf("Time for quickWorst case with size %d is: %d \n",i, aveTime);
	            }
	            System.out.println("\n");
	    }
		}
		
		
		@Test
		public void sortsAreWorkingProperlyTest(){

		int size = 10_000;	
	         
		//changes threshold back to 3
	    SortUtil.changethreshold(3); 
	
		//size of list to generate		
		size = 100;
		
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

	

}