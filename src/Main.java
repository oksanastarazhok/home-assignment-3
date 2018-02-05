import award.Award;
import nomination.NominationHelper;
import nominator.Nominator;
import nominee.Nominee;
import person.Type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //taskWithFormula();
        // taskWithLoops();
        //inheritanceTask();
        abstractTask();


    }

    private static void abstractTask() {
        Nominee nominee1 = new Nominee("Peter", 10, 100 );
        Nominee nominee2 = new Nominee("Kate", 5, 50);
        Nominee nominee3 = new Nominee("Ann", 2, 10);


        Award goodJobAward1 = new Award(10);

        Nominator nominator2WithLimits = new Nominator("Karl", 1, 1000);

        NominationHelper nominationHelper = new NominationHelper();
        nominationHelper.nominate(goodJobAward1,nominee3,nominator2WithLimits);
        nominationHelper.nominate(goodJobAward1,nominee3,nominator2WithLimits);



    }


    /**
     * This method creates several instances of the following classes: award, nominee and nominator.
     * Also it creates a few nominations, counts whether it has been converted or not and compares nominations received by different nominees
     * among themselves.
     */
    private static void taskWithFormula() {
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
     * who reached the limit, name of the person and award count before limit
     */
    private static void taskWithLoops() {
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
