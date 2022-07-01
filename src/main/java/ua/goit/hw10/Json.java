package ua.goit.hw10;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Json {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("test2.txt"));
        List<User> array = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextLine()) {
            i++;
            String line = scanner.nextLine();
            if (i > 1) {
                String name = "";
                String age = "";
                String[] words = line.split(" ");
                int j = 0;
                for (String newword : words) {
                    j++;
                    if (j == 1) {
                        name = newword;
                    }
                    if (j == 2) {
                        age = newword;
                    }
                }
                array.add(new User(name, age));
            }
        }
        scanner.close();
        String jsonString = new Gson().toJson(array);
        try (PrintWriter out = new PrintWriter(new FileWriter("user.json"))) {
            out.write(jsonString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class User {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
