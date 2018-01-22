package person;

public class Person {


    /**
     * If it equals 0, than Person has no limits, otherwise it equals awardQuantityLimit
     */
    private final int constantAwardQuantityLimit;
    private String name;
    /**
     * if true, shows that Person can give/receive unlimited sum of money, otherwise amount is restricted
     */
    private boolean noLimitAmt;
    /**
     * if true, shows that Person can receive/give unlimited number of awards, otherwise number is restricted
     */
    private boolean noLimitQnt;
    /**
     * Shows how much awards Nominator can receive
     */
    private int awardQuantityLimit;


    /**
     * Shows the max sum that Nominator can receive
     */
    private double awardAmountLimit;

    /**
     * Constructor for a Nominator object without limits
     *
     * @param name name of Nominator
     * @param noLimitAmt
     * @param noLimitQnt
     * @param constantAwardQuantityLimit
     */
    public Person(String name, boolean noLimitAmt, boolean noLimitQnt, int constantAwardQuantityLimit) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }

    /**
     * Constructor for Nominator object with limits
     *
     * @param name                        name of Nominator
     * @param awardQuantityLimit Shows how much awards Nominator can receive
     * @param awardAmountLimit            Shows the max sum that Nominator can receive
     */
    public Person(String name, int awardQuantityLimit, double awardAmountLimit, int constantAwardQuantityLimit) {
        this.name = name;
        this.awardAmountLimit = awardQuantityLimit;
        this.awardAmountLimit = awardAmountLimit;
        this.constantAwardQuantityLimit = awardQuantityLimit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNominatorAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.awardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public double getAwardAmountLimit() {
        return awardAmountLimit;
    }

    public void setAwardAmountLimit(double awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }

    public int getConstantAwardQuantityLimit() {
        return constantAwardQuantityLimit;
    }


}
