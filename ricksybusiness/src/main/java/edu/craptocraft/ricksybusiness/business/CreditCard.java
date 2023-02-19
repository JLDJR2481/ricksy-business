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

    String cardOwner() {
        return this.owner;
    }

    boolean pay(double cobro) {
        if (cobro <= credit) {
            this.credit -= cobro;
            return true;
        } else {
            return false;
        }
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return "Owner: " + cardOwner() + "\nCard number: " + number() + "\nCredit: " + credit() + " " + this.SYMBOL;
    }
}
