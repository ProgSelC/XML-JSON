import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Timetable timetable = null;
        try {
            File file = new File("timetable.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Timetable.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            timetable = (Timetable) unmarshaller.unmarshal(file);

            System.out.println(timetable);

            timetable.add(new Train(3, "Kyiv", "Lviv", "19.12.2013", "18:45"));

            timetable.findTrains("19.12.2013", "15:00", "19:00");

            Marshaller marshaller = jaxbContext.createMarshaller();
            // читабельное форматирование
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // пишем в файл
            marshaller.marshal(timetable, file);
            //marshaller.marshal(timetable, System.out);

        } catch (JAXBException e) {
            System.out.println(e.toString());
        }
    }
}
