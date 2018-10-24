import java.util.Objects;

/**
 * @author Tomasz @LAFK_pl Borek
 */
class Adres {

    String ulica;
    short nrLokalu;
    short nrDomu;
    Miasto miasto;

    public String getUlica() {
        return ulica;
    }

    public short getNrLokalu() {
        return nrLokalu;
    }

    public short getNrDomu() {
        return nrDomu;
    }

    public Miasto getMiasto() {
        return miasto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adres adres = (Adres) o;
        return nrLokalu == adres.nrLokalu &&
                nrDomu == adres.nrDomu &&
                Objects.equals(ulica, adres.ulica) &&
                miasto == adres.miasto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ulica, nrLokalu, nrDomu, miasto);
    }

    public Adres(String ulica, short nrLokalu, short nrDomu, Miasto miasto) {
        this.ulica = ulica;
        this.nrLokalu = nrLokalu;
        this.nrDomu = nrDomu;
        this.miasto = miasto;
    }
}