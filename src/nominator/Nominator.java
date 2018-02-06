package nominator;

import person.Person;
import person.Type;

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
     * Constructor for Nominator object WITHOUT limits
     *
     * @param name name name of Nominator
     */
    private Nominator(String name) {
        super(name);
        this.isManager = true;
    }

    public Nominator(String name, Type role) {
        this(name);
        super.role = role;
    }

    /**
     * Constructor for Nominator object WITH limits
     *
     * @param name               name name of Nominator
     * @param awardQuantityLimit Shows how much awards Nominator can give
     * @param awardAmountLimit   Shows the max sum that Nominator can give
     */
    public Nominator(String name, int awardQuantityLimit, double awardAmountLimit) {
        super(name, awardQuantityLimit, awardAmountLimit);
        this.isManager = true;
    }

    @Override
    public void login() {
        System.out.printf("%s logged in.%n", Nominator.this.getName());
        ;
    }


}
