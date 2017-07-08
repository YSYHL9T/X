public class DrawThread extends Thread
{
	private Account account;
	private double drawAmount;
	public DrawThread(String name,Account account,double drawAmount)
	{
		super(name);
		this.account=account;
		this.drawAmount=drawAmount;
	}
	public void run()
	{
		account.draw(drawAmount);
		/*synchronized(account)
		{
			if(account.getBalance()>=drawAmount)
			{
				System.out.println(getName()+"ȡǮ�ɹ�!�³���Ʊ"+drawAmount);
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
				account.setBalance(account.getBalance()-drawAmount);
				System.out.println("\t���Ϊ:"+account.getBalance());
			}
			else
			{
				System.out.println(getName()+"ȡǮʧ��!����");
			}
		/*}*/
	}
}