import java.time.LocalTime;

public class CD
{
    private long code;
    private byte nbrePlages;
    private LocalTime dureeTotale;

    public CD(long code, byte nbrePlages, LocalTime dureeTotale) {
        this.code = code;
        this.nbrePlages = nbrePlages;
        this.dureeTotale = dureeTotale;
    }
}
