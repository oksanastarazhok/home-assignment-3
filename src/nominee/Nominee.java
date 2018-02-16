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
     * Constructor for a Nominee object without limits.
     *
     * @param name Name of Nominee
     * @param role Role could be NOMINEE or NOMINATOR
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
        super.role = Type.NOMINEE;
    }

    /**
     * This method is used to show override in action. It just prints a string with the information about logged in person.
     */
    @Override
    public void login() {
        System.out.printf("%s logged in.%n", Nominee.this.getName());

    }

    /**
     * This method is used to show override in action. It prints information about Nominee.
     */
    public void printInfo() {
        System.out.println("Nominee " + this.getName() + " can receive awards. Currently there are " +
                this.getAward1ListWithoutSoli().size() + " awards available for redemption.");
    }

    public List<Award> getAward1ListWithoutSoli() {
        return (award1ListWithoutSoli);
    }

    public List<Double> getQuantity() {
        return quantity;
    }
}



