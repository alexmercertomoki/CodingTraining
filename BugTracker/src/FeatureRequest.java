
public class FeatureRequest extends Issue{
	// special attribute for feature request  
	private int importance;
	
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FeatureRequest:\n"+super.toString()+"Priority:"+this.importance+"\nComments:\n" + this.commentInfo();
	}
}
