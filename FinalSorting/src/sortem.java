import java.util.Arrays;

public class sortem 
{

	public static void main(String[] args) 
	{
		//Testing Arrays
		String [] test1 = {"my", "i","love","sister"};
		int [] test2 = {8,9,4,7,9,4,2,6,9,0,1};

		//Mergesort Test
		long start = System.nanoTime();
		System.out.println("Mergesort Test");
		System.out.println("	Original: "+Arrays.toString((test1)));
		System.out.println("	Final: "+Arrays.toString(mergeSort(test1)));
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("						Time Taken: "+ time + " nanoseconds");
		
		//Quicksort Test
		start = System.nanoTime();
		System.out.println("Quicksort Test");
		System.out.println("	Original: "+Arrays.toString(test2));
		sortem.quickSort(test2, 0, test2.length-1); //Why do we have to do this Mr. Levin :C
		System.out.println("	Final : " +Arrays.toString(test2));
		end = System.nanoTime();
		time = end - start;
		System.out.println("						Time Taken: "+ time + " nanoseconds");
	}

	//Case Sensitive Merge Sort (Caps go before lowercase)
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

	//Takes an array of integers and sorts them to be chronological 
	public static void quickSort(int arr[], int low, int high)
	 {
	     if (low < high)
	     {
	         int pi = partition(arr, low, high);
	         
	         quickSort(arr, low, pi-1);
	         quickSort(arr, pi+1, high);
	     }
	 }
	
	//Base methods
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
	
	public static int partition(int arr[], int low, int high)
	 {
	     int pivot = arr[high]; 
	     int i = (low - 1); // index of smaller element
	     for (int j = low; j < high; j++)
	     {
	         // If current element is smaller than or
	         // equal to pivot
	         if (arr[j] <= pivot)
	         {
	             i++;
	             // swap arr[i] and arr[j]
	             swapperi(arr, i, j);
	         }
	     }

	     // swap arr[i+1] and arr[high] (or pivot)
	     swapperi(arr, i+1, high);
	     return i+1;
	 }
	
	//Helpers
	//Swaps two items in an array of integers
	public static void swapperi(int [] arr, int x, int y) 
	{
		int holder = arr[x];
		arr[x] = arr[y];
		arr[y] = holder;	
	}
}