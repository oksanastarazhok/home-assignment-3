package award;

/**
 * Award object for a nomination
 */
public class Award {

    static {
        System.out.println("An instance of Award class was initialized");
    }

    private final int value;
    /**
     * Standard of Living Index.
     * Standard of living refers to the level of wealth, comfort, material goods and necessities available to a certain
     * socioeconomic class in a certain geographic area, usually a country.
     */
    private double soli;

    /**
     * Constructor for award object WITHOUT soli
     * @param value award value
     */
    public Award(int value) {
        this.value = value;
    }

    /**
     * Constructor for award object with soli
     *
     * @param value award value
     * @param soli  Standard of Living Index
     */
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
