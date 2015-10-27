import java.util.ArrayList;
public class ID3Main {

	public static void main(String[] args) {
		DataSet d = new DataSet();
		//String s ="./data/play.data";
		String s ="./data/mushroom.data";
		d.setcIndex(0);
		d.loadData(s);
		
		ID3Node root= new ID3Node("root",d);
		ArrayList<Integer> i = new ArrayList<Integer>();
		for(int j =0; j<d.getData().get(0).getData().size();j++){
			if(j!=d.getcIndex()){
				Integer k = new Integer(j);
				i.add(k);
				System.out.println(k);
			}
		}
		ID3TreeBuilder tb = new ID3TreeBuilder();
		tb.buildTree(root,i);
		
		ID3Catagorizer cat = new ID3Catagorizer();
		
		for(DataInstance dI: d.getData()){
			if(cat.Catagorize(dI, root).equals(dI.getData().get(d.getcIndex()))){
			//System.out.println(cat.Catagorize(dI, root));
				System.out.println("+");
			}else{
				System.out.println("-");
			}
				
		}
		
		
//		System.out.println("made it through!");
//		root.getDataSet().printData();
//		System.out.println(root.getSplitOn());
//		for(ID3Node child:root.getChildren()){
//			System.out.println("------child 1-------------");
//			System.out.println(child.getSplitOn());
//			//child.getDataSet().printData();
//			for(ID3Node child2:child.getChildren()){
//			System.out.println("------child 2-------------");
//			System.out.println(child2.getSplitOn());
//			//child2.getDataSet().printData();
//			for(ID3Node child3:child2.getChildren()){
//				System.out.println("------child 3-------------");
//				System.out.println(child3.getSplitOn());
//				//child3.getDataSet().printData();
//				}
//			}
//		}
		/*d.printData();
		System.out.println("-------------------");
		d.printAttributeValueList(d.createAttributeValueList(d));
		System.out.println("-------------------");
		d.printParityMatrix(d.buildParityMatrix(d, 4));
		System.out.println("-------------------");
		DataSanitizer ds = new DataSanitizer();
		//d=ds.discretizeContinousNumberColumnDumb10(d, 0);
		//d.printData();
		//ds.unknownsToMostcommon(d);
		//ds.removeColumn(d, 1);
		ID3Node root = new ID3Node("root",d);
		ArrayList<Integer> i = new ArrayList<Integer>();
		for(int j =0; j<d.getData().get(0).getData().size();j++){
			if(j!=d.getcIndex()){
				Integer k = new Integer(j);
				i.add(k);
			}
		}
		root.splitNode(root.getBestAttribute(d, i));
		
		//root.splitNode(0);
		
		for(ID3Node child: root.getChildren()){
			child.getDataSet().printData();
			System.out.println("-------------------");
		}
		EntropyCalculator ec = new EntropyCalculator();
		//System.out.println(ec.calculateEntrpoy(d));
		//System.out.println(ec.predictInformationGain(d, 1));


	}
	//main recursive method of ID3
	public void Split(ID3Node node){
		//Find best attribute call it A
		//For each Value of A
		//Create child node
		//Create data subset
		//Stop if Pure
		//Stop if Empty
		//else Recurse
		//
	}




	*//**	public ArrayList<String[]> buildParityMatrix(DataSet d){
		for(DataInstance dI:d.getData()){

		}
	} 
	 **//*

	public int findBestAttribute(){
		return 0;
	}
	public boolean isEmpty(DataSet set){
		return false;
	}
	public boolean isPure(DataSet set, int attribute){
		return false;
	}
	// to calculate the information gained by splitting a node on the attribute at the given index 
	public float calculateInformationGain(int attribute){

		return 0;
	}

	//
	public void evaluate(DataSet testdata){
*/
	}

}
