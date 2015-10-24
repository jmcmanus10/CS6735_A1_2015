import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ID3Node<String>{
	private String name;
	private ArrayList<DataInstance> dataSet;
	private ID3Node<String> parent;
	private List<ID3Node<String>> children;

	public ID3Node(String name, ArrayList<DataInstance> dset){
		this.name=name;
		this.dataSet=dset;
		this.children = new LinkedList<ID3Node<String>>();
	}

	//don't know if it'll work
	public void addChild(ID3Node<String> child){
		this.children.add(child);
	}








	//Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DataInstance> getDataSet() {
		return dataSet;
	}

	public void setDataSet(ArrayList<DataInstance> dataSet) {
		this.dataSet = dataSet;
	}

	public ID3Node<String> getParent() {
		return parent;
	}

	public void setParent(ID3Node<String> parent) {
		this.parent = parent;
	}

	public List<ID3Node<String>> getChildren() {
		return children;
	}

	public void setChildren(List<ID3Node<String>> children) {
		this.children = children;
	}



}
