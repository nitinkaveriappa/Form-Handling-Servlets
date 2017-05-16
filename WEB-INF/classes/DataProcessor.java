import java.math.*;

public class DataProcessor {
	
	public DataBean calculate(String input)
	{
		DataBean cData = new DataBean();
		String[] list = input.split(",",10);
		
		int[] num = new int[10];;
		int total = 0;
		double mean, var = 0, sd;
		
		for(int i=0;i<10;i++)
		{
			num[i] = Integer.parseInt(list[i]);
			total += num[i];
		}
		
		mean = total/10;
		
		for(int i=0;i<10;i++)
		{
			 var += (num[i]-mean)*(num[i]-mean);
		}
		var = var/10;
		sd = Math.sqrt(var);
		
		cData.setMean(mean);
		cData.setDeviation(sd);
		
		return cData;
	}
}
