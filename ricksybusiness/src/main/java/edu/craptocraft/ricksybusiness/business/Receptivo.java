package edu.craptocraft.ricksybusiness.business;

import java.util.LinkedHashSet;
import java.util.Set;

public class Receptivo {

    private Set<GuestDispatcher> observers = new LinkedHashSet<>();

    Receptivo() {
    };

    void registra(GuestDispatcher observer) {

        observers.add(observer);

    }

    void dispatch(CreditCard card) {

        for (GuestDispatcher observer : observers) {
            observer.dispatch(card);
        }

    }

}
