import java.util.ArrayList;

public class ID3Catagorizer {
	public ID3Catagorizer(){
		
	}
	
	public String Catagorize(DataInstance dI, ID3Node node){
		if(node.getSplitOn()!=-1){
			ArrayList<ID3Node> children = node.getChildren();
			
			for(ID3Node child:children){
				if(child.getName().equals(dI.getData().get(node.getSplitOn()))){
					return Catagorize(dI,child);
				}
			}
			
		}
			
		return node.getCatagory();
	}
}
