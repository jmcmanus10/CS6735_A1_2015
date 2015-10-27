
public class DataSetGroup {
	DataSet trainingData;
	DataSet validationData;
	DataSet testData;
	
	public DataSetGroup(){
		trainingData = new DataSet();
		testData = new DataSet();
		validationData = new DataSet();
	}
	
	public DataSetGroup (DataSet training,DataSet test){
		this.trainingData =training;
		this.testData = test;
	}
	
	public DataSetGroup(DataSet training,DataSet test,DataSet validation){
		this.trainingData =training;
		this.testData = test;
		this.validationData=validation;
	}

	public void setCIndexDataSetGroup(int cIndex){
		trainingData.setcIndex(cIndex);
		validationData.setcIndex(cIndex);
		testData.setcIndex(cIndex);
	}
	
	
	public DataSet getTrainingData() {
		return trainingData;
	}

	public void setTrainingData(DataSet trainingData) {
		this.trainingData = trainingData;
	}

	public DataSet getValidationData() {
		return validationData;
	}

	public void setValidationData(DataSet validationData) {
		this.validationData = validationData;
	}

	public DataSet getTestData() {
		return testData;
	}

	public void setTestData(DataSet testData) {
		this.testData = testData;
	}
	
	
}
