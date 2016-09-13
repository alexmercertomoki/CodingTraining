package aabateryexample;

import java.util.*;

public class Box {
    ArrayList moreStuff = new ArrayList();
    public String toString() {
        String s = new String("Box");
		s  += moreStuff;
        return s;
    }
}
