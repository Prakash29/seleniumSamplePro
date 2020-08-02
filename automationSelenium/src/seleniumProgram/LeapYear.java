package seleniumProgram;

public class LeapYear {

	public static void main(String[] args)
	{
        int year=2018;
       
        if(year%4==0)
        {
        	System.out.println("leap year"+year);
        }
        else
        {
        	System.out.println("not leap year"+year);

        }
	}

}
