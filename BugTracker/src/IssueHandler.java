import java.util.List;
import java.util.ArrayList;

public interface IssueHandler 
{
    public List<Issue> issues = new ArrayList<Issue>();
    
    public Issue createBug(String user, String title, String description, String reproductionSteps, String versionSeen);
    
    public Issue createFeatureRequest(String user, String title, String description, int importance);
    
    public void printIssues();
    
    
}