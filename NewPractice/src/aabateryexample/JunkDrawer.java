package aabateryexample;

import java.util.ArrayList;

public class JunkDrawer {
    ArrayList contents = new ArrayList();
    public void fillDrawer() {
        contents.add(new RollOfRibbon());
        contents.add(new AABattery());
        contents.add(new NineVoltBattery());
        BoxOfPaperClips boxOfClips = new BoxOfPaperClips();
        for (int i = 0; i < 3; i++)
            boxOfClips.clips.add(new PaperClip(i));
        contents.add(boxOfClips);
        Box box = new Box();
        box.moreStuff.add(new AABattery());
        box.moreStuff.add(new BandAid());
        contents.add(box);
        contents.add(new AABattery());
    }
    public static void main(String[] args) {
        JunkDrawer kitchenDrawer = new JunkDrawer();
        kitchenDrawer.fillDrawer();
        System.out.println(kitchenDrawer.contents);
    }
}
