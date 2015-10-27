import java.util.ArrayList;

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
	
	public ID3Node buildTree(ID3Node node,ArrayList<Integer>possibleAttributes){
		DataSet d = node.getDataSet();
		
		if(!(node.getParent() == null && d.getData().isEmpty())){
		
		if(d.getData().isEmpty()){
			node.setCatagory(node.getParent().getDataSet().mostCommon(d, d.getcIndex()));
			//System.out.println("data set empty");
			return node;
		}
		if (d.isPure(d)){
			node.setCatagory(d.mostCommon(d, d.getcIndex()));
			//System.out.println("data set is pure");
			return node;
		}
		if(possibleAttributes.isEmpty()){
			node.setCatagory(d.mostCommon(d, d.getcIndex()));
		//	System.out.println("attributes are empty");
			return node;
		}
		node.setCatagory(d.mostCommon(d, d.getcIndex()));
		int a = node.getBestAttribute(d,possibleAttributes);
	//	System.out.println("split on a"+a);
		node.setSplitOn(a);
		node.splitNode(a);
		for(int j=0; j< possibleAttributes.size();j++){
			if(possibleAttributes.get(j)==a){
				possibleAttributes.remove(j);
			}
		}
		for(ID3Node child:node.getChildren()){
		//	System.out.println("recursing on childern");
			buildTree(child,possibleAttributes);
		}
				
		return node;
		}else{
		return node;
		}
	}

}
