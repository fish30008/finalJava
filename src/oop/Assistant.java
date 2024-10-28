package oop;

import java.util.List;
import java.util.ArrayList;

public class Assistant {

    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist() {
       for(int j = 0; j < assignedDisplays.size()-1; j++) {
        for (int i = j+1; i < assignedDisplays.size(); i++) {
            Display currentDisplay = assignedDisplays.get(j);
            Display nextDisplay = assignedDisplays.get(i);
            currentDisplay.compareWithMonitor(nextDisplay);
        }
    }}

    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("Thanks for purchase = " + d.getModel() + ", give tips for " + this.assistantName);
            return d;
        }else{ System.out.println("display sold"); return null;}
    }
}
