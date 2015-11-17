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
				if (x.getCount()>=most){
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
		double biggest= Double.parseDouble(d.getData().get(0).getData().get(column));
		double smallest= Double.parseDouble(d.getData().get(0).getData().get(column));
		double bucketSize =0;
				
		
		for(DataInstance dI:d.getData()){

				String s = dI.getData().get(column);
				double x = Double.parseDouble(s);
				
				biggest = Double.max(biggest, x);
				smallest = Double.min(smallest, x);
			//	System.out.println("s:"+s+" x:"+x+" biggest:"+biggest+" smallest:"+smallest);
				
		}
		//our data sets don't contain negative numbers so a simple subtraction will work here.
		bucketSize = (biggest-smallest)/10;
	//	System.out.println("BucketSize:"+bucketSize);
		
		for(DataInstance dI:d.getData()){
			String s = dI.getData().get(column);
			double x = Double.parseDouble(s);
			if(x<=bucketSize +smallest){
				dI.getData().set(column, "1");
			}else{
				if(x>bucketSize +smallest && x<=(2*bucketSize +smallest)){
					dI.getData().set(column, "2");
				}else{
					if(x>2*bucketSize +smallest && x<=(3*bucketSize +smallest)){
						dI.getData().set(column, "3");
					}else{
						if(x>3*bucketSize +smallest && x<=(4*bucketSize +smallest)){
							dI.getData().set(column, "4");
						}else{
							if(x>4*bucketSize +smallest && x<=(5*bucketSize +smallest)){
								dI.getData().set(column, "5");
							}else{
								if(x>5*bucketSize +smallest && x<=(6*bucketSize +smallest)){
									dI.getData().set(column, "6");
								}else{
									if(x>6*bucketSize +smallest && x<=(7*bucketSize +smallest)){
										dI.getData().set(column, "7");
									}else{
										if(x>7*bucketSize +smallest && x<=(8*bucketSize +smallest)){
											dI.getData().set(column, "8");
										}else{
											if(x>8*bucketSize +smallest && x<=(9*bucketSize +smallest)){
												dI.getData().set(column, "9");
											}else{
												if(x>9*bucketSize +smallest){
													dI.getData().set(column, "10");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		//d.printData();
		
		return d;
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
