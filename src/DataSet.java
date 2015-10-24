import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DataSet{
	private ArrayList<DataInstance> data;
	int cIndex =0; // Column index of categorization	
	public DataSet(ArrayList<DataInstance> data){
		this.data = data;
	}
	
	public DataSet(){
		
	}
	
	//** creates a new shuffled data set using collections.shuffle
	public ArrayList<ArrayList<String>> createAttributeValueList(DataSet d){
		ArrayList<ArrayList<String>> attributeValueList = new ArrayList<ArrayList<String>>();
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
	public DataSet shuffleMe(){
		ArrayList dataDeck = this.data;
		Collections.shuffle(dataDeck);
		DataSet shuffled = new DataSet(dataDeck);
		
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
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } 
		
				
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
	
}
