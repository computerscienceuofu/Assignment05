package Assignment05;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class jUnitTest {
	

	@Test
	public void test(){
		
		Comparator<Integer> comp = new Comparator<Integer>() {
		    public int compare(Integer i1, Integer i2) {
		    	return i1 - i2;
		    }
		};
		
		ArrayList<Integer> temp = SortUtil.generateBestCase(10);
		ArrayList<Integer> temp2 = SortUtil.generateWorstCase(10);
		ArrayList<Integer> temp3 = SortUtil.generateAverageCase(10);
				
		SortUtil.mergesort(temp, comp);
		SortUtil.mergesort(temp2, comp);
		SortUtil.mergesort(temp3, comp);
		for(int i = 0; i < temp.size(); i++)
		{
			System.out.println(temp.get(i));
			
		}
		for(int i = 0; i < temp2.size(); i++)
		{
			System.out.println(temp2.get(i));
			
		}
		for(int i = 0; i < temp3.size(); i++)
		{
			System.out.println(temp3.get(i));
			
		}
		
		
		

		
		
		
		
		
	}

}