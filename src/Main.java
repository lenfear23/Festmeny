
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        var sorok = Files.readAllLines(Paths.get("festmenyek.csv"));
        var festmenyek = new LinkedList<Festmeny>();

        for (var line: sorok) {
            var festmeny = new Festmeny(line);
            festmenyek.add(festmeny);
        }

        System.out.println(festmenyek);

}
}