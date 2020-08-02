package seleniumProgram;

public class PrimeNumber {

	public static void main(String[] args)
	{
		/*------------prime Number-------------*/
		int count = 0,no=13;
		for(int i=1;i<=no;i++)
		{
			System.out.println(no%i);
			if(no%i==0)
			{
				count++;
			}
		}
		if(count==2)
		{
			System.out.println("Prime number");
		}else
		{
			System.out.println("Not prime");
		}
		
		
		/*------------prime Number-------------*/
		int num=11,flag=0;
		for(int i=2;i<num;i++)
		{
			System.out.println(num%i);
			if(num%i==0)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("Number is prime");

		}
		else
		{
			System.out.println("Number is not prime");

		}

	}

}
