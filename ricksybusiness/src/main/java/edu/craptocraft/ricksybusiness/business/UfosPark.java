package edu.craptocraft.ricksybusiness.business;

import java.util.Map;
import java.util.HashMap;

public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private final Map<String, String> flota = new HashMap<String, String>();

    UfosPark() {
    };

    void add(String ufoID) {
        flota.putIfAbsent(ufoID, null);
    }

    @Override
    public void dispatch(CreditCard card) {

        Map.Entry<String, String> ovni = null;

        if (!flota.containsValue(card.number())) {
            for (Map.Entry<String, String> id : this.flota.entrySet()) {
                if (id.getValue() == null) {
                    ovni = id;
                    break;
                }
            }
        }
        if (ovni != null && card.pay(fee)) {
            this.flota.put(ovni.getKey(), card.number());
        }

    }

    String getUfoOf(String cardNumber) {

        String id = null;

        for (Map.Entry<String, String> ovnis : flota.entrySet()) {
            if (ovnis.getValue() == cardNumber) {
                id = ovnis.getKey();
                break;

            }
        }
        return id;

    }

}
