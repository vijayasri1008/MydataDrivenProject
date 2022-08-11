package listenersPgm;

import org.junit.Assert;
import org.testng.annotations.Test;

public class list1 {
	@Test(retryAnalyzer = myRetryListener.class)
	public void test1()
	{
		System.out.println("test1");
		//Assert.fail();
	}

	@Test
	public void test2()
	{
		System.out.println("test2");
		System.out.println("time calculated");
		System.out.println(System.currentTimeMillis());

		System.out.println(Thread.currentThread().getId());
	}
	@Test
	public void test3()
	{
		System.out.println("test3");
				System.out.println("time calculated");

	}
}
