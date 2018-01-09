package nominator;

import award.Award;
import nominee.Nominee;

import java.util.List;


/**
 * Nominator object for giving a nomination to nominee
 */
public class Nominator {

    static {
        System.out.println("An instance of Nominator class was initialized");
    }

    public int getConstantAwardQuantityLimit() {
        return constantAwardQuantityLimit;
    }

    /**
     * If it equals 0, than Nominator has no limits, otherwise it equals nominatorAwardQuantityLimit
     */
    private final int constantAwardQuantityLimit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * if true, shows that Nominator can receive unlimited sum of money, otherwise amount is restricted
     */
    private String name;
    /**
     * if true, shows that Nominator can receive unlimited sum of money, otherwise amount is restricted
     */
    public boolean noLimitAmt;
    /**
     * if true, shows that Nominator can receive unlimited number of awards, otherwise number is restricted
     */
    public boolean noLimitQnt;

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    /**
     * Shows how much awards Nominator can receive
     */
    private int nominatorAwardQuantityLimit;

    public double getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardAmountLimit(double nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    /**
     * Shows the max sum that Nominator can receive
     */
    private double nominatorAwardAmountLimit;

    /**
     * Constructor for a Nominator object without limits
     *
     * @param name name of Nominator
     */
    public Nominator(String name) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }

    /**
     * Constructor for Nominator object with limits
     *
     * @param name                        name of Nominator
     * @param nominatorAwardQuantityLimit Shows how much awards Nominator can receive
     * @param nominatorAwardAmountLimit   Shows the max sum that Nominator can receive
     */
    public Nominator(String name, int nominatorAwardQuantityLimit, double nominatorAwardAmountLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
        this.constantAwardQuantityLimit = nominatorAwardQuantityLimit;
    }






}
