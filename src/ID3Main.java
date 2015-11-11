import java.util.ArrayList;
public class ID3Main {

	public static void main(String[] args) {
		
//		
		String s ="./data/play.data";
		int cIndex = 4;
		
//		DataSanitizer cleaner = new DataSanitizer();
//		
		DataSet d = new DataSet();
		d.setcIndex(cIndex);
		d.loadData(s);
		
//		DataSetNinja dsn = new DataSetNinja();
//		DataSet rd = dsn.createRandomizedDataSet(d);
		
		
		
//		d=cleaner.removeColumn(d, 0);
//		
//		for(int i=0;i<100;i++){
//		 ID3Tester tester = new ID3Tester();
//		 d.shuffleMe();
//		System.out.println(tester.testID3(d, cIndex));
//		}
//		
		for(int i=0;i<100;i++){
			 ID3RandomTester tester = new ID3RandomTester();
			d.shuffleMe();
			System.out.println(tester.testID3(d, cIndex, 1));
			//System.out.println("made it through "+i);
			}
		
		
//		String s ="./data/play.data";
//		d.setcIndex(4);
//		d.loadData(s);
//		
//		ID3Node root= new ID3Node("root",d);
//		ArrayList<Integer> i = new ArrayList<Integer>();
//		for(int j =0; j<d.getData().get(0).getData().size();j++){
//			if(j!=d.getcIndex()){
//				Integer k = new Integer(j);
//				i.add(k);
//				System.out.println(k);
//			}
//		}
//		ID3TreeBuilder tb = new ID3TreeBuilder();
//		tb.buildTree(root,i);
//		
//		ID3Catagorizer cat = new ID3Catagorizer();
//		
//		for(DataInstance dI: d.getData()){
//			if(cat.Catagorize(dI, root).equals(dI.getData().get(d.getcIndex()))){
//			//System.out.println(cat.Catagorize(dI, root));
//				System.out.println("+");
//			}else{
//				System.out.println("-");
//			}
//				
//		}
		
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

*/
	}

}
