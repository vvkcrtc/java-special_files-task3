import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Main {


    private static String readString(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = reader.readLine();
            return line;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Employee> jsonToList(String jsonStr) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Employee[] myArray = gson.fromJson(jsonStr, Employee[].class);
        List<Employee> myList = Arrays.asList(myArray);
        return myList;
    }


    public static void main(String[] args)  {

        String json = readString("data.json");
        List<Employee> list = jsonToList(json);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());

        }

    }
}
