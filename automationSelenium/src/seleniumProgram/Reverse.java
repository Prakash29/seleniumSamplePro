package seleniumProgram;

public class Reverse {

	public static void main(String[] args) 
	{
		Reverse obj=new Reverse();
		obj.reverseNumber();
		//obj.reverseString();
		//obj.reverseNumber();

	}
	public void reverseString()
	{
		String str="Geeta";
		String rev="";
		int l=str.length();
		for(int i=l-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println("Reverse String is: "+rev);
	}
	public void reverseNumber()
	{
		int num=12345;
		int rev = 0;

		while(num!=0)
		{
			int digit=num%10;
			rev=rev*10+digit;
			num/=10;

		}
		System.out.println("Reverse Number is: "+rev);
	}

	public void revswap()
	{
		
		int a=5;
		int b=4;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a);
		
		System.out.println(b);

		char[] s=new char[50];
		
		String str="Geeta";
		int l=str.length();
		char temp;
		//int j;
		//j=str.length()-1;
		
		for(int i=0;i<str.length()/2;i++)
		{
			temp=s[i];
			s[i]=s[l-1-i];
			s[l-1-i]=temp;
			
			System.out.println(s);
			//System.out.println(str.charAt(j));
            
		}

	}

}
