
public class WeightedCategory {
	private double weight;
	private String attributeValue;


	public WeightedCategory(){

	}

	public WeightedCategory(String attributeValue, double weight){
		this.attributeValue = attributeValue;
		this.weight = weight;
	}


	public double getweight() {
		return weight;
	}


	public void setweight(double weight) {
		this.weight = weight;
	}

	public String getArrtibuteValue() {
		return attributeValue;
	}

	public void setArrtibuteValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

}