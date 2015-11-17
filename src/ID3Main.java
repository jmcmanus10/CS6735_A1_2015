import java.util.ArrayList;
public class ID3Main {

	public static void main(String[] args) {
		double numTimes=10.0;
		int adaboostLearners =20;
		int randomTrees = 20;
		int randomAttributeSize =3;
		////Play
		//		String s ="./data/play.data";
		//		int cIndex = 4;
		//		DataSanitizer cleaner = new DataSanitizer();
		//		DataSet d = new DataSet();
		//		d.setcIndex(cIndex);
		//		d.loadData(s);




		//	Mushroom	
		String s ="./data/mushroom.data";
		int cIndex = 0;
		DataSanitizer cleaner = new DataSanitizer();
		DataSet d = new DataSet();
		d.setcIndex(cIndex);
		d.loadData(s);
		d = cleaner.unknownsToMostcommon(d);




		double id3Total = 0.0;
		double rdTotal=0.0;
		double adaTotal =0.0;
		System.out.println("============================================================");
		System.out.println("For the Mushroom Data Set:");
		for(int i=0;i<numTimes;i++){
			ID3Tester id3Tester = new ID3Tester();
			ID3RandomTester rdTester = new ID3RandomTester();
			AdaboostTester adaboostTester = new AdaboostTester();
			d.shuffleMe();
			double id3Result = id3Tester.testID3(d, cIndex);
			double rdResult = rdTester.testID3(d, cIndex,randomTrees, randomAttributeSize);
			double adaResult = adaboostTester.TestAdaBoost(d, cIndex,adaboostLearners);
			//System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult +" Adaboost got: "+adaResult);
			System.out.println(""+id3Result+","+rdResult+","+adaResult);
			id3Total = id3Total + id3Result;
			rdTotal = rdTotal+ rdResult;
			adaTotal =  adaTotal+adaResult;
		}
		//System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes +" Adaboost: "+adaTotal/numTimes);
		System.out.println(""+ id3Total/numTimes +","+rdTotal/numTimes +","+adaTotal/numTimes);
		//Letter-Recognition
		s ="./data/letter-recognition.data";
		cIndex = 0;
		d = new DataSet();
		d.setcIndex(cIndex);
		d.loadData(s);

		//no cleaning needed

		id3Total = 0.0;
		rdTotal=0.0;
		adaTotal = 0.0;
		System.out.println("============================================================");
		System.out.println("For the Letter-Recognition Data Set:");
		for(int i=0;i<numTimes;i++){
			ID3Tester id3Tester = new ID3Tester();
			ID3RandomTester rdTester = new ID3RandomTester();
			AdaboostTester adaboostTester = new AdaboostTester();
			d.shuffleMe();
			double id3Result = id3Tester.testID3(d, cIndex);
			double rdResult = rdTester.testID3(d, cIndex,randomTrees, randomAttributeSize);
			double adaResult = adaboostTester.TestAdaBoost(d, cIndex,adaboostLearners);
			//System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult +" Adaboost got: "+adaResult);
			System.out.println(""+id3Result+","+rdResult+","+adaResult);
			id3Total = id3Total + id3Result;
			rdTotal = rdTotal+ rdResult;
			adaTotal =  adaTotal+adaResult;
		}
		//System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes +" Adaboost: "+adaTotal/numTimes);
		System.out.println(""+ id3Total/numTimes +","+rdTotal/numTimes +","+adaTotal/numTimes);
		//
		//		Ecoli
		s ="./data/ecolicomma.data";
		cIndex = 8;
		d = new DataSet();	
		d.setcIndex(cIndex);
		d.loadData(s);
		d = cleaner.removeColumn(d, 0);
		for(int c =0;c<7;c++){
			d =cleaner.discretizeContinousNumberColumnDumb10(d, c);
		}
		id3Total = 0.0;
		rdTotal=0.0;
		adaTotal = 0.0;
		System.out.println("============================================================");
		System.out.println("For the Ecoli Data Set:");
		for(int i=0;i<numTimes;i++){
			ID3Tester id3Tester = new ID3Tester();
			ID3RandomTester rdTester = new ID3RandomTester();
			AdaboostTester adaboostTester = new AdaboostTester();
			d.shuffleMe();
			double id3Result = id3Tester.testID3(d, cIndex);
			double rdResult = rdTester.testID3(d, cIndex,randomTrees, randomAttributeSize);
			double adaResult = adaboostTester.TestAdaBoost(d, cIndex,adaboostLearners);
			//System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult +" Adaboost got: "+adaResult);
			System.out.println(""+id3Result+","+rdResult+","+adaResult);
			id3Total = id3Total + id3Result;
			rdTotal = rdTotal+ rdResult;
			adaTotal =  adaTotal+adaResult;
		}
		//System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes +" Adaboost: "+adaTotal/numTimes);
		System.out.println(""+ id3Total/numTimes +","+rdTotal/numTimes +","+adaTotal/numTimes);
		//
		//		  Breast-Cancer-Wisconsin
		s ="./data/breast-cancer-wisconsin.data";
		cIndex = 10;
		d = new DataSet();
		d.setcIndex(cIndex);
		d.loadData(s);

		d = cleaner.removeColumn(d, 0);


		id3Total = 0.0;
		rdTotal=0.0;
		adaTotal = 0.0;
		System.out.println("============================================================");
		System.out.println("Breast-Cancer-Wisconsin Data Set:");
		for(int i=0;i<numTimes;i++){
			ID3Tester id3Tester = new ID3Tester();
			ID3RandomTester rdTester = new ID3RandomTester();
			AdaboostTester adaboostTester = new AdaboostTester();
			d.shuffleMe();
			double id3Result = id3Tester.testID3(d, cIndex);
			double rdResult = rdTester.testID3(d, cIndex,randomTrees, randomAttributeSize);
			double adaResult = adaboostTester.TestAdaBoost(d, cIndex,adaboostLearners);
			//System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult +" Adaboost got: "+adaResult);
			System.out.println(""+id3Result+","+rdResult+","+adaResult);
			id3Total = id3Total + id3Result;
			rdTotal = rdTotal+ rdResult;
			adaTotal =  adaTotal+adaResult;
		}
		//System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes +" Adaboost: "+adaTotal/numTimes);
		System.out.println(""+ id3Total/numTimes +","+rdTotal/numTimes +","+adaTotal/numTimes);
		//
		//				
		//Car
		s ="./data/car.data";
		cIndex = 6;
		d = new DataSet();
		d.setcIndex(cIndex);
		d.loadData(s);

		//no cleaning needed


		id3Total = 0.0;
		rdTotal=0.0;
		adaTotal = 0.0;
		System.out.println("============================================================");
		System.out.println("Car Data Set:");
		for(int i=0;i<numTimes;i++){
			ID3Tester id3Tester = new ID3Tester();
			ID3RandomTester rdTester = new ID3RandomTester();
			AdaboostTester adaboostTester = new AdaboostTester();
			d.shuffleMe();
			double id3Result = id3Tester.testID3(d, cIndex);
			double rdResult = rdTester.testID3(d, cIndex,randomTrees, randomAttributeSize);
			double adaResult = adaboostTester.TestAdaBoost(d, cIndex,adaboostLearners);
			//System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult +" Adaboost got: "+adaResult);
			System.out.println(""+id3Result+","+rdResult+","+adaResult);
			id3Total = id3Total + id3Result;
			rdTotal = rdTotal+ rdResult;
			adaTotal =  adaTotal+adaResult;
		}
		//System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes +" Adaboost: "+adaTotal/numTimes);
		System.out.println(""+ id3Total/numTimes +","+rdTotal/numTimes +","+adaTotal/numTimes);
		//				

	}

}
