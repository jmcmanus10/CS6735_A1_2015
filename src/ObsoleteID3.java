
public class ObsoleteID3 {
	public static void main (String[] args){
		System.out.println("hello ID3! changed");
		String[] bob = {"hello","world","!","Again","!!!"};
		for(String b:bob){
			System.out.println(b);
		}
	}
	
	/**
	 * Calculates the information gained of choosing to split on an Attribute 
	 * @return
	 */
	public float calculateInformationGain(/*data set d, attribute a*/){
		return 0;
	}
	
	/**
	 * Calculates the Entropy of a Set.
	 * Attribute a is the attribute on which the purity of the data set will be examined 
	 * @return
	 */
	public float calcualteEntropy(/*Data set d, Attribute a*/){
		return 0;
	}
	/**
	 * Iterates over the possible attributes to split on
	 * and find the attribute with the highest information gain
	 * @return an int currently while I figure out the best way to return an Attribute currently using an index 
	 */
	public int chooseAttribute(){
		return 0;
	}
	
	/**
	 *Takes a data Set and produces data sets Split over the possible values for the splitting attribute 
	 */
	public void splitData(){
		
	}

}
