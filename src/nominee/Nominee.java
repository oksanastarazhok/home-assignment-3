package nominee;

import award.Award;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

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

    /**
     * Method checks if an award has soli. If there is a soli, it counts how much it was changed in in percentage terms and prints
     * the value. If there is no soli, it prints the award initial value.
     *
     * @param award1Instance award object
     */
    public void receiveAward(Award award1Instance) {

        if (award1Instance.getSoli() > 0) {

            double percentage = (award1Instance.getSoli() * 100) - 100;
            if (percentage < 0) {
                System.out.println("Award value decreased on " + abs(percentage) + "%.");
            } else {
                System.out.println("Award value increased on " + percentage + "%.");
            }
        } else {
            System.out.println("Award value: " + award1Instance.getValue() + " Award value wasn't converted.");
            award1ListWithoutSoli.add(award1Instance);

        }
    }

    /**
     * Method counts the value for awards with soli according to the following formula:
     * quantity = ((Z^2*(P)*(1-P))/(C^2)) / (1 + ((((Z^2*(P)*(1-P ))/(C^2))-1)/population))
     * where
     * randomDecimal equals a random decimal i.e. 5% = 0.05
     * population equals number of received awards which has no soli
     * randomWholeNumber  a random whole number i.e. 3
     * awardValueForFormula equals award value without soli
     */
    public void countQuantity() {
        for (int i = 0; i < award1ListWithoutSoli.size(); i++) {
            double randomDecimal = Math.random();
            int population = award1ListWithoutSoli.size();
            int randomWholeNumber = (int) (Math.random() * 10);
            double awardValueForFormula = award1ListWithoutSoli.get(i).getValue();

            double denominator1 = Math.pow(randomDecimal, 2.0);
            double numerator1 = ((Math.pow(randomWholeNumber, 2.0) * awardValueForFormula * (1 - awardValueForFormula)));
            double numeratorForFormula = numerator1 / denominator1;
            double denominatorForFormula = (1 + (((numerator1 / denominator1) - 1) / population));
            double formula = numeratorForFormula / denominatorForFormula;
            quantity.add(i, formula);

        }
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


