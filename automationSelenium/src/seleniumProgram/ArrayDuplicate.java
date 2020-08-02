package seleniumProgram;
public class ArrayDuplicate 
{

	public static void main(String[] args) 
	{
        int count=0;
		int arr[] = {1, 2, 3, 1, 3, 6, 6}; 
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count ++;
										
				}
			}
			System.out.println(arr[i]+"fount of "+count);
			//System.out.println(arr[i]+" fount of "+count);
             count =0;
		}
	}

}
