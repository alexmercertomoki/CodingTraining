package aabateryexample;

import java.util.ArrayList;

public class BoxOfPaperClips {
    ArrayList clips = new ArrayList();
    public String toString() {
        String s = new String("BoxOfPaperClips");
        s  += clips;
        return s;
    }
}
