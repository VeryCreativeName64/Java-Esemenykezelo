import controller.EventController;
import modell.EventModell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.EventView;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;


class EventControllerTest {
    private EventController controller;
    private EventView view;

    @BeforeEach
    void setUp() {

        view = new EventView();
        controller = new EventController(view);
    }

    @Test
    void testEventCreationAndGetters() {

        EventModell event = new EventModell(1, "Teszt Konferencia", "konferencia", "Szervező Kft.", new Date(), true);

        assertEquals(1, event.getId(), "Az ID-nek egyeznie kell.");
        assertEquals("Teszt Konferencia", event.getCim(), "A címnek egyeznie kell.");
        assertTrue(event.isStatusz(), "A státusznak true-nak kell lennie.");
    }

    @Test
    void testEventModellIntegritas() {
        java.util.Date datum = new java.util.Date();

        EventModell tesztEsemeny = new EventModell(101, "Konferencia", "szakmai", "Egyetem", datum, true);

        assertEquals(101, tesztEsemeny.getId(), "Az ID-nek egyeznie kell.");
        assertEquals("Konferencia", tesztEsemeny.getCim(), "A címnek egyeznie kell.");
        assertTrue(tesztEsemeny.isStatusz(), "A státusznak aktívnak kell lennie.");
    }

    @Test
    void testHibasAdatKezeles() {
        EventView view = new EventView();
        EventController controller = new EventController(view);


        assertDoesNotThrow(() -> controller.beolvas("hibas_adatok.txt"),
                "A programnak hibatűrőnek kell lennie érvénytelen adatok esetén.");
    }

    @Test
    void testDuplicateIdPrevention() {

        controller.beolvas("src/adatok.txt");

        controller.beolvas("src/adatok.txt");


    }
}