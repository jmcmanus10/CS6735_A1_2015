import java.util.ArrayList;

public class DataSanitizer {
	
	public DataSanitizer(){
		
	}
	
	public DataSet unknownsToMostcommon(DataSet d){
		DataSet cleanedData =  d;
		ArrayList<String> mostCommon = new ArrayList<String>();
		
		//find the most common
		for(int i=0;i<cleanedData.getAttributeValueList().size();i++){
			ArrayList<ParityCounter>pM = cleanedData.buildParityMatrix(cleanedData, i);
			int most = 0;
			String biggest ="";
					for(ParityCounter x:pM){	
						if (x.getCount()>most){
							most =x.getCount();
							biggest = x.getArrtibuteValue();
						//	System.out.println(biggest+":"+ most);
						}
					}
					mostCommon.add(biggest);
					//cleanedData.printParityMatrix(pM);
					//System.out.println("---------------");
		}
		
		
		
		
		for(DataInstance dI:cleanedData.getData()){
			for(int i =0; i<dI.getData().size();i++){
				if(dI.getData().get(i).equals("?")){
					//System.out.println("replacing ? with"+ mostCommon.get(i));
					dI.getData().set(i, mostCommon.get(i));
				}
			}
		}
		
		cleanedData.printData();
		
		return cleanedData;
	}

	//takes the highest appearing number and lowest appearing number and devids the range into 10 buckets which are assigned as attributes
public DataSet discretizeContinousNumberColumnDumb10(DataSet d, int column){
		DataSet discretizedData = d;
		
		
		
	return discretizedData;
	}	
}
