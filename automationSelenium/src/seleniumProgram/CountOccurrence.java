package seleniumProgram;

import java.util.Arrays;
import java.util.Scanner;

public class CountOccurrence {

	public static void main(String[] args)
	{
		CountOccurrence obj=new CountOccurrence();
		obj.numberOccurrence();
	}
	
	public void numberOccurrence()
	{
		
		int[] arr = {1,1,3,3,5,0,1,0,2,0}; 
		int count=0;
		int l=arr.length;
		int[] newarr=new int[l];
		for(int i=0;i<arr.length;i++)
		{
			
			newarr[i]=arr[i];
			
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
		
			
			System.out.println(arr[i]+"--Occurrence count-->"+count);
			count=0;
			System.out.println(Arrays.toString(newarr));
		}
		
	}

	public void countZeroOneOccurrence()
	{
		
		int[] arr = new int[]{ 1,1,3,3,5,0,1,0,2,0}; 
		int count0=0,count1=0;
		int l=arr.length;
		for(int i=0;i<arr.length;i++)
		{
			
			if(arr[i]==0)
			{
				count0++;
			}
			else if(arr[i]==1)
			{
				count1++;
			}
		}
		System.out.println("Zero occurrence "+count0);
		System.out.println("One occurrence "+count1);

		
	}
}
