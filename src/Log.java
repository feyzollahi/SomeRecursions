import java.util.HashMap;
import java.util.Map;

public class Log {
    int cuurentlevel;
    public static int levelsNumber;
    public static boolean levelDefaultAsc;
    Map<String, String> details = new HashMap<>();
    public Log(int cuurentlevel, Map<String, String> details){
        this.cuurentlevel = cuurentlevel;
        this.details = details;
    }

    public void write(){
        if(levelDefaultAsc == false)
            System.out.println("level = " + (levelsNumber - cuurentlevel));
        else
            System.out.println("level = " + (cuurentlevel));
        for (Map.Entry<String, String> detail: details.entrySet()){
            System.out.println("    " + detail.getKey() + " = " + detail.getValue());
        }
    }

    public int getCuurentlevel() {
        return cuurentlevel;
    }

    public void setCuurentlevel(int cuurentlevel) {
        this.cuurentlevel = cuurentlevel;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }
}
