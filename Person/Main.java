import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("json.txt"));
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            Gson gson = new GsonBuilder().create();

            JSON json = (JSON) gson.fromJson(sb.toString(), JSON.class);

            System.out.println(json);

        } catch (IOException e) {
            System.out.println(e);
        }


    }
}
