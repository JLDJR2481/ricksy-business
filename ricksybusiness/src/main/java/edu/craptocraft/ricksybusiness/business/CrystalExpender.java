package edu.craptocraft.ricksybusiness.business;

public class CrystalExpender implements GuestDispatcher {

    private int stock;
    private double itemCost;

    CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard card) {
        if (card.credit() >= itemCost && stock > 0) {
            card.pay(itemCost);
            stock -= 1;
        }
    }

    int stock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return "Stock: " + stock() + "\nPrice: " + itemCost;
    }

}
