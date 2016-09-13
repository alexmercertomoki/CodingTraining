
public class Bug extends Issue{
	// speacial attributes for bugs 
	private String reproductionSteps; 
	private String versionSeen;
	
	//getters and setters 
	public String getReproductionSteps() {
		return reproductionSteps;
	}
	public void setReproductionSteps(String reproductionSteps) {
		this.reproductionSteps = reproductionSteps;
	}
	public String getVersionSeen() {
		return versionSeen;
	}
	public void setVersionSeen(String versionSeen) {
		this.versionSeen = versionSeen;
	}
	
	//overriding tosring method to get the information printed
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String  printOut= "Bug Issue:\n"+super.toString()+"Reproduction Steps:"+this.reproductionSteps+"\nVersionSeen:"+this.versionSeen+"\nComments:\n" + this.commentInfo();
		return printOut;
	}
}
