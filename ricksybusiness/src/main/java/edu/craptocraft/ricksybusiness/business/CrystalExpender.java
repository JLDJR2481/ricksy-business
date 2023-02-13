package edu.craptocraft.ricksybusiness.business;

public class CrystalExpender implements GuestDispatcher {

    private int stock;
    private double itemCost;

    CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "stock: " + this.stock + "\ncost: " + this.itemCost;
    }

    public void dispatch(CreditCard card) {
        if (this.stock > 0 && card.credit() >= this.itemCost) {
            this.stock -= 1;
            card.pay(itemCost);
        }
    }

    int stock() {
        return this.stock;

    }
}
