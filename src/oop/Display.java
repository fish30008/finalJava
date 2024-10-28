package oop;

public class Display {
    private String model;
    private int height;
    private int width;
    private float ppi;

     public Display(String model, float ppi, int width, int height) {
        this.model = model;
        this.ppi = ppi;
        this.width = width;
        this.height = height;
    }

    public String getModel() {
        return model;
    }


    public float getPpi() {
        return ppi;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public void compareSize(Display m){
        String result1 = (this.height > m.getHeight()) ? m.getModel() + " have less height "
                + this.getModel()  : (this.height == m.getHeight()) ? "   "+ m.getModel() + " have same height "
                + this.getModel() :m.getModel() + " have bigger height " + this.getModel();
        String result2;
        if(this.width <  m.getWidth()){ result2 = m.getModel() + " have bigger width "
                + this.getModel();} else if (this.width == m.getWidth()){ result2 = m.getModel() + " have same width " + this.width;}
        else { result2 = m.getModel() + " have same width ";}
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(" ------------- ");

    }
    public void compareSharpness(Display m){
        String result = (this.ppi < m.getPpi()) ?  "   "+ m.getModel() + " have bigger sharpness "
                + this.getModel()  : (this.ppi == m.getPpi()) ? "   "+ m.getModel() + " have same sharpness "
                + this.getModel() : "   "+ m.getModel() + " have less sharpness " + this.getModel();


        System.out.println(result);
        System.out.println(" ------------- ");
    }
    public void compareWithMonitor(Display m){
        this.compareSize(m);
        System.out.println(" ");
        this.compareSharpness(m);
    }}