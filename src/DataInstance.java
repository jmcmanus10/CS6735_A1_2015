//pretty happy with this so far Oct.20,2015
import java.util.ArrayList;

public class DataInstance {
private String classifacation;
private int classifactionIndex;
private ArrayList<String> data;

public DataInstance(ArrayList<String> data,int cIndex){
	this.data = data;
	this.classifactionIndex = cIndex;
	this.classifacation = this.data.get(classifactionIndex);
}




//setters and getters
public String getClassifacation() {
	return classifacation;
}

public void setClassifacation(String classifacation) {
	this.classifacation = classifacation;
}

public int getClassifactionIndex() {
	return classifactionIndex;
}

public void setClassifactionIndex(int classifactionIndex) {
	this.classifactionIndex = classifactionIndex;
}

public ArrayList<String> getData() {
	return data;
}

public void setData(ArrayList<String> data) {
	this.data = data;
}


}
