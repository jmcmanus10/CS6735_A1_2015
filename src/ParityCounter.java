
public class ParityCounter {
	private int count;
	private String attributeValue;


	public ParityCounter(){

	}

	public ParityCounter(String attributeValue, int count){
		this.attributeValue = attributeValue;
		this.count = count;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public String getArrtibuteValue() {
		return attributeValue;
	}

	public void setArrtibuteValue(String arrtibuteValue) {
		this.attributeValue = attributeValue;
	}

}