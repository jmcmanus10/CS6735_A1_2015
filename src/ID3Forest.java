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
		double w =0.0;
		ArrayList<WeightedCategory> voter = new ArrayList<WeightedCategory>();
		
		//for(ID3Node tree:this.forest){
		for(int i = 0; i<this.forest.size();i++){
		
			s = cat.Categorize(dI, this.forest.get(i));
			w = this.weights.get(i);
			boolean contained = false;
			
			for(WeightedCategory vote:voter){
				if(vote.getArrtibuteValue().equals(s)){
					contained =true;
					vote.setweight(vote.getweight()+w);
				}
			}
			if(!contained){
				WeightedCategory wc = new WeightedCategory(s,w);
				voter.add(wc);
			}

		
		}
		double max =0.0;
		
		for(WeightedCategory wc:voter){
			if(wc.getweight()>=max){
				max=wc.getweight();
				s=wc.getArrtibuteValue();
			}
		}
		
		
		
		return s;
	}
	
public void addTree(ID3Node tree, Double weight){
		forest.add(tree);
		weights.add(weight);
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
