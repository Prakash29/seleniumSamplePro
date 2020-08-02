package seleniumProgram;

public class palindromeNo {

	public static void main(String[] args) 
	{

		int num=121,temp,rev = 0;
		int n=num;
         while(num>0)
         {
        	 temp=num%10;
        	 rev=rev*10+temp;
        	 num=num/10;
         }
         if(n==rev)
         {
        	 System.out.println("Number is Palindrome");
         }
         else
         {
        	 System.out.println("Number is not Palindrome");
         }
         
        /* Display 1 to 100 Palindrome numbers*/
		int no;
		
         for(int i=1;i<=100;i++)
         {
            rev=0;
            no=i;
            while(no>0)
            {
            	temp=no%10;
            	rev=rev*10+temp;
            	no=no/10;
            }
            if(i==rev)
            {
           	 System.out.println(i+"-->Number is Palindrome");
            }
            else
            {
           	 System.out.println(i+"-->Number is not Palindrome");
            }
         }
         
	}

}
