package edu.craptocraft.ricksybusiness.business;

import java.util.HashMap;
import java.util.Map;

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
            for (Map.Entry<String, String> ufo : flota.entrySet()) {
                if (ufo.getValue() == null) {
                    ovni = ufo;
                    break;
                }
            }

        }

        if (ovni != null && card.pay(fee)) {
            ovni.setValue(card.number());
            this.flota.put(ovni.getKey(), ovni.getValue());
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
