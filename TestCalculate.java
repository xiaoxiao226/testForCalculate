package testForJunit;

//静态导入
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculate {

	Calculate cal;
	
	@Before
	//标识初始化方法，执行每一个方法前，需要初始化setup
	public void setUp()
	{
		cal = new Calculate();
	}
	
	@Test
	//加法测试
	public void testAdd()
	{
		int result = cal.add(20, 21);
		assertEquals("加法有问题！", result, 41);
	}
	
	@Test
	//减法测试
	public void testMinus()
	{
		int result = cal.minus(18, 3);
		assertEquals("减法有问题！", result, 15);
	}
	
	@Test
	//乘法测试
	public void testMulti()
	{
		int result = cal.multi(2, 3);
		assertEquals("乘法有问题！", result, 6);
	}
	
	@Test
	//除法测试
	public void testDivide()
	{
		int result = cal.divide(20, 5);
		assertEquals("除法有问题！", result, 4);
	}
	
	@Test(expected=ArithmeticException.class)
	//除法测试，抛出异常
	public void testDivideThrowException()
	{
		int result = cal.divide(20, 0);
		assertEquals("除法有问题！", result, 4);
	}
	
	@Test(timeout = 200)
	//对一个方法的时间进行测试，限制时间为200ms，不能再限制时间内完成，则抛出异常
	public void testTime()
	{
		try{
			Thread.sleep(250);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		int result = cal.add(20, 21);
		assertEquals("加法有问题！", result, 41);
	}
	
}
