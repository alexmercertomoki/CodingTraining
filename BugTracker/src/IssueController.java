
import java.util.*;

public class IssueController implements IssueHandler{
	
	//implementation for creating bug issue or feature issue
	@Override
	public Issue createBug(String user, String title, String description,
			String reproductionSteps, String versionSeen) {
		// TODO Auto-generated method stub
	    Bug bug=new Bug();
	  	bug.setUser(user); 
	  	bug.setTitle(title);
	  	bug.setDescription(description);
	  	bug.setReproductionSteps(reproductionSteps);
	    bug.setVersionSeen(versionSeen);
	    issues.add(bug);
		return bug;
	}

	@Override
	public Issue createFeatureRequest(String user, String title,
			String description, int importance) {
		// TODO Auto-generated method stub
		//
		FeatureRequest fq=new FeatureRequest();
		fq.setUser(user);
		fq.setTitle(title);
		fq.setDescription(description);
		fq.setImportance(importance);
		issues.add(fq);
		return fq;
	}
	

	//printing the issues out
	@Override
	public void printIssues() {
		
		// java util iterator  to get all issues in the list 
		Iterator<Issue> it= issues.iterator(); 
		Issue curr = null;
		while (it.hasNext()) {
			curr = it.next();
			System.out.println(curr);
		}
	}
	
}
