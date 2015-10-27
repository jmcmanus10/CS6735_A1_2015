import java.util.concurrent.ThreadLocalRandom;

public class DataSetNinja {
	
	public DataSetNinja(){
		
	}
	
	public DataSetGroup kFoldWithTest(DataSet d, int k){
		DataSetGroup myDataSetGroup = new DataSetGroup();
		myDataSetGroup.setCIndexDataSetGroup(d.getcIndex());
		int foldSize = d.getData().size()/k;
		int remainder = d.getData().size()%k;
		for(int i=0;i<foldSize+remainder;i++){
			myDataSetGroup.getTestData().getData().add((d.getData().get(i)));
		}
		for(int j= foldSize+remainder; j<d.getData().size();j++){
			myDataSetGroup.getTrainingData().getData().add((d.getData().get(j)));
		}
			
		return myDataSetGroup;
	}
//	public DataSet randomizedDataSet(DataSet d){
//		DataSet rD = new DataSet();
//		rD.setcIndex(d.getcIndex());
//		
//		while(rD.getData().size()!=d.getData().size()){
//			
//		
//		ThreadLocalRandom.current().nextInt(0, 1 + 1);	
//		return rD;
//		}
//	}

}
