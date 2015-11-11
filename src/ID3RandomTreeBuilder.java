import java.util.ArrayList;
import java.util.Random;

public class ID3RandomTreeBuilder {
	
	public ID3RandomTreeBuilder(){
		
	}

	
	//Find best attribute call it A
			//For each Value of A
			//Create child node
			//Create data subset
			//Stop if Pure
			//Stop if Empty
			//else Recurse
			//
	
	public ID3Node buildTree(ID3Node node,ArrayList<Integer>possibleAttributes, int n){
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
		//System.out.println("before Random Attribute List");
		ArrayList<Integer> randomAttributeList= createRandomPossibleAttributeList(possibleAttributes, n);
		int a = node.getBestAttribute(d,randomAttributeList);
		System.out.println("split on a"+a);
		node.setSplitOn(a);
		node.splitNode(a);
		for(int j=0; j< possibleAttributes.size();j++){
			if(possibleAttributes.get(j)==a){
				possibleAttributes.remove(j);
			}
		}
		for(ID3Node child:node.getChildren()){
		//	System.out.println("recursing on childern");
			buildTree(child,possibleAttributes,n);
		}
				
		return node;
		}else{
		return node;
		}
	}
	
	public ArrayList<Integer> createRandomPossibleAttributeList(ArrayList<Integer> possibleAttributes, int n){
		ArrayList<Integer> nl = possibleAttributes;
		Random rand = new Random();
		if(n<possibleAttributes.size()&&n>0){
		while(nl.size()>n){
			
		int r = rand.nextInt(nl.size());
		
		nl.remove(r);
		}
		}
		
		return nl;
	}

}
