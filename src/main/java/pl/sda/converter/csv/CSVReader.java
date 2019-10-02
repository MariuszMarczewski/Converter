package pl.sda.converter.csv;

import pl.sda.converter.SDAFileReader;
import pl.sda.converter.exceptions.FileConverterException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader implements SDAFileReader {

    @Override
    public List<Map<String, Object>> read(String filePath) {
        List<Map<String, Object>> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = bufferedReader.readLine();
            String[] headers = firstLine.split(";");

            String line1;
            while ((line1 = bufferedReader.readLine()) != null) {
                String[] tokens = line1.split(";");

                Map<String, Object> record = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++ ){
                    record.put(headers[i], tokens[i]);
                }
                result.add(record);
            }

        } catch (FileNotFoundException e) {
            throw new FileConverterException("Nie odnalezion pliku");
        } catch (IOException e) {
            throw new FileConverterException("Wystąpił błąd w trakcie przetwarzania pliku", e);
        }

        return result;
    }

}
