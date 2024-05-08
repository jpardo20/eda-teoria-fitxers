package exercicis.ex_08_09_Save_and_Restore;

public class Part {

    public static final String MARCA = "CSxxx77DHRRPE=EXX";

    private String id, desc;
    
    public Part (String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public String getId() {return this.id;}
    public String getDesc() {return this.desc;}
}
