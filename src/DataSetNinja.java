import java.util.Random;
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
	
	public DataSet createRandomizedDataSet(DataSet d){
		DataSet rd = new DataSet();
		int i=0;
		Random rand = new Random();
		while(rd.getData().size() < d.getData().size())
		{
			if(i>=d.getData().size()){
				i=i-d.getData().size();
			}
			
			int r =rand.nextInt(2);
			if (r==0){
				i++;
			//	System.out.println("r="+r);
			}else{
			//	System.out.println("r="+r);
				rd.getData().add(d.getData().get(i));
				i++;
			}
			
		}
		
		rd.setAttributeValueList(rd.createAttributeValueList(rd));
		rd.setcIndex(d.getcIndex());
		return rd;
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
