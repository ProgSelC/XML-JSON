import javax.xml.bind.annotation.XmlElement;

public class Results {
    @XmlElement
    public Rate[] rate;

    @Override
    public String toString() {
        String result = "";
        for(Rate rt: rate){
            result += rt + "\n";
        }
        return result;
    }
}
