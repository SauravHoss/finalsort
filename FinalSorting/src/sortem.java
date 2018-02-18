import java.util.Arrays;

public class sortem 
{

	public static void main(String[] args) 
	{
		String [] test1 = {"va","gb","f","c"};
		System.out.print(Arrays.toString(mergeSort(test1)));
	}

	public static String [] mergeSort(String [] list) 
	{
		if(list.length == 1)
		{
		return list;
		}
		else
		{
		String [] l = Arrays.copyOfRange(list,0,list.length/2);
		String [] r = Arrays.copyOfRange(list,list.length/2, list.length);
		return(merge(mergeSort(l),mergeSort(r)));
		}
	}

	public static void quickSort(int [] list1, int front, int back) 
	{
		
	}
	
	//base methods
	public static String[] merge(String [] list1, String [] list2) 
	{
		//Precondition : Both lists are sorted
		//Takes two arrays and merges them in ascending order
	
		String [] full = new String [(list1.length) + (list2.length)]; //i made it work but am confused about why its minus 1 and not 2
		
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
		
		while(j < full.length && l < list1.length) 
		{
			full[j] = list1[l];
			j++;
			l++;
		}
		
		while(j < full.length && r < list2.length) 
		{
			full[j] = list2[r];
			j++;
			r++;
		}
		return full;
	}
	
	//partiton attempt with bf
	public static int partition(int [] list, int front, int back)
	{
		//Takes an array, picks first number as pivot and puts smaller numbers on left side, bigger on right
		//Why is the run time so long did I do it wrong?
	    int base = list[0];    
	    int ni = front;
	    int last = back;

	    for(int i = 1; i < back; i++)
	    {
	        if(list[i] <= base)
	        {
	           swapperi(list,i,i-1);            
	            ni = i;
	        } 
	        else if(list[i] > base && last > i)
	        {
	            swapperi(list, i, last);
	            last--;
	            i--;
	        }
	    }
	    return ni;
	}
	
	//Swaps two items in an array of integers
			public static void swapperi(int [] arr, int x, int y) 
			{
				int holder = arr[x];
				arr[x] = arr[y];
				arr[y] = holder;	
			}
}
