package nominee;

import award.Award;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Nominee object for receiving an award
 */
public class Nominee {

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
    private final List<Award> award1ListWithoutSoli = new ArrayList<Award>();
    /**
     * Shows how much awards Nominee can receive
     */
    private int nomineeAwardQuantityLimit;
    /**
     * Shows the max sum that Nominee can receive
     */
    private double nomineeAwardAmountLimit;
    /**
     * If it equals 0, than nominee has no limits, otherwise it equals nomineeAwardQuantityLimit
     */
    private final int constantAwardQuantityLimit;

    public List<Award> getAward1ListWithoutSoli() {
        return Collections.unmodifiableList(award1ListWithoutSoli);
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

    /**
     * Constructor for a nominee object without limits
     *
     * @param name name of Nominee
     */
    public Nominee(String name) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }

    public String getName() {
        return name;
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


    public boolean isNoLimitAmt() {
        return noLimitAmt;
    }

    public boolean isNoLimitQnt() {
        return noLimitQnt;
    }

    public int getConstantAwardQuantityLimit() {
        return constantAwardQuantityLimit;
    }
}


