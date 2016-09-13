package cmu.home2test;

import java.util.*;

public class OperatorFactory {
	private Node[] currentOps;
	OperatorFactory (Node [] n){ 
				currentOps = n;
			}

			public Node getOperator(Random r) { 
				Node operator = currentOps[r.nextInt(4)];
		    	return (Node)operator.clone();
			}

			public int getNumOps() { 
				return currentOps.length;
			}

}

