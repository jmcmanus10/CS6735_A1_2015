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

		//cleanedData.printData();

		return cleanedData;
	}

	//takes the highest appearing number and lowest appearing number and divides the range into 10 buckets which are assigned as attributes
	public DataSet discretizeContinousNumberColumnDumb10(DataSet d, int column){
		DataSet discretizedData = d;



		return discretizedData;
	}

	public DataSet removeColumn(DataSet d, int column){
		DataSet clippedDataSet = new DataSet();
		int clippedCIndex=0;

		if(d.getcIndex()==column){
			clippedCIndex = 0;
		}else {
			if(d.getcIndex()<column){
				clippedCIndex = d.getcIndex();
			}else{
				if(d.getcIndex()>column){
					clippedCIndex=d.getcIndex()-1;
				}
			}

		}


		for(DataInstance dI:d.getData()){
			ArrayList<String> clippedData = new ArrayList<String>();
			for(int i =0; i <d.getData().get(0).getData().size();i++){
				if(i!=column){
					clippedData.add(dI.getData().get(i));
				}else{

				}
			}
			DataInstance clippedDI = new DataInstance(clippedData, clippedCIndex);
			clippedDataSet.getData().add(clippedDI);
		}

		clippedDataSet.setAttributeValueList(clippedDataSet.createAttributeValueList(clippedDataSet));

		//clippedDataSet.printData();
		return clippedDataSet;
	}
}
