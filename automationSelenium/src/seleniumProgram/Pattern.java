package seleniumProgram;

public class Pattern {

	public static void main(String[] args) 
	{
		
/*
  
    * 
   * * 
  * * * 
 * * * * 
* * * * * 
     
    */
        for(int i=1;i<=5;i++)
        {
        	for(int j=i;j<5;j++)
        	{
        		System.out.printf(" ");
        	}
        	for(int k=1;k<=i;k++)
        	{
        		System.out.printf("* ");
        	}
        	System.out.printf("\n");
        	
        }
        
      /* 
                * * * * * 
                 * * * * 
                  * * * 
                   * * 
                    * 
            
           */

        for(int i=1;i<=5;i++)
		{
			for(int j=1;j<i;j++)
			{
				System.out.printf(" ");
			}
			for(int k=i;k<=5;k++)
			{
				System.out.printf("* ");
			}
			System.out.println();
		}

	}

}

