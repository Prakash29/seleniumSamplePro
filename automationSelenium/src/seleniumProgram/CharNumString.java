package seleniumProgram;

public class CharNumString {

	public static void main(String[] args) 
	{

		String str="12@abAB34$c %d   &";
		String number="";
		String letter="";
		String other="";
		String ans=str.replaceAll("[^0-9]","");
		String ans2=str.replaceAll("[^a-zA-Z]","");
		String ans3=str.replaceAll("[^a-zA-Z0-9]","S");

		String repSpc="";
		for(int i=0;i<str.length();i++)
		{
			char a=str.charAt(i);
			if(Character.isDigit(a))
			{
				number=number+a;
			}
			else if(Character.isAlphabetic(a))
			{
				letter=letter+a;
			}
			else if(a==' ')
			{
				System.out.println(i+"space");
			}
			else 
			{
				System.out.println("position "+i+":"+str.charAt(i));
				other=other+a;
				

			}
			repSpc=repSpc+a;
		}
		System.out.println("Number in String-->"+number);
		System.out.println("Alphabets in String==>"+letter);
		System.out.println("Other in String==>"+other);

	}

}
