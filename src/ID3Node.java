import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ID3Node{
	private String name;
	private DataSet dataSet;
	private ID3Node parent;
	private List<ID3Node> children;
	private int splitOn = -1; //default to -1 when not split

	public ID3Node(){
		this.name = "";
		this.dataSet = new DataSet();
		this.children = new LinkedList<ID3Node>();
	}
	
	public ID3Node(String name, DataSet dset){
		this.name=name;
		this.dataSet=dset;
		this.children = new LinkedList<ID3Node>();
	}
	

	
	public void splitNode(int attribute){
		ArrayList<String> attributeValues = this.dataSet.getAttributeValueList().get(attribute);
		this.setSplitOn(attribute);
		
		for (String s: attributeValues){
			ID3Node childNode = new ID3Node();
			this.addChild(childNode);
			childNode.setParent(this);
			childNode.setName(s);
		}
		
		for(DataInstance dI: dataSet.getData()){
			for(int i=0;i<attributeValues.size();i++){
				if(dI.getData().get(attribute).equals(attributeValues.get(i))){
					this.children.get(i).getDataSet().getData().add(dI);
				}
			}
		}
		
	}
	
	public int getBestAttribute(DataSet d){
		int best = 0;
		//Entropy calculation in here;
		return best;
	}
	public void addChild(ID3Node child){
		this.children.add(child);
	}

	//Getters and Setters
	public int getSplitOn() {
		return splitOn;
	}

	public void setSplitOn(int splitOn) {
		this.splitOn = splitOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public ID3Node getParent() {
		return parent;
	}

	public void setParent(ID3Node parent) {
		this.parent = parent;
	}

	public List<ID3Node> getChildren() {
		return children;
	}

	public void setChildren(List<ID3Node> children) {
		this.children = children;
	}



}
