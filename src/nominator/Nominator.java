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

    private final int constantAwardQuantityLimit;
    private String name;
    private boolean noLimitAmt;
    private boolean noLimitQnt;
    private int nominatorAwardQuantityLimit;
    private double nominatorAwardAmountLimit;


    public Nominator(String name) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }


    public Nominator(String name, int nominatorAwardQuantityLimit, double nominatorAwardAmountLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
        this.constantAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    /**
     * This method is used to give a nomination to nominee. At first it checks whether both nominee and nominator have no amount
     * and quantity limits. Then nominee limits are checked, after that we check nominator limits.
     *
     * @param awardInstance   Award object
     * @param nomineeInstance Nominee object
     */
    public void nominate(Award awardInstance, Nominee nomineeInstance) {
        System.out.println("Nominee: " + nomineeInstance.getName());

        if (noLimitAmt && noLimitQnt && nomineeInstance.isNoLimitAmt() && nomineeInstance.isNoLimitQnt()) {

            nomineeInstance.receiveAward(awardInstance);
        } else if (noLimitAmt && noLimitQnt) {
            if (nomineeInstance.getNomineeAwardQuantityLimit() > 0) {
                if (nomineeInstance.getNomineeAwardAmountLimit() >= awardInstance.getValue()) {
                    nomineeInstance.receiveAward(awardInstance);
                    nomineeInstance.setNomineeAwardQuantityLimit(nomineeInstance.getNomineeAwardQuantityLimit() - 1);
                    nomineeInstance.setNomineeAwardAmountLimit(nomineeInstance.getNomineeAwardAmountLimit() - awardInstance.getValue());
                } else {
                    limitReached("nomineeAmountLimit", nomineeInstance.getName(), nomineeInstance.getConstantAwardQuantityLimit() - nomineeInstance.getNomineeAwardQuantityLimit());
                }
            } else {
                limitReached("nomineeQuantityLimit", nomineeInstance.getName(), nomineeInstance.getConstantAwardQuantityLimit() - nomineeInstance.getNomineeAwardQuantityLimit());
            }
        } else if (nomineeInstance.isNoLimitAmt() && nomineeInstance.isNoLimitQnt()) {
            if (nominatorAwardQuantityLimit > 0) {
                if (nominatorAwardAmountLimit >= awardInstance.getValue()) {
                    nomineeInstance.receiveAward(awardInstance);
                    nominatorAwardQuantityLimit -= 1;
                    nominatorAwardAmountLimit -= awardInstance.getValue();
                } else {
                    limitReached("nominatorAmountLimit", name, constantAwardQuantityLimit - nominatorAwardQuantityLimit);
                }
            } else {
                limitReached("nominatorQuantityLimit", name, constantAwardQuantityLimit - nominatorAwardQuantityLimit);
            }
        } else {
            if (nominatorAwardQuantityLimit > 0) {
                if (nominatorAwardAmountLimit >= awardInstance.getValue()) {
                    if (nomineeInstance.getNomineeAwardQuantityLimit() > 0) {
                        if (nomineeInstance.getNomineeAwardAmountLimit() >= awardInstance.getValue()) {
                            nomineeInstance.receiveAward(awardInstance);
                            nominatorAwardQuantityLimit -= 1;
                            nominatorAwardAmountLimit -= awardInstance.getValue();
                            nomineeInstance.setNomineeAwardQuantityLimit(nomineeInstance.getNomineeAwardQuantityLimit() - 1);
                            nomineeInstance.setNomineeAwardAmountLimit(nomineeInstance.getNomineeAwardAmountLimit() - awardInstance.getValue());
                        } else {
                            limitReached("nomineeAmountLimit", nomineeInstance.getName(), nomineeInstance.getConstantAwardQuantityLimit() - nomineeInstance.getNomineeAwardQuantityLimit());
                        }
                    } else {
                        limitReached("nomineeQuantityLimit", nomineeInstance.getName(), nomineeInstance.getConstantAwardQuantityLimit() - nomineeInstance.getNomineeAwardQuantityLimit());
                    }
                } else {
                    limitReached("nominatorAmountLimit", name, constantAwardQuantityLimit - nominatorAwardQuantityLimit);
                }
            } else {
                limitReached("nominatorQuantityLimit", name, constantAwardQuantityLimit - nominatorAwardQuantityLimit);
            }
        }
    }

    /**
     * This method is used to print a name of person who reached the limit, type of limit (award value or award amount),
     * number of awards received before limit.
     *
     * @param limit                 string received from {@nominate}method
     * @param name                  could be nominee or nominator's name
     * @param awardCountBeforeLimit number of awards received before limit
     */
    private static void limitReached(String limit, String name, int awardCountBeforeLimit) {
        switch (limit) {
            case "nomineeAmountLimit":
                System.out.println("Amount limit was reached for nominee: " + name + ". Award count before limit: " + awardCountBeforeLimit);
                break;
            case "nomineeQuantityLimit":
                System.out.println("Quantity limit was reached for nominee: " + name + ". Award count before limit: " + awardCountBeforeLimit);
                break;
            case "nominatorAmountLimit":
                System.out.println("Amount limit was reached for nominator: " + name + ". Award count before limit: " + awardCountBeforeLimit);
                break;
            case "nominatorQuantityLimit":
                System.out.println("Quantity limit was reached for nominator: " + name + ". Award count before limit: " + awardCountBeforeLimit);
                break;
            default:
                System.out.println("Apparently limit was reached.");
        }
    }

    public void nominateTeam(Award awardInstance, List<Nominee> team) {

        int i = 0;
        int max_i = team.size();

        while (nominatorAwardAmountLimit >= awardInstance.getValue()) {

            if (i >= max_i) {
                i = 0;
            }
            team.get(i).receiveAward(awardInstance);
            nominatorAwardAmountLimit -= awardInstance.getValue();
            i++;

        }


    }
}
