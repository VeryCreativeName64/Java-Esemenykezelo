public class Program {
    public static void main(String[] args) {
        EventView view = new EventView();
        EventController controller = new EventController(view);


        controller.beolvas("src/adatok.txt");
        controller.megjelenites();


        String keresett = view.keresestKer();
        controller.modositas(keresett);


        controller.megjelenites();
    }
}