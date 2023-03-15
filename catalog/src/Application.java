import com.example.catalog.Catalog;
import com.example.document.*;

public class Application {
    public static void main (String[] args) {
        Catalog catalog = new Catalog();

        Book book = new Book(
                "Dášeňka čili život štěněte",
                "978-80-242-2614-9",
                "Knižní klub",
                "2009",
                80
        );

        WebPage page = new WebPage(
                "https://fis.vse.cz",
                "Fakulta informatiky a statistiky – Vysoká škola ekonomická v Praze",
                "Fakulta sdružuje katedry a studijní programy zabývající se informačními systémy a statistickými, ekonometrickými i dalšími matematickými metodami aplikovanými ve všech oblastech hospodářského života."
        );

        Document document = new Document(
                "198229-2/OAM-2022",
                "Rozhodnutí o udělení stipendia",
                "Dne 27.02.2023 Vám bylo uděleno stipendium."
        );

        Interview interview = new Interview(
                "Karel Čapek",
                "Josef Čapek",
                "KČ: Dobrý den. JČ: Ahoj., ...",
                27
        );

        Magazine magazine = new Magazine(
                "Blesk",
                "165-3513-456",
                "Tomas",
                "2023, aneb aktuální život",
                15
        );

        catalog.addStoredItem(book);
        catalog.addStoredItem(page);
        catalog.addStoredItem(document);
        catalog.addStoredItem(interview);
        catalog.addStoredItem(magazine);

        String all = catalog.printAll();

        System.out.println("Vypisuji vše:");
        System.out.println(all);

        String query = "život";
        System.out.println("Vyhledávám výraz '" + query + "':");

        String result = catalog.find(query);
        System.out.println(result);

        System.out.println("Domácí úkol:");
        System.out.print(
                page.printContents()
        );
        System.out.print(
                document.printContents()
        );
    }
}
