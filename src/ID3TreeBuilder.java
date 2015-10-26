
public class ID3TreeBuilder {
	
	public ID3TreeBuilder(){
		
	}

	
	//Find best attribute call it A
			//For each Value of A
			//Create child node
			//Create data subset
			//Stop if Pure
			//Stop if Empty
			//else Recurse
			//
	
	public ID3Tree buildTree(DataSet d){
		ID3Tree tree = new ID3Tree();
		ID3Node root = new ID3Node("root",d);
		
		
		
		
		return tree;
	}
	
	public ID3Node splitOnBest(ID3Node node){
	//	node.getBestAttribute(node.getDataSet())
		return null;
	}
}
