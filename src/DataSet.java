import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DataSet{
	private ArrayList<DataInstance> data;
	private int cIndex =0; // Column index of categorization
	private ArrayList<ArrayList<String>> attributeValueList= new ArrayList<ArrayList<String>>() ;

	public DataSet(ArrayList<DataInstance> data,int cIndex){
		this.data = data;
		this.cIndex = cIndex;
		attributeValueList=createAttributeValueList(this);
	}

	public DataSet(int cIndex){
		this.data = new ArrayList<DataInstance>();
		this.cIndex=cIndex;		
	}
	
	public DataSet(){
		this.data = new ArrayList<DataInstance>();
	}

	//** creates a new shuffled data set using collections.shuffle
	public ArrayList<ArrayList<String>> createAttributeValueList(DataSet d){
		ArrayList<ArrayList<String>> attributeValueList = new ArrayList<ArrayList<String>>();
//		System.out.println("tester");
//		System.out.println("dataSet size "+d.getData().toString());
//		System.out.println("after tester");
		for (int i=0; i<d.getData().get(0).getData().size();i++){
			ArrayList<String> al = new ArrayList<String>();
			attributeValueList.add(al);

		}
		for(DataInstance dI:d.getData()){
			//for(String s:dI.getData()){
			for (int i=0; i<dI.getData().size();i++){
				String s = dI.getData().get(i);
				//	System.out.println("first test" +attributeValueList.isEmpty());
				if(attributeValueList.get(i).isEmpty()){
					attributeValueList.get(i).add(s);
				}else{
					if(attributeValueList.get(i).contains(s)){

					}
					else{
						attributeValueList.get(i).add(s);
					}
				}
			}
		}

		return attributeValueList;
	}

	public void printAttributeValueList(ArrayList<ArrayList<String>> avl){
		for (ArrayList<String> A: avl){
			for(String s:A){
				System.out.print(s+" ");
			}
			System.out.println("");
		}
	}

	public ArrayList<ParityCounter> buildParityMatrix(DataSet d, int index){
		ArrayList<ParityCounter> pM = new ArrayList<ParityCounter>();
		if(this.attributeValueList.isEmpty()){
			this.attributeValueList = this.createAttributeValueList(d);
		}

		for(String av:this.attributeValueList.get(index)){
			ParityCounter p = new ParityCounter(av,0);
			pM.add(p);			
		}

		for(DataInstance dI:d.getData()){
			String s = dI.getData().get(index);
			for(ParityCounter x:pM){
				if(x.getArrtibuteValue().equals(s)){
					x.setCount(x.getCount()+1);
				}
			}
		}
		return pM;
	}

	public void printParityMatrix(ArrayList<ParityCounter> pm){
		for(ParityCounter pc:pm){
			System.out.println(pc.getArrtibuteValue()+" = "+pc.getCount());
		}

	}

	public DataSet shuffleMe(){
		ArrayList<DataInstance> dataDeck = this.data;
		Collections.shuffle(dataDeck);
		DataSet shuffled = new DataSet(dataDeck,this.cIndex);

		return shuffled;
	}
	

	public void printData(){
		for(DataInstance x:this.data){
			for(String s:x.getData()){
				System.out.print(s+" ");
			}
			System.out.println("");
		}
	}

	public void loadData(String fileName){
		this.data = new ArrayList<DataInstance>();
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			//  scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String s =scanner.next();
				String[] splitS = s.split("[,]");

				ArrayList<String> dI = new ArrayList<String>(Arrays.asList(splitS));
				DataInstance example = new DataInstance(dI,cIndex);
				this.data.add(example);
			}
			//  System.out.println("ended");
			scanner.close();
			attributeValueList=createAttributeValueList(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 


	}
	
	public boolean isPure(DataSet d){
		for(DataInstance dI:d.getData()){
			
			//System.out.println("d.getData().get(0).getData().get(cIndex):"+d.getData().get(0).getData().get(cIndex));
			//System.out.println("dI.getData().get(d.getcIndex():"+dI.getData().get(d.getcIndex()));
			if(!(d.getData().get(0).getData().get(cIndex).equals(dI.getData().get(d.getcIndex())))){
				
			//	System.out.println("this data set is not pure");
				return false;
			}
		}
		
		return true;
	}

	public String mostCommon(DataSet d, int index){
		ArrayList<ParityCounter>pM = d.buildParityMatrix(d, index);
		int most = 0;
		String biggest ="";
		for(ParityCounter x:pM){	
			if (x.getCount()>=most){
				most =x.getCount();
				biggest = x.getArrtibuteValue();
				//	System.out.println(biggest+":"+ most);
			}
		}
		return biggest;
	}
	
	public ArrayList<DataInstance> getData() {
		return data;
	}

	public void setData(ArrayList<DataInstance> data) {
		this.data = data;
	}

	public int getcIndex() {
		return cIndex;
	}

	public void setcIndex(int cIndex) {
		this.cIndex = cIndex;
	}

	public ArrayList<ArrayList<String>> getAttributeValueList() {
		return attributeValueList;
	}

	public void setAttributeValueList(ArrayList<ArrayList<String>> attributeValueList) {
		this.attributeValueList = attributeValueList;
	}



}
