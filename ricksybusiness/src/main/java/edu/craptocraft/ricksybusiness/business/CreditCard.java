package edu.craptocraft.ricksybusiness.business;

public class CreditCard {

    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZIS";

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    String number() {
        return this.number;
    }

    boolean pay(double cobro) {

        if (cobro > credit) {
            return false;
        } else {
            credit -= cobro;
            return true;
        }

    }

    String cardOwner() {
        return this.owner;
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return "owner: " + this.owner + "\nnumber: " + this.number + "\ncredit: " + this.credit + " " + this.SYMBOL;
    }

}
