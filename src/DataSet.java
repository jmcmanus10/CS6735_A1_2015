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
