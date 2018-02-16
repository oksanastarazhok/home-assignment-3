package nomination;

import award.Award;
import exceptions.NegativeSoliException;
import exceptions.NegativeValueAwardException;
import nominator.Nominator;
import nominee.Nominee;
import person.Person;

import java.util.List;

import static java.lang.Math.abs;

public class NominationHelper {

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

    /**
     * Method checks if an award has soli. If there is a soli, it counts how much it was changed in in percentage terms
     * and prints the value. If there is no soli, it prints the award initial value.
     * @param award1Instance  Award object
     * @param nomineeInstance Nominee object
     */
    private void receiveAward(Award award1Instance, Nominee nomineeInstance) throws NegativeSoliException {

        if (award1Instance.getSoli() > 0) {

            double percentage = (award1Instance.getSoli() * 100) - 100;
            if (percentage < 0) {
                System.out.println("Award value decreased on " + abs(percentage) + "%.");
            } else {
                System.out.println("Award value increased on " + percentage + "%.");
            }
        }else if (award1Instance.getSoli() < 0){
            throw new NegativeSoliException("You can't give award with negative Soli. Please, change Soli and try again.");
        }

        else {
            System.out.println("Award value: " + award1Instance.getValue() + " Award value wasn't converted.");
            nomineeInstance.setCurrValue(nomineeInstance.getCurrValue() + 1);
            nomineeInstance.getAward1ListWithoutSoli().add(award1Instance);


        }
    }

    /**
     * This method is used to give a nomination to Nominee. At first it checks whether both Nominee and Nominator have no
     * amount and quantity limits. Then nominee limits are checked, after that we check nominator limits.
     *
     * @param awardInstance     Award object Award object
     * @param nomineeInstance   Nominee object Nominee object
     * @param nominatorInstance Nominator object Nominator object
     */
    public void nominate(Award awardInstance, Person nomineeInstance, Person nominatorInstance) throws NegativeValueAwardException, NegativeSoliException {
        System.out.println("Nominee: " + nomineeInstance.getName());

        if (nominatorInstance.isNoLimitAmt() && nominatorInstance.isNoLimitQnt() && nomineeInstance.isNoLimitAmt() && nomineeInstance.isNoLimitQnt()) {

                if(awardInstance.getValue()< 0) {
                    throw new NegativeValueAwardException("Impossible to send your award as it has negative value. Please, change award value and try again.");
                } else {
                    receiveAward(awardInstance, (Nominee) nomineeInstance);
            }

        } else {
            if (nominatorInstance.isNoLimitQnt()) {
                if (!nomineeInstance.isLimitReached(nomineeInstance.getAwardQuantityLimit(), nomineeInstance.getCurrValue())) {
                    receiveAward(awardInstance, (Nominee) nomineeInstance);
                } else {
                    limitReached("nomineeQuantityLimit", nomineeInstance.getName(), nomineeInstance.getCurrValue());
                }
            } else if (nomineeInstance.isNoLimitQnt()) {
                if (!nominatorInstance.isLimitReached(nominatorInstance.getAwardQuantityLimit(), nominatorInstance.getCurrValue())) {
                    receiveAward(awardInstance, (Nominee) nomineeInstance);
                    nominatorInstance.setCurrValue(nominatorInstance.getCurrValue() + 1);
                } else {
                    limitReached("nominatorQuantityLimit", nominatorInstance.getName(), nominatorInstance.getCurrValue());
                }
            } else {
                if (!nominatorInstance.isLimitReached(nominatorInstance.getAwardQuantityLimit(), nominatorInstance.getCurrValue())) {
                    if (!nomineeInstance.isLimitReached(nomineeInstance.getAwardQuantityLimit(), nomineeInstance.getCurrValue())) {
                        receiveAward(awardInstance, (Nominee) nomineeInstance);
                        nominatorInstance.setCurrValue(nominatorInstance.getCurrValue() + 1);
                    } else {
                        limitReached("nomineeQuantityLimit", nomineeInstance.getName(), nomineeInstance.getCurrValue());
                    }
                } else {
                    limitReached("nominatorQuantityLimit", nominatorInstance.getName(), nominatorInstance.getCurrValue());
                }
            }
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
    public void countQuantity(Nominee nomineeInstance) {
        for (int i = 0; i < nomineeInstance.getAward1ListWithoutSoli().size(); i++) {
            double randomDecimal = Math.random();
            int population = nomineeInstance.getAward1ListWithoutSoli().size();
            int randomWholeNumber = (int) (Math.random() * 10);
            double awardValueForFormula = nomineeInstance.getAward1ListWithoutSoli().get(i).getValue();

            double denominator1 = Math.pow(randomDecimal, 2.0);
            double numerator1 = ((Math.pow(randomWholeNumber, 2.0) * awardValueForFormula * (1 - awardValueForFormula)));
            double numeratorForFormula = numerator1 / denominator1;
            double denominatorForFormula = (1 + (((numerator1 / denominator1) - 1) / population));
            double formula = numeratorForFormula / denominatorForFormula;
            nomineeInstance.getQuantity().add(i, formula);

        }
    }

    /**
     * This method is used to nominate a whole team.
     *
     * @param awardInstance     Award object
     * @param team              List containing Nominees objects
     * @param nominatorInstance Nominator object
     */
    public void nominateTeam(Award awardInstance, List<Nominee> team, Nominator nominatorInstance) throws NegativeSoliException {

        int i = 0;
        int max_i = team.size();
        double dCurrentStateOfLimit = nominatorInstance.getAwardAmountLimit();
        while (dCurrentStateOfLimit >= awardInstance.getValue()) {

            if (i >= max_i) {
                i = 0;
            }
            receiveAward(awardInstance, team.get(i));

            dCurrentStateOfLimit -= awardInstance.getValue();
            i++;


        }


    }
}

