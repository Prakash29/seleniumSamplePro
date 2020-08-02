package seleniumProgram;


class a
{
	int c=10;

	public void show()
	{
		System.out.println("Show method"+c);
	}
}
class b extends a
{

	public void show()
	{
		super.show();
		System.out.println("Show method2"+c);

	}
}
	public class SeleniumDemo
	{
		public static void main(String arg[])
		{
			b obj=new b();
			obj.show();

		}
	}
