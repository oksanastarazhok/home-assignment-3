package nominator;

import award.Award;
import nominee.Nominee;

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
        }
    }


}


