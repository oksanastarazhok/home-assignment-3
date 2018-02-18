import award.Award;
import exceptions.NegativeSoliException;
import exceptions.NegativeValueAwardException;
import nomination.NominationHelper;
import nominator.Nominator;
import nominee.Nominee;
import person.Person;
import person.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NegativeValueAwardException {
        //taskWithFormula();
        // taskWithLoops();
        //inheritanceTask();
        //abstractTask();
        // polymorphismTask();
        // exceptionTask();
        printAwardsTask();
    }

    /**
     * This method is used to create Array with Awards of different types. After that we print unique award type vie
     * using HashSet.+
     */
    public static void printAwardsTask() {

        Award awardNumber1 = new Award(100, "Private", 1);
        Award awardNumber2 = new Award(10, "Private", 2);
        Award awardNumber3 = new Award(100, "Private", 3);
        Award awardNumber4 = new Award(100, "Restricted", 74);
        Award awardNumber5 = new Award(100, "Private", 4);
        Award awardNumber6 = new Award(100, "Restricted", 5);
        Award awardNumber7 = new Award(100, "Private", 6);
        Award awardNumber8 = new Award(100, "Private", 7);
        Award awardNumber9 = new Award(100, "Public", 11);
        Award awardNumber10 = new Award(100, "Private", 15);
        Award awardNumber11 = new Award(100, "Public", 18);
        Award awardNumber12 = new Award(100, "Private", 51);
        Award awardNumber13 = new Award(100, "Private", 111);
        Award awardNumber14 = new Award(100, "Restricted", 21);
        Award awardNumber15 = new Award(100, "Public", 19);

        List<Award> myAwards = new ArrayList<>(15);

        myAwards.add(awardNumber1);
        myAwards.add(awardNumber2);
        myAwards.add(awardNumber3);
        myAwards.add(awardNumber4);
        myAwards.add(awardNumber5);
        myAwards.add(awardNumber6);
        myAwards.add(awardNumber7);
        myAwards.add(awardNumber8);
        myAwards.add(awardNumber9);
        myAwards.add(awardNumber10);
        myAwards.add(awardNumber11);
        myAwards.add(awardNumber12);
        myAwards.add(awardNumber13);
        myAwards.add(awardNumber14);
        myAwards.add(awardNumber15);

        Award.pintAwards(myAwards, "Public");

        Set<String> allAwardsTypes = new HashSet<>();
        for (Award award : myAwards) {
            allAwardsTypes.add(award.getType());
        }
        System.out.println("Below you can see all awards types:");
        for (String type : allAwardsTypes) {

            System.out.println(type);
        }

        System.out.println(awardNumber1.equals(awardNumber3));
        System.out.println(awardNumber1.equals(awardNumber6));

        System.out.println(awardNumber1.hashCode());
        System.out.println(awardNumber3.hashCode());
        System.out.println(awardNumber6.hashCode());

    }

    /**
     * This method is used to demonstrate custom Exceptions: NegativeValueAwardException and NegativeSoliException.
     */
    public static void exceptionTask() {
        Award perfectAward = new Award(10, -2);
        Award excellentAward = new Award(-300);

        Person nominee1 = new Nominee("Gerbert", Type.NOMINEE);
        Person nominee2 = new Nominee("Tom", Type.NOMINEE);

        Person nominator = new Nominator("Adam", Type.NOMINATOR);

        NominationHelper nominationHelper = new NominationHelper();
        try {
            nominationHelper.nominate(perfectAward, nominee1, nominator);
            nominationHelper.nominate(excellentAward, nominee2, nominator);
            nominationHelper.nominate(excellentAward, nominee2, nominator);

        } catch (NegativeValueAwardException e) {
            System.out.println(e);
        } catch (NegativeSoliException e) {
            System.out.println(e);
        }


    }

    /**
     * This method is used to demonstrate overriding and overloading.
     * It creates objects of the following Classes: Person, Award and prints info about them.
     *
     * @throws NegativeValueAwardException will be thrown if user will try to give an award with negative value.
     */
    private static void polymorphismTask() throws NegativeValueAwardException {
        Award perfectAward = new Award(10);
        Award excellentAward = new Award(300);

        Person nominee1 = new Nominee("Peter", Type.NOMINEE);
        Person nominee2 = new Nominee("Kate", Type.NOMINEE);

        Person nominator = new Nominator("Paul", Type.NOMINATOR);

        NominationHelper nominationHelper = new NominationHelper();
        try {
            nominationHelper.nominate(perfectAward, nominee1, nominator);
            nominationHelper.nominate(excellentAward, nominee2, nominator);
            nominationHelper.nominate(excellentAward, nominee2, nominator);
        } catch (NegativeSoliException e) {
            System.out.println(e);
        }

        nominee1.printInfo();
        nominee2.printInfo();
        nominee1.printInfo(nominator);
        nominator.printInfo(nominee1);


    }

    /**
     * This method is used to demonstrate usage of if/while loops.
     * It creates several nominees with Limits, one award and several nominators.
     *
     * @throws NegativeValueAwardException will be thrown if user will try to give an award with negative value.
     * @throws NegativeSoliException       will be thrown if user will try to give an award with negative soli value.
     */
    private static void abstractTask() throws NegativeValueAwardException, NegativeSoliException {
        Nominee nominee1 = new Nominee("Peter", 10, 100);
        Nominee nominee2 = new Nominee("Kate", 5, 50);
        Nominee nominee3 = new Nominee("Ann", 1, 10);

        Award goodJobAward1 = new Award(10);

        Nominator nominator2WithLimits = new Nominator("Karl", 2, 1000);
        Nominator nominator1WithLimits = new Nominator("Federico", 1, 10);

        NominationHelper nominationHelper = new NominationHelper();

        nominationHelper.nominate(goodJobAward1, nominee3, nominator2WithLimits);
        nominationHelper.nominate(goodJobAward1, nominee2, nominator2WithLimits);
        nominationHelper.nominate(goodJobAward1, nominee3, nominator2WithLimits);
        nominationHelper.nominate(goodJobAward1, nominee3, nominator1WithLimits);
    }


    /**
     * This method creates several instances of the following classes: award, nominee and nominator.
     * Also it creates a few nominations, counts whether it has been converted or not and compares nominations received
     * by different nominees among themselves.
     *
     * @throws NegativeValueAwardException will be thrown if user will try to give an award with negative value.
     * @throws NegativeSoliException       will be thrown if user will try to give an award with negative soli value.
     */
    private static void taskWithFormula() throws NegativeValueAwardException, NegativeSoliException {
        NominationHelper myHelper = new NominationHelper();

        Award goodJobAward1 = new Award(100);
        Award notBadAward1 = new Award(50, 1.75);
        Award wellDoneAward1 = new Award(200);
        Award thankYouAward1 = new Award(10, 2.25);
        Award excellentAward1 = new Award(300, 2);
        Award perfectAward1 = new Award(10);

        Nominee nominee1 = new Nominee("Peter", Type.NOMINEE);
        Nominee nominee2 = new Nominee("Kate", Type.NOMINEE);
        Nominee nominee3 = new Nominee("Ann", Type.NOMINEE);

        Nominator nominator21 = new Nominator("Paul", Type.NOMINATOR);


        myHelper.nominate(goodJobAward1, nominee1, nominator21);
        myHelper.nominate(goodJobAward1, nominee1, nominator21);
        myHelper.nominate(thankYouAward1, nominee1, nominator21);

        myHelper.nominate(notBadAward1, nominee2, nominator21);
        myHelper.nominate(wellDoneAward1, nominee2, nominator21);
        myHelper.nominate(goodJobAward1, nominee2, nominator21);
        myHelper.nominate(goodJobAward1, nominee2, nominator21);

        myHelper.nominate(excellentAward1, nominee3, nominator21);
        myHelper.nominate(perfectAward1, nominee3, nominator21);
        myHelper.nominate(perfectAward1, nominee3, nominator21);

        myHelper.countQuantity(nominee1);
        myHelper.countQuantity(nominee2);
        myHelper.countQuantity(nominee3);

        Double PetersQntOne = nominee1.getQuantity().get(0);
        Double PetersQntTwo = nominee1.getQuantity().get(1);
        Double KatesQntOne = nominee2.getQuantity().get(0);
        Double KatesQntTwo = nominee2.getQuantity().get(1);
        Double KatesQntThree = nominee2.getQuantity().get(2);
        Double AnnsQntOne = nominee3.getQuantity().get(0);
        Double AnnsQntTwo = nominee3.getQuantity().get(1);


        if (PetersQntOne >= PetersQntTwo) {
            System.out.println("Quantity of Peter's award1 is greater than or equal to quantity of Peters's award2.");
        } else if (PetersQntOne <= PetersQntTwo) {
            System.out.println("Quantity of Peter's award2 is greater than or equal to quantity of Peters's award1.");
        }

        if (PetersQntOne != PetersQntTwo) {
            System.out.println("Quantity of Peter's awards are not equal.");
        } else if (PetersQntOne == PetersQntTwo) {
            System.out.println("Quantity of Peter's awards are equal.");
        }


        if (KatesQntOne < KatesQntTwo && KatesQntThree > KatesQntTwo) {
            System.out.println("Quantity of Kate's award3 is the biggest one.");
        } else if (!(KatesQntOne > KatesQntTwo)) {
            System.out.println("Quantity of Kate's award2 is the biggest one.");
        } else {
            System.out.println("Quantity of Kate's award1 is the biggest one.");
        }


        if (AnnsQntOne < AnnsQntTwo || AnnsQntOne > AnnsQntTwo) {
            System.out.println("Quantity of Ann's awards are not equal.");

        }
    }


    /**
     * This method creates several instances of the following classes: award, nominee and nominator. All nominator and nominee
     * instance are created with limits. When the limit is reached it will print a message describing the type of limit,
     * who reached the limit, name of the person and award count before limit.
     *
     * @throws NegativeValueAwardException will be thrown if user will try to give an award with negative value.
     * @throws NegativeSoliException       will be thrown if user will try to give an award with negative soli value.
     */
    private static void taskWithLoops() throws NegativeValueAwardException, NegativeSoliException {
        NominationHelper myHelper = new NominationHelper();
        Award goodJobAward1 = new Award(100);
        Nominator nominator2WithLimits = new Nominator("Karl", 3, 1000);
        Nominee nomineeWithLimits = new Nominee("John", 5, 1000);

        myHelper.nominate(goodJobAward1, nomineeWithLimits, nominator2WithLimits);
        myHelper.nominate(goodJobAward1, nomineeWithLimits, nominator2WithLimits);
        myHelper.nominate(goodJobAward1, nomineeWithLimits, nominator2WithLimits);
        myHelper.nominate(goodJobAward1, nomineeWithLimits, nominator2WithLimits);

        Nominator nominator2WithLimits2 = new Nominator("Vlad", 5, 300);
        Nominee nomineeWithLimits2 = new Nominee("Sonya", 5, 1000);

        myHelper.nominate(goodJobAward1, nomineeWithLimits2, nominator2WithLimits2);
        myHelper.nominate(goodJobAward1, nomineeWithLimits2, nominator2WithLimits2);
        myHelper.nominate(goodJobAward1, nomineeWithLimits2, nominator2WithLimits2);
        myHelper.nominate(goodJobAward1, nomineeWithLimits2, nominator2WithLimits2);


        Nominator nominator2WithLimits3 = new Nominator("Pavel", 5, 1000);
        Nominee nomineeWithLimits3 = new Nominee("Evgenii", 2, 300);

        Nominator nominatorWithLimits4 = new Nominator("Oksana", 10, 100);


        myHelper.nominate(goodJobAward1, nomineeWithLimits3, nominator2WithLimits3);
        myHelper.nominate(goodJobAward1, nomineeWithLimits3, nominator2WithLimits3);
        myHelper.nominate(goodJobAward1, nomineeWithLimits3, nominator2WithLimits3);


        Nominator nominator2WithLimits4 = new Nominator("Michael", 5, 1000);
        Nominee nomineeWithLimits4 = new Nominee("Igor", 5, 300);

        myHelper.nominate(goodJobAward1, nomineeWithLimits4, nominator2WithLimits4);
        myHelper.nominate(goodJobAward1, nomineeWithLimits4, nominator2WithLimits4);
        myHelper.nominate(goodJobAward1, nomineeWithLimits4, nominator2WithLimits4);
        myHelper.nominate(goodJobAward1, nomineeWithLimits4, nominator2WithLimits4);


        Nominee nominee1 = new Nominee("Peter", Type.NOMINEE);
        Nominee nominee2 = new Nominee("Kate", Type.NOMINEE);
        Nominee nominee3 = new Nominee("Ann", Type.NOMINEE);


        List<Nominee> dreamTeam = new ArrayList<Nominee>();
        dreamTeam.add(0, nominee1);
        dreamTeam.add(1, nominee2);
        dreamTeam.add(2, nominee3);
        dreamTeam.add(3, nomineeWithLimits);

        myHelper.nominateTeam(goodJobAward1, dreamTeam, nominatorWithLimits4);
    }

    private static void inheritanceTask() {
        Nominator nominator = new Nominator("Nominator Ivan", Type.NOMINATOR);
        nominator.login();

        Nominee nominee = new Nominee("Nominee Petr", Type.NOMINEE);
        nominee.login();
    }
}
