import java.util.ArrayList;
public class ID3Main {

	public static void main(String[] args) {
		double numTimes=10.0;
//	Mushroom	
		String s ="./data/mushroom.data";
		int cIndex = 0;
		DataSanitizer cleaner = new DataSanitizer();
		DataSet d = new DataSet();
		d.setcIndex(cIndex);
	//	d.loadData(s);
		d = cleaner.unknownsToMostcommon(d);
		

		
		double id3Total = 0.0;
		double rdTotal=0.0;
//		System.out.println("For the Mushroom Data Set:");
//		for(int i=0;i<numTimes;i++){
//			ID3Tester id3Tester = new ID3Tester();
//			 ID3RandomTester rdTester = new ID3RandomTester();
//			d.shuffleMe();
//			double id3Result = id3Tester.testID3(d, cIndex);
//			double rdResult = rdTester.testID3(d, cIndex,30, 5);
//			System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult);
//			id3Total = id3Total + id3Result;
//			rdTotal = rdTotal+ rdResult;
//			
//			}
//		System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes);
////Letter-Recognition
//		s ="./data/letter-recognition.data";
//		cIndex = 0;
//		d = new DataSet();
//		d.setcIndex(cIndex);
//		d.loadData(s);
//		
//		//no cleaning needed
//		
//		id3Total = 0.0;
//		rdTotal=0.0;
//		
//		System.out.println("For the Letter-Recognition Data Set:");
//		for(int i=0;i<numTimes;i++){
//			ID3Tester id3Tester = new ID3Tester();
//			 ID3RandomTester rdTester = new ID3RandomTester();
//			d.shuffleMe();
//			double id3Result = id3Tester.testID3(d, cIndex);
//			double rdResult = rdTester.testID3(d, cIndex,30, 5);
//			System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult);
//			id3Total = id3Total + id3Result;
//			rdTotal = rdTotal+ rdResult;
//			
//			}
//		System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes);

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
		
		System.out.println("For the Ecoli Data Set:");
		for(int i=0;i<numTimes;i++){
			ID3Tester id3Tester = new ID3Tester();
			 ID3RandomTester rdTester = new ID3RandomTester();
			d.shuffleMe();
			double id3Result = id3Tester.testID3(d, cIndex);
			double rdResult = rdTester.testID3(d, cIndex,30, 5);
			System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult);
			id3Total = id3Total + id3Result;
			rdTotal = rdTotal+ rdResult;
			//System.out.println(tester.testID3(d, cIndex, 5));
			//System.out.println("made it through "+i);
			}
		System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes);

//		//Breast-Cancer-Wisconsin
//				s ="./data/breast-cancer-wisconsin.data";
//				cIndex = 10;
//				d = new DataSet();
//				d.setcIndex(cIndex);
//				d.loadData(s);
//				
//				d = cleaner.removeColumn(d, 0);
//				
//				
//				id3Total = 0.0;
//				rdTotal=0.0;
//				
//				System.out.println("For the Letter-Recognition Data Set:");
//				for(int i=0;i<numTimes;i++){
//					ID3Tester id3Tester = new ID3Tester();
//					 ID3RandomTester rdTester = new ID3RandomTester();
//					d.shuffleMe();
//					double id3Result = id3Tester.testID3(d, cIndex);
//					double rdResult = rdTester.testID3(d, cIndex,30, 5);
//					System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult);
//					id3Total = id3Total + id3Result;
//					rdTotal = rdTotal+ rdResult;
//					
//					}
//				System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes);
//
//				
//				//Car
//				s ="./data/car.data";
//				cIndex = 6;
//				d = new DataSet();
//				d.setcIndex(cIndex);
//				d.loadData(s);
//				
//				//no cleaning needed
//				
//				
//				id3Total = 0.0;
//				rdTotal=0.0;
//				
//				System.out.println("For the Letter-Recognition Data Set:");
//				for(int i=0;i<numTimes;i++){
//					ID3Tester id3Tester = new ID3Tester();
//					 ID3RandomTester rdTester = new ID3RandomTester();
//					d.shuffleMe();
//					double id3Result = id3Tester.testID3(d, cIndex);
//					double rdResult = rdTester.testID3(d, cIndex,30, 5);
//					System.out.println("in round "+i+" ID3 got: "+id3Result+" Random Forest got: "+ rdResult);
//					id3Total = id3Total + id3Result;
//					rdTotal = rdTotal+ rdResult;
//					
//					}
//				System.out.println("The averages are: ID3: "+ id3Total/numTimes +" Random Forest: "+rdTotal/numTimes);
//				
		
	}

}
