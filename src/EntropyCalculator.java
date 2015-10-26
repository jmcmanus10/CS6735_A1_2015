import java.util.ArrayList;

public class EntropyCalculator {
	public EntropyCalculator(){
		
	}

	public double calculateEntrpoy(DataSet d){
		
	ArrayList<ParityCounter> pM = d.buildParityMatrix(d,d.getcIndex());
	double entropy =0;
	
	for(ParityCounter p:pM){
		
		System.out.println("name:"+p.getArrtibuteValue()+" count:"+p.getCount());
		System.out.println("d.getData().size():" +d.getData().size());
		double x = ((double)(p.getCount()))/((double)(d.getData().size()));
		double y = (Math.log(((double)p.getCount())/((double)(d.getData().size())))/(Math.log(2)));
		double z = -1;
		System.out.println("x:"+x+"y:"+y+"z:"+z);
		
		entropy =(x*y*z)+entropy;
		//System.out.println("in the counter"+entropy);
		
	}
	
		return entropy;
	}
	
	public double predictEntropy(DataSet d, int attribute){
		
		ArrayList<String> attributeValues = d.getAttributeValueList().get(attribute);
		ArrayList<DataSet> splitSet = new ArrayList<DataSet>();
		double predictedEntropy=0;
		for (String s: attributeValues){
			DataSet dS = new DataSet();
			dS.setcIndex(d.getcIndex());
			splitSet.add(dS);
		}
		
		for(DataInstance dI: d.getData()){
			for(int i=0;i<attributeValues.size();i++){
				if(dI.getData().get(attribute).equals(attributeValues.get(i))){
					splitSet.get(i).getData().add(dI);
				}
			}
		}
		
		for(DataSet ds:splitSet){
			ds.setAttributeValueList(ds.createAttributeValueList(ds));
		//	predictedEntropy += (ds.getData().size()/d.getData().size())*(this.calculateEntrpoy(ds));
			
			double a =(double)(ds.getData().size())/(double)(d.getData().size());
			System.out.println("ds.getData().size():"+ds.getData().size()+" d.getData().size():"+d.getData().size()+ " a:"+a);
			
			double b = (this.calculateEntrpoy(ds));
			System.out.println("b:"+b);
			
			predictedEntropy += a*b;
		}
		//split the data set into smaller datasets and then get the parity martrix for those sets.
		//then calculate the entropy for those sets
		
		//ArrayList<ArrayList<ParityCounter>> counterTable = new ArrayList<ArrayList<ParityCounter>>();
		//int[][] counterTable = new int[d.getAttributeValueList().get(attribute)size()][d.getAttributeValueList().get(d.getcIndex())];
		
		return predictedEntropy;
	}
	
	public double predictInformationGain(DataSet d, int attribute){
		return this.calculateEntrpoy(d)-this.predictEntropy(d, attribute);
		
	}
	
	
}
