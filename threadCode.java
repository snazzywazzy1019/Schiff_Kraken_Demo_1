import java.util.*;
import java.util.concurrent.*;

public class threadCode
{

	public static void main(String[] args)
	{
		System.out.println("hi");
		ExecutorService fixedPool = Executors.newFixedThreadPool(1000);

		int totalTime = 0;
		long startTime = System.currentTimeMillis();
		try
		{
			for(int x = 0; x < 1000; x++)
			{
				Future<Integer> future = fixedPool.submit(new Task());
				totalTime += future.get();
			}
			System.out.println(totalTime + " : total ");
			System.out.println(" time: " + (System.currentTimeMillis() - startTime));
		}
		catch(Exception e)
		{
			System.out.println("ooops");
		}
	}

	static class Task implements Callable<Integer>
	{
		@Override
		public Integer call() throws Exception
		{
			int numbers = 0;
			for(int x = 1; x <= 1000000; x++)
			{
				numbers++;
			}
			return numbers;
		}
	}


}