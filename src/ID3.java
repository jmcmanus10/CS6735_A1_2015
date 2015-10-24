import java.util.ArrayList;
public class ID3 {

	public static void main(String[] args) {
		DataSet d = new DataSet();
		String s ="./data/mushroom.data";
		d.loadData(s);
		//d.printData();
		d.printAttributeValueList(d.createAttributeValueList(d));
		

	}
	//main recursive method of ID3
	public void Split(ID3Node<String> node){
	//Find best attribute call it A
	//For each Value of A
		//Create child node
		//Create data subset
		//Stop if Pure
		//Stop if Empty
		//else Recurse
	//
	}
	



/**	public ArrayList<String[]> buildParityMatrix(DataSet d){
		for(DataInstance dI:d.getData()){
			
		}
	} 
**/
	 
	public int findBestAttribute(){
		return 0;
	}
	public boolean isEmpty(DataSet set){
		return false;
	}
	public boolean isPure(DataSet set, int attribute){
		return false;
	}
	// to calculate the information gained by splitting a node on the attribute at the given index 
	public float calculateInformationGain(int attribute){
		
		return 0;
	}
	
	//
	public void evaluate(DataSet testdata){
		
	}

}
