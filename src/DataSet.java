import java.util.Random;

public class DataSet {
	String[][] dataArray;
	int numInstances;
	int numAttributes;
	String[] attributes;
	//I need Some way of storing the different values each attribute can take 
	
	public void shuffle(){
	//Every day I'm shuffling a data set to randomize it	
	}
	
	public DataSet splitData(int n){
		//Splits the data set on the attribute in column n
		return null;
	}
	/**
	 * Returns an int[] with the number of each instances' fold number in its instance index
	 * Test data is the last fold and contains the remainder "Test Data" is marked by a 0 
	 * @param k
	 * @return
	 */
	public int[] kfold(int k){
		int[] folds = new int[numInstances];
		int foldSize = numInstances/k;
		int remainder= numInstances%k;
		int placeHolder = 0;
		for(int j=k;j>0;j--){
			
			for(int i=placeHolder;i<(placeHolder+foldSize);i++){
				folds[i]=j;
			}
			placeHolder = placeHolder + foldSize;
		}
		for(int h=placeHolder; h<(placeHolder+foldSize+remainder);h++){
			folds[h]=0;
		}
		return folds;
	}


}
