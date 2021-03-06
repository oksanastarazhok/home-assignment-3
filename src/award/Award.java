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
     *
     * @param value award value
     * @param type  award type
     * @param id    award id
     */
    public Award(int value, String type, int id) {
        this(value);
        this.type = type;
        this.id = id;
    }

    /**
     * This method is used to print awards of particular type.
     *
     * @param myAwards List with awards
     * @param type     Award type
     */
    public static void pintAwards(List<Award> myAwards, String type) {
        System.out.println("\nBelow you can see awards' ids that have type <" + type + ">:");
        for (Award award : myAwards) {
            if (award.getType().equals(type)) {
                System.out.println(award.getId());
            }
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

    /**
     * This method is my implementation of equals method.
     *
     * @param o object for comparison
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Award award = (Award) o;

        if (value != award.value) return false;
        if (id != award.id) return false;
        return type.equals(award.type);
    }

    /**
     * This method is my implementation of hashCode method.
     *
     * @return id of Award object
     */
    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + type.hashCode();
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Award{" +
                "value=" + value +
                ", soli=" + soli +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
