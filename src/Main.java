import award.Award;
import nominator.Nominator;
import nominee.Nominee;

public class Main {
    public static void main(String[] args) {
        Award goodJobAward1 = new Award(100);
        Award notBadAward1 = new Award(50, 1.75);
        Award wellDoneAward1 = new Award(200);
        Award thankYouAward1 = new Award(10, 2.25);
        Award excellentAward1 = new Award(300, 2);
        Award perfectAward1 = new Award(10);

        Nominee nominee1 = new Nominee("Peter");
        Nominee nominee2 = new Nominee("Kate");
        Nominee nominee3 = new Nominee("Ann");

        Nominator nominator21 = new Nominator("Paul");


        nominator21.nominate(goodJobAward1, nominee1);
        nominator21.nominate(goodJobAward1, nominee1);
        nominator21.nominate(thankYouAward1, nominee1);

        nominator21.nominate(notBadAward1, nominee2);
        nominator21.nominate(wellDoneAward1, nominee2);
        nominator21.nominate(goodJobAward1, nominee2);
        nominator21.nominate(goodJobAward1, nominee2);

        nominator21.nominate(excellentAward1, nominee3);
        nominator21.nominate(perfectAward1, nominee3);
        nominator21.nominate(perfectAward1, nominee3);

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
        Nominator nominator2WithLimits = new Nominator("Karl", 3, 1000);
        Nominee nomineeWithLimits = new Nominee("John", 5, 1000);

        nominator2WithLimits.nominate(goodJobAward1, nomineeWithLimits);
        nominator2WithLimits.nominate(goodJobAward1, nomineeWithLimits);
        nominator2WithLimits.nominate(goodJobAward1, nomineeWithLimits);
        nominator2WithLimits.nominate(goodJobAward1, nomineeWithLimits);

        Nominator nominator2WithLimits2 = new Nominator("Vlad", 5, 300);
        Nominee nomineeWithLimits2 = new Nominee("Sonya", 5, 1000);

        nominator2WithLimits2.nominate(goodJobAward1, nomineeWithLimits2);
        nominator2WithLimits2.nominate(goodJobAward1, nomineeWithLimits2);
        nominator2WithLimits2.nominate(goodJobAward1, nomineeWithLimits2);
        nominator2WithLimits2.nominate(goodJobAward1, nomineeWithLimits2);


        Nominator nominator2WithLimits3 = new Nominator("Pavel", 5, 1000);
        Nominee nomineeWithLimits3 = new Nominee("Evgenii", 2, 300);

        nominator2WithLimits3.nominate(goodJobAward1, nomineeWithLimits3);
        nominator2WithLimits3.nominate(goodJobAward1, nomineeWithLimits3);
        nominator2WithLimits3.nominate(goodJobAward1, nomineeWithLimits3);


        Nominator nominator2WithLimits4 = new Nominator("Michael", 5, 1000);
        Nominee nomineeWithLimits4 = new Nominee("Igor", 5, 300);

        nominator2WithLimits4.nominate(goodJobAward1, nomineeWithLimits4);
        nominator2WithLimits4.nominate(goodJobAward1, nomineeWithLimits4);
        nominator2WithLimits4.nominate(goodJobAward1, nomineeWithLimits4);
        nominator2WithLimits4.nominate(goodJobAward1, nomineeWithLimits4);

        System.out.println( nominee1.getQuantity());
        System.out.println( nominee2.getQuantity());
        System.out.println( nominee3.getQuantity());

    }
}
