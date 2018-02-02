package person;

public abstract class Person {

    private String name;

    public Type role;

    /**
     * If it equals 0, than Person has no limits, otherwise it equals awardQuantityLimit
     */
    private final int constantAwardQuantityLimit;


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
     * Constructor for Person WITHOUT limits
     *
     * @param name name of Person
     */
    public Person(String name) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }



    /**
     * Constructor for Person WITH limits
     *
     * @param name               name of Person
     * @param awardQuantityLimit Shows how much awards Person can give/ receive
     * @param awardAmountLimit   Shows the max sum that Person can give/ receive
     */
    public Person(String name, int awardQuantityLimit, double awardAmountLimit) {
        this.name = name;
        this.awardAmountLimit = awardQuantityLimit;
        this.awardAmountLimit = awardAmountLimit;
        this.constantAwardQuantityLimit = awardQuantityLimit;
    }


    /**
     * This method is used to show override in action.
     */
    public void login(){
        System.out.println("This method should demonstrate override in action. This method wasn't overridden in Nominator Class.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    public void setAwardQuantityLimit(int awardQuantityLimit) {
        this.awardQuantityLimit = awardQuantityLimit;
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

    public boolean isNoLimitAmt() {
        return noLimitAmt;
    }

    public void setNoLimitAmt(boolean noLimitAmt) {
        this.noLimitAmt = noLimitAmt;
    }

    public boolean isNoLimitQnt() {
        return noLimitQnt;
    }

    public void setNoLimitQnt(boolean noLimitQnt) {
        this.noLimitQnt = noLimitQnt;
    }

}
