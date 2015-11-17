import java.util.ArrayList;

public class ID3StumpBuilder {
	
	public ID3StumpBuilder(){
		
	}
	
	public ID3Node buildStump(DataSet d,int splitAttribute){
		ID3Node node = new ID3Node("root",d);
		node.setSplitOn(splitAttribute);
		node.setCategory(d.mostCommon(d, d.getcIndex()));
		node.splitNode(splitAttribute);
		for(ID3Node child:node.getChildren()){
			if(child.getDataSet().getData().isEmpty()){
				System.out.println("parents most common");
			//	child.setCategory(child.getParent().getDataSet().mostCommon(child.getParent().getDataSet(), d.getcIndex()));
			}else{
				child.setCategory(child.getDataSet().mostCommon(child.getDataSet(), d.getcIndex()));
			//	System.out.println("childs most common");
			}
		}
		return node;
		}

}
