import java.util.Date;

public class EventModell {
    private int id;
    private String cim;
    private String tipus;
    private String szervezo;
    private Date datum;
    private boolean statusz;

    public EventModell(int id, String cim, String tipus, String szervezo, Date datum, boolean statusz) {
        this.id = id;
        this.cim = cim;
        this.tipus = tipus;
        this.szervezo = szervezo;
        this.datum = datum;
        this.statusz = statusz;
    }


    public int getId() { return id; }
    public String getCim() { return cim; }
    public String getTipus() { return tipus; }
    public String getSzervezo() { return szervezo; }
    public Date getDatum() { return datum; }
    public boolean isStatusz() { return statusz; }


    public void setCim(String cim) { this.cim = cim; }
    public void setStatusz(boolean statusz) { this.statusz = statusz; }
}