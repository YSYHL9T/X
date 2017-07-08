public class PriorityTest extends Thread{
	public PriorityTest(){}
	public PriorityTest(String name)
	{
		super(name);
	}
	public void run()
	{
		for(int i=0;i<50;i++)
		{
			System.out.println(getName()+",���ȼ�Ϊ:"+getPriority()+",ѭ��������ֵΪ:"+i);
		}
	}
	public static void main(String[]args)
	{
		Thread.currentThread().setPriority(6);
		for(int i=0;i<30;i++)
		{
			if(i==10)
			{
				PriorityTest low=new PriorityTest("�ͼ�");
				low.start();
				System.out.println("��ʼ���ȼ� "+low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if(i==20)
			{
				PriorityTest high=new PriorityTest("�߼�");
				high.start();
				System.out.println("��ʼ���ȼ� "+high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}

}