package seleniumProgram;

public class PerfectNumber {

	public static void main(String[] args)
	{

		int sum=0,num=6;
		for(int i=1;i<num;i++)
		{
			if(num%i==0)
			{
				sum=sum+i;
			}
		}
		if(num==sum)
		{
			System.out.println("Number is Perfect"+num);
		}
		else
		{
			System.out.println("Number is not  Perfect"+num);

		}
		
	}

}
