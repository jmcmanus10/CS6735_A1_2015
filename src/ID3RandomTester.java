import java.util.ArrayList;

public class ID3RandomTester {

	ID3RandomTester(){
		
	}
	
	public double testID3(DataSet d,int cIndex,int n){
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
		
		dTrain = dsn.createRandomizedDataSet(dTrain);
		
		ID3Node root= new ID3Node("root",dTrain);
		ArrayList<Integer> i = new ArrayList<Integer>();
		for(int j =0; j<dTrain.getData().get(0).getData().size();j++){
			if(j!=dTrain.getcIndex()){
				Integer k = new Integer(j);
				i.add(k);
				//System.out.println(k);
			}
		}
		ID3RandomTreeBuilder rtb = new ID3RandomTreeBuilder();
		//ID3TreeBuilder tb = new ID3TreeBuilder();
		//tb.buildTree(root,i);
		rtb.buildTree(root,i,n);
		
		ID3Catagorizer cat = new ID3Catagorizer();
		
		double right=0;
		double wrong=0;
		for(DataInstance dI: dTest.getData()){
			if(cat.Catagorize(dI, root).equals(dI.getData().get(d.getcIndex()))){
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
