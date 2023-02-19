package edu.craptocraft.ricksybusiness.business;

public class RickMenuDispatcher implements GuestDispatcher {

    private int rickMenuStock = 100;
    private double menuCost = 10.0;

    RickMenuDispatcher(int rickMenuStock, double menuCost) {
        this.rickMenuStock = rickMenuStock;
        this.menuCost = menuCost;

    };

    double menuCost() {
        return this.menuCost;
    }

    @Override
    public void dispatch(CreditCard card) {

        if (card.credit() >= menuCost && rickMenuStock >= 1) {
            card.pay(menuCost);
            rickMenuStock -= 1;
        }

    }

    int stock() {
        return this.rickMenuStock;
    }

    @Override
    public String toString() {
        return "Menús disponibles: " + stock() + "\nPrecio de menú: " + menuCost();
    }

}
