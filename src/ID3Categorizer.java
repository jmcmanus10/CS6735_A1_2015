import java.util.ArrayList;

public class ID3Categorizer {
	public ID3Categorizer(){
		
	}
	
	public String Categorize(DataInstance dI, ID3Node node){
		if(node.getSplitOn()!=-1){
			ArrayList<ID3Node> children = node.getChildren();
			
			for(ID3Node child:children){
				if(child.getName().equals(dI.getData().get(node.getSplitOn()))){
					return Categorize(dI,child);
				}
			}
			
		}
			
		return node.getCategory();
	}
}
