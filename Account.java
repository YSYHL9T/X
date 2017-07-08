import java.util.concurrent.locks.ReentrantLock;
public class Account
{
	private String accountNo;
	private double balance;
	private final ReentrantLock lock=new ReentrantLock();
	public Account()
	{

	}
	public Account(String accountNo,double balance){
		this.accountNo=accountNo;
		this.balance=balance;
	}
	public void setAccountNo(String accountNo)
	{
		this.accountNo=accountNo;
	}
	public String getAccountNo()
	{
		return accountNo;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;

	}
	public double getBalance()
	{
		return balance;
	}
	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if(obj!=null&&obj.getClass()==Account.class)
		{
			Account target=(Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
	public void draw(double drawAmount)
	{
		lock.lock();
		try
		{
			if(balance>=drawAmount)
			{
				System.out.println(Thread.currentThread().getName()+"ȡǮ�ɹ�!�³���Ʊ"+drawAmount);
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
				balance-=drawAmount;
				System.out.println("\t���Ϊ:"+balance);
			}
			else
			{
				System.out.println(Thread.currentThread().getName()+"ȡǮʧ��!����");
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
}