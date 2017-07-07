public class TestYield extends Thread
{
	public TestYield(){}
	public TestYield(String name )
	{
		super(name);
	}
	public void run()
	{
		for(int i=0;i<50;i++)
		{
			System.out.println(getName()+" "+i);
			if(i==20)
			{
				Thread.yield();
			}
		}
	}
	public static void main(String []args)throws Exception
	{
		TestYield ty1=new TestYield("µÍ¼¶");
		ty1.start();
		TestYield ty2=new TestYield("¸ß¼¶");
		ty2.start();
	}
}