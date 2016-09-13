/*
 * Main.java - an example test class, showsing the expected usage of the classes to be implemented.
 */
public class Main
{
    public static void main(String [] args)
    {
        IssueHandler handler = new IssueController();
        Issue issue1 = handler.createFeatureRequest("user1", "Feature Title", "This is the first feature", 1);
        Issue issue2 = handler.createBug("user2", "Bug Title", "This is the first bug", "Here are some steps to reproduce this bug...", "Version 1.0");
        Issue issue3 = handler.createBug("user2", "Bug Title 2", "This is the second bug", "Here are some steps to reproduce this bug...", "Version 1.0");
        Issue issue4 = handler.createBug("user2", "Bug Title 3", "This is the third bug", "Here are some steps to reproduce this bug...", "Version 1.0");
     
        issue1.addComment("User 1", "This is my first comment");
        issue1.addComment("User 2", "This is another comment");
        issue2.addComment("User 1","I also have a comment about this issue");
        
        handler.printIssues();
    }
}