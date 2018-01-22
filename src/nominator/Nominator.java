package nominator;

import person.Person;

/**
 * Nominator object for giving a nomination to nominee
 */
public class Nominator extends Person {

    static {
        System.out.println("An instance of Nominator class was initialized");
    }

    /**
     * Should be set to True to be able to give awards
     */
    private boolean isManager;


    /**
     *Constructor for Nominator object WITHOUT limits
     * @param name name name of Nominator
     * @param noLimitAmt if true, shows that Nominator can give unlimited sum of money, otherwise amount is restricted
     * @param noLimitQnt if true, shows that Nominator can give unlimited number of awards, otherwise number is restricted
     * @param constantAwardQuantityLimit it equals 0, Nominator has no limits
     */
    public Nominator(String name, boolean noLimitAmt, boolean noLimitQnt, int constantAwardQuantityLimit) {
        super(name, noLimitAmt, noLimitQnt, constantAwardQuantityLimit);
        isManager = true;
    }

    /**
     * Constructor for Nominator object WITH limits
     * @param name name name of Nominator
     * @param awardQuantityLimit Shows how much awards Nominator can give
     * @param awardAmountLimit Shows the max sum that Nominator can give
     * @param constantAwardQuantityLimit it equals awardQuantityLimit
     */
    public Nominator(String name, int awardQuantityLimit, double awardAmountLimit, int constantAwardQuantityLimit) {
        super(name, awardQuantityLimit, awardAmountLimit, constantAwardQuantityLimit);
        isManager = true;
    }


}
