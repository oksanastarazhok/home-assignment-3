package nominee;

import award.Award;
import person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Nominee object for receiving an award
 */
public class Nominee extends Person {

    static {
        System.out.println("An instance of Nominee class was initialized");
    }

    private String name;
    /**
     * if true, shows that Nominee can receive unlimited sum of money, otherwise amount is restricted
     */
    private boolean noLimitAmt;
    /**
     * if true, shows that Nominee can receive unlimited number of awards, otherwise number is restricted
     */
    private boolean noLimitQnt;
    /**
     * Contains a list of values counted according to the formula for the awards without soli
     */
    private final List<Double> quantity = new ArrayList<Double>();
    /**
     * Contains a List of Award object for each Nominee
     */
    private List<Award> award1ListWithoutSoli = new ArrayList<Award>();
    /**
     * Shows how much awards Nominee can receive
     */
    private int nomineeAwardQuantityLimit; //rename and move to Person
    /**
     * Shows the max sum that Nominee can receive
     */
    private double nomineeAwardAmountLimit;//rename and move to Person
    /**
     * If it equals 0, than nominee has no limits, otherwise it equals nomineeAwardQuantityLimit
     */
    private final int constantAwardQuantityLimit;

    /**
     * Constructor for a Nominee object without limits
     *
     * @param name name of Nominee
     */
    public Nominee(String name) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }


    /**
     * Constructor for Nominee object with limits
     *
     * @param name                      name of Nominee
     * @param nomineeAwardQuantityLimit Shows how much awards Nominee can receive
     * @param nomineeAwardAmountLimit   Shows the max sum that Nominee can receive
     */
    public Nominee(String name, int nomineeAwardQuantityLimit, double nomineeAwardAmountLimit) {
        this.name = name;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
        this.constantAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public String getName() {
        return name;
    }

    public boolean isNoLimitAmt() {
        return noLimitAmt;
    }

    public boolean isNoLimitQnt() {
        return noLimitQnt;
    }

    public int getConstantAwardQuantityLimit() {
        return constantAwardQuantityLimit;
    }

    public List<Award> getAward1ListWithoutSoli() {
        return (award1ListWithoutSoli);
    }

    public double getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public void setNomineeAwardAmountLimit(double tempAmt) {
        this.nomineeAwardAmountLimit = tempAmt;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public void setNomineeAwardQuantityLimit(int tempQnt) {
        this.nomineeAwardQuantityLimit = tempQnt;
    }

    public List<Double> getQuantity() {
        return quantity;
    }
}


