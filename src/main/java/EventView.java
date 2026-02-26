import java.util.Scanner;

public class EventView {
    private Scanner sc = new Scanner(System.in);

    public void megjelenit(String adat) {
        System.out.println(adat);
    }

    public String[] beker() {
        System.out.println("\n--- Adatbekérés módosításhoz ---");
        System.out.print("Új cím: ");
        String ujCim = sc.nextLine();
        System.out.print("Új státusz (true/false): ");
        String ujStatusz = sc.nextLine();
        return new String[]{ujCim, ujStatusz};
    }

    public String keresestKer() {
        System.out.print("\nAdja meg a keresett ID-t vagy Címet a módosításhoz: ");
        return sc.nextLine();
    }
}