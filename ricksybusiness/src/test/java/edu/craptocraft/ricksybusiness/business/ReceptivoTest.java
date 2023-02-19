package edu.craptocraft.ricksybusiness.business;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class ReceptivoTest {

    private Receptivo receptivo = null;
    private UfosParkTest parkTest = null;
    private CrystalExpender packExpender = null;
    private RickMenuDispatcher menuDispatcher = null;

    @Before
    public void setupTest() {

        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();

        packExpender = new CrystalExpender(100, 50);

        receptivo = new Receptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
    }

    @Test
    public void dispatchTest() {

        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        receptivo.dispatch(card);

        assertEquals(2450, card.credit(), 0);
        assertTrue(parkTest.ufos.containsCard(card.number()));
        assertEquals(99, packExpender.stock());
    }

    @Test
    public void dispatchNoCreditTest() {

        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        card.pay(3000);
        receptivo.dispatch(card);
        assertEquals(0, card.credit(), 0);
        assertFalse(parkTest.ufos.containsCard(card.number()));
        assertEquals(100, packExpender.stock());
    }

    @Test
    public void newDispatchTest() {
        // Resetting the stock and the ufos
        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();
        packExpender = new CrystalExpender(100, 50);
        menuDispatcher = new RickMenuDispatcher(100, 10);

        // New receptivo with menuDispatcher
        receptivo = new Receptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
        receptivo.registra(menuDispatcher);

        // New credit card
        CreditCard card = new CreditCard("ItsElxuloSuper", "4916119711304512");

        receptivo.dispatch(card);

        assertEquals(2440, card.credit(), 0);

        assertTrue(parkTest.ufos.containsCard(card.number()));

        assertEquals(99, packExpender.stock());

        assertEquals(99, menuDispatcher.stock());

    }

    @Test
    public void newDispatchTestNoPackStock() {
        // Resetting the stock and the ufos
        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();
        packExpender = new CrystalExpender(0, 50);
        menuDispatcher = new RickMenuDispatcher(100, 10);

        // New receptivo with menuDispatcher
        receptivo = new Receptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
        receptivo.registra(menuDispatcher);

        // New credit card
        CreditCard card = new CreditCard("ItsElxuloSuper", "4916119711304512");

        receptivo.dispatch(card);

        assertEquals(2490, card.credit(), 0);

        assertTrue(parkTest.ufos.containsCard(card.number()));

        assertEquals(0, packExpender.stock());

        assertEquals(99, menuDispatcher.stock());

    }

    @Test
    public void newDispatchTestNoMenuStock() {
        // Resetting the stock and the ufos
        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();
        packExpender = new CrystalExpender(100, 50);
        menuDispatcher = new RickMenuDispatcher(0, 10);

        // New receptivo with menuDispatcher
        receptivo = new Receptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
        receptivo.registra(menuDispatcher);

        // New credit card
        CreditCard card = new CreditCard("ItsElxuloSuper", "4916119711304512");

        receptivo.dispatch(card);

        assertEquals(2450, card.credit(), 0);

        assertTrue(parkTest.ufos.containsCard(card.number()));

        assertEquals(99, packExpender.stock());

        assertEquals(0, menuDispatcher.stock());

    }

    @Test
    public void newDispatchTestNoStock() {
        // Resetting the stock and the ufos
        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();
        packExpender = new CrystalExpender(0, 50);
        menuDispatcher = new RickMenuDispatcher(0, 10);

        // New receptivo with menuDispatcher
        receptivo = new Receptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
        receptivo.registra(menuDispatcher);

        // New credit card
        CreditCard card = new CreditCard("ItsElxuloSuper", "4916119711304512");

        receptivo.dispatch(card);

        assertEquals(2500, card.credit(), 0);

        assertTrue(parkTest.ufos.containsCard(card.number()));

        assertEquals(0, packExpender.stock());

        assertEquals(0, menuDispatcher.stock());

    }

    @Test
    public void newDispatchTestNoCredit() {
        // Resetting the stock and the ufos
        parkTest = new UfosParkTest();
        parkTest.setupUfosPark();
        packExpender = new CrystalExpender(100, 50);
        menuDispatcher = new RickMenuDispatcher(100, 10);

        // New receptivo with menuDispatcher
        receptivo = new Receptivo();
        receptivo.registra(parkTest.ufos);
        receptivo.registra(packExpender);
        receptivo.registra(menuDispatcher);

        // New credit card
        CreditCard card = new CreditCard("ItsElxuloSuper", "4916119711304512");
        card.pay(3000);

        receptivo.dispatch(card);

        assertEquals(0, card.credit(), 0);

        assertFalse(parkTest.ufos.containsCard(card.number()));

        assertEquals(100, packExpender.stock());

        assertEquals(100, menuDispatcher.stock());

    }

}