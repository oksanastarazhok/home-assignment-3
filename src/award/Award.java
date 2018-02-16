package award;

import java.util.List;

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
    private String type;
    private int id;


    /**
     * Constructor for award object WITHOUT soli
     *
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

    /**
     * Constructor for awards that have id and type
     * @param value award value
     * @param type award type
     * @param id award id
     */
    public Award(int value, String type, int id) {
        this(value);
        this.type = type;
        this.id = id;
    }


    public void pintAwards(List<Award> myAwards) {
        for (Award award:myAwards) {
            System.out.println(award);
        }
            
        }





    public int getValue() {
        return value;
    }

    public double getSoli() {
        return soli;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
