import java.io.Serializable;

public class DataBean implements Serializable {
	//Attributes
	private double deviation;
	private double mean;
	
	

	/**
	 * Default Constructor
	 */
	public DataBean() 
	{
	}

	/**
	 * Overloaded Constructor
	 * @param deviation
	 * @param mean
	 */
	public DataBean(double deviation, double mean) {
		this.deviation = deviation;
		this.mean = mean;
	}

	/**
	 * @return the deviation
	 */
	public double getDeviation() {
		return deviation;
	}

	/**
	 * @param deviation the deviation to set
	 */
	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}

	/**
	 * @return the mean
	 */
	public double getMean() {
		return mean;
	}

	/**
	 * @param mean the mean to set
	 */
	public void setMean(double mean) {
		this.mean = mean;
	}
	
}
