import java.util.*;
import java.util.concurrent.*;

public class threadCode
{

	public static void main(String[] args)
	{
		System.out.println("hi");
		ExecutorService fixedPool = Executors.newFixedThreadPool(1000);

		long totalTime = 0;
		try
		{
			for(int x = 0; x < 1000; x++)
			{
				Future<Long> future = fixedPool.submit(new Task());
				totalTime += future.get();
			}
			System.out.println(totalTime + " : TIME in milliseconds");
		}
		catch(Exception e)
		{
			System.out.println("ooops");
		}
	}

	static class Task implements Callable
	{
		@Override
		public Long call() throws Exception
		{
			long start = System.currentTimeMillis();
			int numbers = 0;
			for(int x = 1; x <= 1000000; x++)
			{
				numbers++;
			}
			System.out.println(numbers);
			return System.currentTimeMillis() - start;
		}
	}


}