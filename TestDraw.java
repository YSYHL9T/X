public class TestDraw
{
	public static void main(String[]args)
	{
		Account acct=new Account("123456",1000);
		new DrawThread("��",acct,800).start();
		new DrawThread("��",acct,800).start();
	}
}