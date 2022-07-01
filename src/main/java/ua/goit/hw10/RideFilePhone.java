package ua.goit.hw10;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RideFilePhone {
    public static void main(String[] args) throws IOException {

        String pattern = "(\\(\\d{3}\\)|\\d{3})(\\s|-)\\d{3}\\-\\d{4}";
        Pattern r = Pattern.compile(pattern);

        Scanner scanner = new Scanner(new FileReader("test1.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher m = r.matcher(line);
            if (m.find()) {
                System.out.println(line);
            }
        }
        scanner.close();
    }
}
