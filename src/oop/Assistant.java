package oop;


import java.util.List;
import java.util.ArrayList;

public class Assistant extends Display {

    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String model, float ppi, int width, int height, String assistantName) {
        super(model, ppi, width, height);
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d){
        assignedDisplays.add(d);
    };
    public void assist(){
        for(int i = 0; i < assignedDisplays.size() - 1; i++){
            Display currentDisplay = assignedDisplays.get(i);
            Display nextDisplay = assignedDisplays.get(i + 1);
            currentDisplay.compareWithMonitor(nextDisplay);
        }
    };
    public Display buyDisplay(Display d){
        if (assignedDisplays.remove(d)) { // Remove and return the display if present
        return d;
    }
        return null;};
    
}

//give me complete lesson about inheritance and polymorphism in java