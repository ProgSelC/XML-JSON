import javax.xml.bind.annotation.*;

@XmlRootElement(name = "query")
public class Query {
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public int count;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String created;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String lang;
    @XmlElement
    public Results results;

    @Override
    public String toString() {
        return  "Results quantity=" + count +
                ", Created='" + created + '\'' +
                ", Language='" + lang + '\'' +
                ", Results:\n" + results;
    }
}
