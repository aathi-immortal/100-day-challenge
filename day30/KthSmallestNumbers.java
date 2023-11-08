import java.util.ArrayList;

public class Solution {

	static int[] minHeap;
	public static void heapifyBottomUp()
	{
		int size = minHeap.length;
		
		
		int lastIndex = ((int)Math.ceil((double)(size - 1)/2) - 1);
		while(lastIndex >= 0)
		{
			heapBuilder(lastIndex,size);
			
			lastIndex--;
			
		}		
		
	}
	public static int minChild(int left,int right)
	{
		return (minHeap[left] < minHeap[right])?left:right;
	}
	
	public static void heapBuilder(int lastIndex,int size)
	{
		int numberOfInternalNodes = (int)Math.ceil((double)(size - 1)/2) - 1;
		if(lastIndex <= numberOfInternalNodes)
		{
				int parentValue = minHeap[lastIndex];
			int leftChildIndex = 2 * lastIndex + 1;
			int rightChildIndex = 2 * lastIndex + 2;
			// if both child
			if(rightChildIndex < size)
			{
				// compare the chilf value
				int minChildIndex = minChild(leftChildIndex, rightChildIndex);
				// compare with parent
				if(parentValue > minHeap[minChildIndex])
				{
					// swap it 
					minHeap[lastIndex] = minHeap[minChildIndex];
					minHeap[minChildIndex] = parentValue;
					heapBuilder(minChildIndex, size);
				}
				
			}
			 
			else
			{
				if(parentValue > minHeap[leftChildIndex])
				{
					minHeap[lastIndex] = minHeap[leftChildIndex];
					minHeap[leftChildIndex] = parentValue;
				}
			}
			
		}
		
	}
	public static void heapifyTopDown()
	{
		int size = minHeap.length;
		int lastIndex = 0;
		int numberOfInternalNodes = (int)Math.ceil((double)(size - 1)/2) - 1;
		while(lastIndex <= numberOfInternalNodes )
		{
			int parentValue = minHeap[lastIndex];
			int leftChildIndex = 2 * lastIndex+ 1;
			int rightChildIndex = 2 * lastIndex + 2;
			if(rightChildIndex < size)
			{
				int minChildIndex = minChild(leftChildIndex, rightChildIndex);
				if(parentValue > minHeap[minChildIndex])
				{
					minHeap[lastIndex] = minHeap[minChildIndex];
					minHeap[minChildIndex] = parentValue;
					lastIndex = minChildIndex;
					continue;
				}
				break;
			}
			else
			{
				if(parentValue > minHeap[leftChildIndex])
				{
					minHeap[lastIndex] = minHeap[leftChildIndex];
					minHeap[leftChildIndex] = parentValue;

				}	
				break;
					
			}
		}
	}
	public static ArrayList<Integer> convertToArrayList()
	{
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0;i<minHeap.length;i++)
		{
			arr.add(minHeap[i]);
		}
		return arr;
	}
	public static void displayMinHeap()
	{
		for(int i = 0;i<minHeap.length;i++)
		{
			System.out.println(minHeap[i]);
		}
	}
	public static ArrayList<Integer> kLargest(int n, int[] input, int k) {
		// Write your code here
		// traverse the array upto k items
		minHeap = new int[k];
		for(int i = 0;i<k;i++)
		{
			minHeap[i] = input[i];
		}
		// heapify the array 
		heapifyBottomUp();
		
		// traver the array from k to n
		for(int i = k;i<n;i++)
		{
			// compare the current value with the head in the minHeap
			if(input[i] > minHeap[0])
			{
				// remove the head
				// insert the new head
				minHeap[0] = input[i];
				heapifyTopDown();
				// heapify it top down
			}
		}
		
		return convertToArrayList();
	}
}
