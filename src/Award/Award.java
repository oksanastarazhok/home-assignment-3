package Award;

public class Award {

    static {
        System.out.println("An instance of Award class was initialized");
    }

    private final int value;
    private double soli;


    public Award(int value) {
        this.value = value;
    }

    public Award(int value, double soli) {
        this.value = value;
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }


    public double getSoli() {
        return soli;
    }

}
