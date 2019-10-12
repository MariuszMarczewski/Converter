package pl.sda;

import pl.sda.converter.FileConverter;

public class App {
    public static void main(String[] args) {
        FileConverter converter = new FileConverter();
        String sourceFilePath = "C:\\Users\\lenovo\\IdeaProjects\\SDA_J19_Converter\\src\\main\\resources\\testOut.xlsx";
        String outputFilePath = "C:\\Users\\lenovo\\IdeaProjects\\SDA_J19_Converter\\src\\main\\resources\\testOut2.json";
        converter.convert(sourceFilePath, outputFilePath);
    }
}
