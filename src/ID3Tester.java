import java.util.ArrayList;

public class ID3Tester {

	ID3Tester(){
		
	}
	
	public double testID3(DataSet d,int cIndex){
		//DataSet d = new DataSet();
		//String s ="./data/play.data";
	   //String s ="./data/play.data";
		//String s =filename;
		//d.setcIndex(cIndex);
		//d.loadData(s);
		
		DataSetNinja dsn = new DataSetNinja();
		DataSetGroup myDSG = dsn.kFoldWithTest(d, 5);
		DataSet dTrain = myDSG.getTrainingData();
		DataSet dTest = myDSG.getTestData();
		
		ID3Node root= new ID3Node("root",dTrain);
		ArrayList<Integer> i = new ArrayList<Integer>();
		for(int j =0; j<dTrain.getData().get(0).getData().size();j++){
			if(j!=dTrain.getcIndex()){
				Integer k = new Integer(j);
				i.add(k);
				//System.out.println(k);
			}
		}
		ID3TreeBuilder tb = new ID3TreeBuilder();
		tb.buildTree(root,i);
		
		ID3Categorizer cat = new ID3Categorizer();
		
		double right=0;
		double wrong=0;
		for(DataInstance dI: dTest.getData()){
			if(cat.Categorize(dI, root).equals(dI.getData().get(d.getcIndex()))){
				right++;
				//System.out.println("+");
			}else{
			//	System.out.println("-");
				wrong++;
			}
				
		}
		
		return right/(right+wrong);
	}
}
