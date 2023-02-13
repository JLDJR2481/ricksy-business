package edu.craptocraft.ricksybusiness.business;

import java.util.Map;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public String toString() {

        String[] ovnis = this.flota.keySet().toArray(new String[flota.size()]);

        Arrays.sort(ovnis);

        return List.of(ovnis).toString();
    }

    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }

}
