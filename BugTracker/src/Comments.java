
public class Comments {
	//special  attributes for comments
	private String user;
	private String message;
	//getters and setters 
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//overriding to string method to get the info printed 
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.user+ "    "+this.message;
    }

}
