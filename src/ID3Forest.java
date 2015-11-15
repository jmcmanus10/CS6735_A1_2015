import java.util.ArrayList;

public class ID3Forest {
	private ArrayList<ID3Node> forest;
	private ArrayList<Double> weights;
	private ID3Categorizer cat = new ID3Categorizer(); 
	
	ID3Forest(){
		forest = new ArrayList<ID3Node>();
		weights = new ArrayList<Double>();
	}
	
	
	ID3Forest(ArrayList<ID3Node> trees){
		forest = trees;
		for(ID3Node tree:forest){
			this.weights.add(1.0);
		}
	}
	
	ID3Forest(ArrayList<ID3Node> trees, ArrayList<Double> treeWeights){
		forest = trees;
		weights = treeWeights;
	}
	

	public String categorize(DataInstance dI){
		String s = "";
	//	ArrayList<WeightedCategory>
		
		for(ID3Node tree:forest){
			s = cat.Categorize(dI, tree);
			
		}
		
		return s;
	}
	
public void addTree(ID3Node tree, Double weight){
		
}
	
	public ArrayList<ID3Node> getForest() {
		return forest;
	}


	public void setForest(ArrayList<ID3Node> forest) {
		this.forest = forest;
	}


	public ArrayList<Double> getWeights() {
		return weights;
	}


	public void setWeights(ArrayList<Double> weights) {
		this.weights = weights;
	}
	
	

}
