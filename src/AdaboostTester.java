import java.util.ArrayList;

public class AdaboostTester {
	ArrayList<Double> dIWeights = new ArrayList<Double>();

	public AdaboostTester(){

	}

	public double TestAdaBoost(DataSet d,int cIndex,int numTrees){

		DataSetNinja dsn = new DataSetNinja();
		DataSetGroup myDSG = dsn.kFoldWithTest(d, 5);
		DataSet dTrain = myDSG.getTrainingData();
		DataSet dTest = myDSG.getTestData();
		//	ArrayList<Double> dIWeights = new ArrayList<Double>();

		ID3StumpBuilder stumpy = new ID3StumpBuilder();
		ID3Forest myForest = new ID3Forest();

		for(DataInstance di:dTrain.getData()){
			dIWeights.add(1.0/(double)(dTrain.getData().size()));
		}
		//this.printWeights(dIWeights);
		for(int j =0; j<numTrees;j++){
			ID3Node bestStump =null;
			int bestAttribute;
			double leastWeightedError =1.1;
			boolean first =true;
			double alpha =0.0;
			for(int i =0; i<d.getAttributeValueList().size();i++){
				if(i!=dTrain.getcIndex()){
					double wE =0.0;
					ID3Node node = stumpy.buildStump(dTrain, i);
					wE = getWeightedError(dTrain, node, dIWeights);

					if(first){
						bestStump = node;
						bestAttribute = i;
						leastWeightedError = wE;
						first =false;
					}
					if(wE<=leastWeightedError){
						bestStump = node;
						bestAttribute = i;
						leastWeightedError = wE;
					}

					//System.out.println("the weighted error for stump "+i+" is "+ wE);
					//System.out.println("built my #"+i+" stump!");
				}
			}
			alpha = calculateAlpha(leastWeightedError);
			myForest.addTree(bestStump, alpha);
			updateDIWeights(dTrain,bestStump,leastWeightedError);
		}
		double right=0;
		double wrong=0;
		for(DataInstance dI: dTest.getData()){
			//System.out.println("myForest.categorize(dI) ="+myForest.categorize(dI));
			
			if(myForest.categorize(dI).equals(dI.getData().get(d.getcIndex()))){
				right++;
				//System.out.println("+");
			}else{
			//	System.out.println("-");
				wrong++;
			}
				
		}
		//System.out.println(""+right/(right+wrong));
		return right/(right+wrong);
	}

	public void updateDIWeights(DataSet d, ID3Node bestStump, double leastWeightedError){
		ID3Categorizer cat = new ID3Categorizer();

		for(int i=0;i<dIWeights.size();i++){
			String s = cat.Categorize(d.getData().get(i),bestStump);
			String x = d.getData().get(i).getData().get(d.getcIndex());

			if(s.equals(x)){
				double pos = 0.5*(dIWeights.get(i)/(1-leastWeightedError));
				dIWeights.set(i,pos);
			}else{
				double neg = 0.5*(dIWeights.get(i)/(leastWeightedError));
				
				dIWeights.set(i,neg);

			}
		}
		//printWeights(dIWeights);
	}

	public double calculateAlpha(double leastWeightedError){
		double alpha =0.0;
		alpha = 0.5*(Math.log(1-leastWeightedError/leastWeightedError));

		return alpha;
	}



	public double getWeightedError(DataSet d,ID3Node root, ArrayList<Double> dIWeights){
		double weightedError= 0.0;
		ID3Categorizer cat = new ID3Categorizer();

		for(int i=0;i<dIWeights.size();i++){
			String s = cat.Categorize(d.getData().get(i),root);
			String x = d.getData().get(i).getData().get(d.getcIndex());
			//System.out.println(x);
			//	System.out.println(s);
			if(s.equals(x)){
				//Needs to do something with the adjusting the weights
				//	System.out.println("++");
			}else{
				//	System.out.println("--");
				weightedError = weightedError+dIWeights.get(i);
			}
		}

		return weightedError;
	}

	public void printWeights(ArrayList<Double> dIWeights){
		int count=0;
		double total = 0.0;
		for(Double dIW:dIWeights){
			count++;
			System.out.println("For the "+count+" example dIW = "+dIW);
			total= total+dIW;
		}
		System.out.println("Total is = "+total );
	}

}
