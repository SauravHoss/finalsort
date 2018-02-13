import java.util.Arrays;

public class sortem 
{

	public static void main(String[] args) 
	{
		String [] test1 = { "apple","cucumber", "microsoft", "zorro",  "banana", "cherry", "mahogany","oreos", "pinata" };

		System.out.print(Arrays.toString(mergeSort(test1)));
	}

	public static String [] mergeSort(String [] list) 
	{
		if(list.length == 1)
		{
		return list;
		}
		
		String [] l = Arrays.copyOfRange(list,0,list.length/2);
		String [] r = Arrays.copyOfRange(list,list.length/2, list.length);
	
		return(merge(mergeSort(l),mergeSort(r)));
	}
	
//	public static int partition(int [] list, int front, int back)
	{
		
	}
	
	public static void quickSort(int [] list1, int front, int back) 
	{
		
	}
	
	//helpers
	public static String[] merge(String [] list1, String [] list2) 
	{
		//Precondition : Both lists are sorted
		//Takes two arrays and merges them in ascending order
	
		String [] full = new String [(list1.length) + (list2.length)-1]; //i made it work but am confused about why its minus 1 and not 2
		
		int j = 0;
		int l = 0;
		int r = 0;
		
		while(l < list1.length && r < list2.length && j < full.length) 
		{
			if (list1[l].compareTo(list2[r]) >= 0)
			{
				full[j] = list2[r];
				j++;
				r++;
			}			
			
			else
			{
				full[j] = list1[l];
				j++;
				l++;
			}
		}
	
		return full;
	}
	
	
}
