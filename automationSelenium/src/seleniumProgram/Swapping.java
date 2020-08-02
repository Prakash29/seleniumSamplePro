package seleniumProgram;

public class Swapping {

	public static void main(String[] args) 
	{
		int a=10;
		int b=20;
		int temp;
		
		//using three variable
		/*temp=a;
		a=b;
		b=temp;
		System.out.println("a-->"+a);
		System.out.println("b-->"+b);
*/
		
		//without using three variable
				a=a+b;
				b=a-b;
				a=a-b;
				System.out.println("a-->"+a);
				System.out.println("b-->"+b);
		
				
				//using XOR
				a=a^b;
				b=a^b;
				a=a^b;
				System.out.println("a-->"+a);
				System.out.println("b-->"+b);
	}

}
