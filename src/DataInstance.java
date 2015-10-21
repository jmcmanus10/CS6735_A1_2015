//pretty happy this this so far Oct.20,2015

public class DataInstance {
private String classifacation;
private int classifactionIndex;
private String[] data;

public DataInstance(String[] data,int cIndex){
	this.data = data;
	this.classifactionIndex = cIndex;
	this.classifacation = this.data[classifactionIndex];
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

public String[] getData() {
	return data;
}

public void setData(String[] data) {
	this.data = data;
}


}
