package controller;//kész

import modell.EventModell;
import view.EventView;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class EventController {
    private List<EventModell> lista;
    private EventView view;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public EventController(EventView view) {
        this.view = view;
        this.lista = new ArrayList<>();
    }

    public void beolvas(String fajlnev) {
        try (BufferedReader br = new BufferedReader(new FileReader(fajlnev))) {
            String sor;
            while ((sor = br.readLine()) != null) {
                String[] p = sor.split(";");
                int id = Integer.parseInt(p[0]);
                if (lista.stream().anyMatch(e -> e.getId() == id)) continue;

                lista.add(new EventModell(id, p[1], p[2], p[3], df.parse(p[4]), Boolean.parseBoolean(p[5])));
            }
        } catch (Exception e) {
            view.megjelenit("Hiba a beolvasáskor: " + e.getMessage());
        }
    }

    public void modositas(String keresett) {
        EventModell cel = null;
        for (EventModell e : lista) {
            if (String.valueOf(e.getId()).equals(keresett) || e.getCim().equalsIgnoreCase(keresett)) {
                cel = e;
                break;
            }
        }

        if (cel != null) {
            String[] uj = view.beker();
            cel.setCim(uj[0]);
            cel.setStatusz(Boolean.parseBoolean(uj[1]));
            view.megjelenit("Sikeres módosítás!");
        } else {
            view.megjelenit("Nincs találat: " + keresett);
        }
    }


    public void megjelenites() {
        view.megjelenit("\nID | CÍM | TÍPUS | SZERVEZŐ | DÁTUM | AKTÍV");
        view.megjelenit("------------------------------------------------------------");
        for (EventModell e : lista) {
            String teljesAdatsor = String.format("%d | %s | %s | %s | %s | %b",
                    e.getId(), e.getCim(), e.getTipus(), e.getSzervezo(),
                    df.format(e.getDatum()), e.isStatusz());
            view.megjelenit(teljesAdatsor);
        }
    }
}