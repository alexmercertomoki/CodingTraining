package p3;


import java.util.*;


public class BackPack {
private ArrayList contents;
public String owner;

public BackPack(String owner) {
	this.owner = owner;
	contents = new ArrayList();
}

public void add(Object o) {
	contents.add(o);
}

private class BackpackIterator implements Iterator {
	private Iterator contentsIterator = contents.iterator();

public boolean hasNext() {
	return contentsIterator.hasNext();
}
public Object next() {
	return contentsIterator.next();
	}
    public void remove() {}
}

BackpackIterator iterator()  {
     return new BackpackIterator();
   }
}

//eHeeapeepeeey Hoeleiedeeayes!