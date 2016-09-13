import java.util.ArrayList;
import java.util.Iterator;

public class Issue {
	// common attributes for all issues bugs or Feature request 
	private String user;
	private String title;
	private String description;
	private ArrayList<Comments> com = new ArrayList<Comments>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	//adding comment method is to generate a comment and add to the List of comments
	public void addComment(String user, String message) {

		// TODO Auto-generated method stub
		Comments c = new Comments();
		c.setUser(user);
		c.setMessage(message);
		com.add(c);

	}

	// overriding tostring method to get printing info easier 
	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return "UserName:"+user + "\nTitle:" + title + "\nDescription:" + description + "\n";
				
	}
	
	// to get the information from comments list in a String format
	public String commentInfo() {
		StringBuilder sbr = new StringBuilder();
		Iterator<Comments> itr = com.iterator();

		while (itr.hasNext()) {
			sbr.append(itr.next().toString());
			sbr.append("\n");
		}

		return sbr.toString();

	}

}
