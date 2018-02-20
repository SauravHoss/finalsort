import java.util.Arrays;

public class sortem 
{

	public static void main(String[] args) 
	{
		String [] test1 = {"my", "i","a","more","than", "love","anyone", "sister","lot"};
		System.out.println(Arrays.toString(mergeSort(test1)));
		
		int [] test2 = {8,9,4,7,9,4,2,6,9,0,1};
		sortem.quickSort(test2, 0, test2.length-1);
		System.out.print(Arrays.toString(test2));
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
	         /* pi is partitioning index, arr[pi] is 
	           now at right place */
	         int pi = partition(arr, low, high);

	         // Recursively sort elements before
	         // partition and after partition
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
