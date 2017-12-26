import Award.Award;
import Nominator.Nominator;
import Nominee.Nominee;


public class Main {
    public static void main(String[] args) {
        Award goodJobAward = new Award(100);
        Award notBadAward = new Award(50, 1.75);
        Award wellDoneAward = new Award(200);
        Award thankYouAward = new Award(10, 2.25);
        Award excellentAward = new Award(300, 2);
        Award perfectAward = new Award(10);

        Nominee nominee1 = new Nominee("Peter");
        Nominee nominee2 = new Nominee("Kate");
        Nominee nominee3 = new Nominee("Ann");

        Nominator nominator1 = new Nominator("Paul");


        nominator1.nominate(goodJobAward, nominee1);
        nominator1.nominate(goodJobAward, nominee1);
        nominator1.nominate(thankYouAward, nominee1);

        nominator1.nominate(notBadAward, nominee2);
        nominator1.nominate(wellDoneAward, nominee2);
        nominator1.nominate(goodJobAward, nominee2);
        nominator1.nominate(goodJobAward, nominee2);

        nominator1.nominate(excellentAward, nominee3);
        nominator1.nominate(perfectAward, nominee3);
        nominator1.nominate(perfectAward, nominee3);

        nominee1.countQuantity();
        nominee2.countQuantity();
        nominee3.countQuantity();

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
        Nominator nominatorWithLimits = new Nominator("Karl", 3, 1000);
        Nominee nomineeWithLimits = new Nominee("John", 5, 1000);

        nominatorWithLimits.nominate(goodJobAward, nomineeWithLimits);
        nominatorWithLimits.nominate(goodJobAward, nomineeWithLimits);
        nominatorWithLimits.nominate(goodJobAward, nomineeWithLimits);
        nominatorWithLimits.nominate(goodJobAward, nomineeWithLimits);

        Nominator nominatorWithLimits2 = new Nominator("Vlad", 5, 300);
        Nominee nomineeWithLimits2 = new Nominee("Sonya", 5, 1000);

        nominatorWithLimits2.nominate(goodJobAward, nomineeWithLimits2);
        nominatorWithLimits2.nominate(goodJobAward, nomineeWithLimits2);
        nominatorWithLimits2.nominate(goodJobAward, nomineeWithLimits2);
        nominatorWithLimits2.nominate(goodJobAward, nomineeWithLimits2);


        Nominator nominatorWithLimits3 = new Nominator("Pavel", 5, 1000);
        Nominee nomineeWithLimits3 = new Nominee("Evgenii", 2, 300);

        nominatorWithLimits3.nominate(goodJobAward, nomineeWithLimits3);
        nominatorWithLimits3.nominate(goodJobAward, nomineeWithLimits3);
        nominatorWithLimits3.nominate(goodJobAward, nomineeWithLimits3);


        Nominator nominatorWithLimits4 = new Nominator("Michael", 5, 1000);
        Nominee nomineeWithLimits4 = new Nominee("Igor", 5, 300);

        nominatorWithLimits4.nominate(goodJobAward, nomineeWithLimits4);
        nominatorWithLimits4.nominate(goodJobAward, nomineeWithLimits4);
        nominatorWithLimits4.nominate(goodJobAward, nomineeWithLimits4);
        nominatorWithLimits4.nominate(goodJobAward, nomineeWithLimits4);
    }
}
