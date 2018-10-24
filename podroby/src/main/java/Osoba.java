import java.time.LocalDate;

/**
 * Przykładowa osoba
 *
 * @author Tomasz @LAFK_pl Borek
 */
class Osoba {

    private int id;
    private String imie;
    private String nazwisko;
    private int wiek;
    private Kraj kraj;
    private LocalDate dataUrodzenia;
    private Adres miejsceUrodzenia;
    private Adres miejsceZamieszkania;
    private Adres korespondencyjny;

    Osoba(){

    }

    public Osoba(int id, String imie, String nazwisko, int wiek, Kraj kraj, LocalDate dataUrodzenia, Adres miejsceUrodzenia, Adres miejsceZamieszkania, Adres korespondencyjny) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.kraj = kraj;
        this.dataUrodzenia = dataUrodzenia;
        this.miejsceUrodzenia = miejsceUrodzenia;
        this.miejsceZamieszkania = miejsceZamieszkania;
        this.korespondencyjny = korespondencyjny;
    }

    public Osoba(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Kraj getKraj() {
        return kraj;
    }

    public void setKraj(Kraj kraj) {
        this.kraj = kraj;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Adres getMiejsceUrodzenia() {
        return miejsceUrodzenia;
    }

    public void setMiejsceUrodzenia(Adres miejsceUrodzenia) {
        this.miejsceUrodzenia = miejsceUrodzenia;
    }

    public Adres getMiejsceZamieszkania() {
        return miejsceZamieszkania;
    }

    public void setMiejsceZamieszkania(Adres miejsceZamieszkania) {
        this.miejsceZamieszkania = miejsceZamieszkania;
    }

    public Adres getKorespondencyjny() {
        return korespondencyjny;
    }

    public void setKorespondencyjny(Adres korespondencyjny) {
        this.korespondencyjny = korespondencyjny;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", kraj=" + kraj +
                ", dataUrodzenia=" + dataUrodzenia +
                ", miejsceUrodzenia=" + miejsceUrodzenia +
                ", miejsceZamieszkania=" + miejsceZamieszkania +
                ", korespondencyjny=" + korespondencyjny +
                '}';
    }
}
