import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Rate {
    @XmlAttribute
    public String id;
    @XmlElement
    public String Name;
    @XmlElement
    public double Rate;
    @XmlElement
    public String Date;
    @XmlElement
    public String Time;
    @XmlElement
    public String Ask;
    @XmlElement
    public String Bid;

    @Override
    public String toString() {
        return  "Rate-id='" + id + '\'' +
                ", Rate-Name='" + Name + '\'' +
                ", Rate=" + Rate +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Ask='" + Ask + '\'' +
                ", Bid='" + Bid + '\'';
    }
}
