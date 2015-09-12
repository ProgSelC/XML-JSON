import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "trains")
public class Timetable {
    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public void add(Train train) {
        if (!existTrain(train.getId())) {
            trains.add(train);
        } else {
            System.out.println("Train is already in timetable");
        }
    }

    public void removeTrain(int id) {
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getId() == id) {
                trains.remove(i);
            }
        }
    }

    public void findTrains(String date, String startTime, String endTime) {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            long startDate = df.parse(date + " " + startTime).getTime();
            long endDate = df.parse(date + " " + endTime).getTime();
            for (Train train : trains) {
                long trainDate = df.parse(train.getDate() + " " + train.getDeparture()).getTime();
                if (trainDate >= startDate && trainDate <= endDate) {
                    System.out.println(train);
                }
            }
        } catch (ParseException e) {
            System.out.println(e.toString());
        }
    }

    public boolean existTrain(int id) {
        boolean result = false;
        for (Train train : trains) {
            if (train.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Trains:\n";
        for (Train train : trains) {
            result += train + "\n";
        }
        return result;
    }
}
