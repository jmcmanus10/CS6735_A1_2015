import java.util.ArrayList;

public class ID3RandomTester {

	ID3RandomTester(){
		
	}
	
	public double testID3(DataSet d,int cIndex,int numTrees,int randAttributeListSize){
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
		
		ID3Forest myForest = buildForest(dTrain, numTrees, randAttributeListSize);
		double right=0;
		double wrong=0;
		for(DataInstance dI: dTest.getData()){
			if(myForest.categorize(dI).equals(dI.getData().get(d.getcIndex()))){
				right++;
			//	System.out.println("+");
			}else{
			//	System.out.println("-");
				wrong++;
			}
				
		}
		
		return right/(right+wrong);
		
		
		
	}
	
	public ID3Forest buildForest(DataSet dTrain, int numTrees, int randAttributeListSize){
		ID3Forest myForest = new ID3Forest();
		for(int i=0;i<numTrees;i++){
			
			ID3Node root= new ID3Node("root",dTrain);
			ArrayList<Integer> possibleAttributesList = new ArrayList<Integer>();
			for(int j =0; j<dTrain.getData().get(0).getData().size();j++){
				if(j!=dTrain.getcIndex()){
					Integer k = new Integer(j);
					possibleAttributesList.add(k);
					//System.out.println(k);
				}
			}
			ID3RandomTreeBuilder rtb = new ID3RandomTreeBuilder();
			//ID3TreeBuilder tb = new ID3TreeBuilder();
			//tb.buildTree(root,i);
			rtb.buildTree(root,possibleAttributesList,randAttributeListSize);
			
			ID3Categorizer cat = new ID3Categorizer();
			
			double right=0;
			double wrong=0;
			for(DataInstance dI: dTrain.getData()){
				if(cat.Categorize(dI, root).equals(dI.getData().get(dTrain.getcIndex()))){
					right++;
					//System.out.println("+");
				}else{
				//	System.out.println("-");
					wrong++;
				}
					
			}
			
			Double weight = right/(right+wrong);
			myForest.addTree(root, weight);
			
			
		}
		return myForest;
	}
}
