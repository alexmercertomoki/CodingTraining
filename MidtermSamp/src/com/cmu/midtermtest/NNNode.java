package com.cmu.midtermtest;

public class NNNode {
    private NNNode lChild;
    private NNNode rChild;
    private NameNumber contents;
    public NNNode(NameNumber n) {
        contents = n;
    }
    public void insert(NameNumber n) {
        if (n.getLastName().compareTo(contents.getLastName()) < 0)
            if (lChild != null)
            	lChild.insert(n);
        	else
                lChild = new NNNode(n);
        else
            if (rChild != null)
            	rChild.insert(n);
        	else
                rChild = new NNNode(n);
     }
  
    public String findNumber(String lName) { 
    	if (lName.compareTo(contents.getLastName()) < 0)     
    		if (lChild != null)         
    			return lChild.findNumber(lName);       
    		else              
    			return new String("Name not found");     
    	else if (lName.equals(contents.getLastName()))        
    		return contents.getTelNumber();  
    	else if (lName.compareTo(contents.getLastName()) > 0)       
    		if (rChild != null)            	
    			return rChild.findNumber(lName);      
    		else             
    			return new String("Name not found");   
    	else       
    		return new String("Name not found");
    	}
}


