package deepcopyarray;


public class SimpleObject implements Cloneable {
    private int i;
    SimpleObject(int i) {
    	this.i = i;
    }
    public String toString() {
        String s = new String();
        s += "I'm a SimpleObject with i = " + i;
        s += " and address " + super.toString();  // object  ?? ??? ??
        return s;
    }
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println("SimpleClass can't clone.");
        }
        return o;
    }
}

