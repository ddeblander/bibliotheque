import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DVD
{
    private long code;
    private LocalTime dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues;
    private List<String> sousTitres;

    public DVD(long code, LocalTime dureeTotale, byte nbreBonus) {
        this.code = code;
        this.dureeTotale = dureeTotale;
        this.nbreBonus = nbreBonus;
        autresLangues= new ArrayList<>();
        sousTitres= new ArrayList<>();
    }
}
