import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
    }

    public Festmeny(String row) {
        var sor = row.split(";");
        this.cim = sor[0];
        this.festo = sor[1];
        this.stilus = sor[2];
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit(int mertek) {
        int ujErtek = 100;

        if (licitekSzama > 0) {
            ujErtek = (int)(legmagasabbLicit * 1.10);
        }

        licitekSzama++;
        legmagasabbLicit = ujErtek;
        legutolsoLicitIdeje = LocalDateTime.now();
    }

    public void licit() { licit(10); }

    @Override
    public String toString() {
        return String.format("%s: %s (%s)\n%s\n%d$ - %s (összesen: %d db)\n",
                festo, cim, stilus,
                elkelt ? "elkelt" : "nem kelt el",
                legmagasabbLicit,
                legutolsoLicitIdeje == null ? "meg nem volt licit" : legutolsoLicitIdeje.toString(),
                licitekSzama);
    }


}