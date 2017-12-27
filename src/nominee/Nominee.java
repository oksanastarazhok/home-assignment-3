package nominee;

import award.Award;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Nominee {

    static {
        System.out.println("An instance of Nominee class was initialized");
    }

    private String name;
    private boolean noLimitAmt;
    private boolean noLimitQnt;
    private final List<Double> quantity = new ArrayList<Double>();
    private final ArrayList<Award> award1ListWithoutSoli = new ArrayList<Award>();
    private int nomineeAwardQuantityLimit;
    private double nomineeAwardAmountLimit;
    private final int constantAwardQuantityLimit;

    public double getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public void setNomineeAwardAmountLimit(double tempAmt) {
        this.nomineeAwardAmountLimit = tempAmt;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public void setNomineeAwardQuantityLimit(int tempQnt) {
        this.nomineeAwardQuantityLimit = tempQnt;
    }

    public List<Double> getQuantity() {
        return quantity;
    }

    public Nominee(String name) {
        this.name = name;
        this.noLimitAmt = true;
        this.noLimitQnt = true;
        this.constantAwardQuantityLimit = 0;
    }

    public String getName() {
        return name;
    }

    public Nominee(String name, int nomineeAwardQuantityLimit, double nomineeAwardAmountLimit) {
        this.name = name;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
        this.constantAwardQuantityLimit = nomineeAwardQuantityLimit;
    }


    public void receiveAward(Award award1Instance) {

        if (award1Instance.getSoli() > 0) {

            double percentage = (award1Instance.getSoli() * 100) - 100;
            if (percentage < 0) {
                System.out.println("Award value decreased on " + abs(percentage) + "%.");
            } else {
                System.out.println("Award value increased on " + percentage + "%.");
            }
        } else {
            System.out.println("Award value: " + award1Instance.getValue() + " Award value wasn't converted.");
            award1ListWithoutSoli.add(award1Instance);

        }
    }

    public void countQuantity() {
        for (int i = 0; i < award1ListWithoutSoli.size(); i++) {
            double c = Math.random();
            int population = award1ListWithoutSoli.size();
            int z = (int) (Math.random() * 10);
            double p = award1ListWithoutSoli.get(i).getValue();
            quantity.add(i, ((Math.pow(z, 2.0) * p * (1 - p)) / Math.pow(c, 2.0) / (1 + ((((Math.pow(z, 2.0) * p * (1 - p)) / Math.pow(c, 2.0)) - 1) / population))));
        }
    }

    public boolean isNoLimitAmt() {
        return noLimitAmt;
    }


    public boolean isNoLimitQnt() {
        return noLimitQnt;
    }

    public int getConstantAwardQuantityLimit() {
        return constantAwardQuantityLimit;
    }
}


