package nominee;

import award.Award;
import person.Person;
import person.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Nominee object for receiving an award
 */
public class Nominee extends Person {

    static {
        System.out.println("An instance of Nominee class was initialized");
    }


    /**
     * Contains a list of values counted according to the formula for the awards without soli
     */
    private final List<Double> quantity = new ArrayList<Double>();
    /**
     * Contains a List of Award object for each Nominee
     */
    private List<Award> award1ListWithoutSoli = new ArrayList<Award>();

    /**
     * Constructor for a Nominee object without limits
     *
     * @param name name of Nominee
     */
    public Nominee(String name, Type role) {
        super(name);
        super.role = role;
    }


    /**
     * Constructor for Nominee object with limits
     *
     * @param name               name of Nominee
     * @param awardQuantityLimit Shows how much awards Nominee can receive
     * @param awardAmountLimit   Shows the max sum that Nominee can receive
     */
    public Nominee(String name, int awardQuantityLimit, double awardAmountLimit) {
        super(name, awardQuantityLimit, awardAmountLimit);
    }

    @Override
    public void login() {
        System.out.printf("%s logged in.%n", Nominee.this.getName());

    }

    public boolean isLimitReached(int awardQuantityLimit, double awardAmountLimit, int currentQuantityLimit, double currentAmountLimit) {
        if (currentQuantityLimit >= awardQuantityLimit || currentAmountLimit >= awardAmountLimit) {
            return true;
        } else {
            return false;
        }
    }

    public List<Award> getAward1ListWithoutSoli() {
        return (award1ListWithoutSoli);
    }

    public List<Double> getQuantity() {
        return quantity;
    }
}


