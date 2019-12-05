package me.mafrans.adventofcode;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FUtil {
    public static String[] GET(String urlString) throws IOException {
        // create the url
        URL url = new URL(urlString);

        // open the url stream, wrap it an a few "readers"
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        // write the output to stdout
        String line;
        List<String> out = new ArrayList<>();
        while ((line = reader.readLine()) != null)
        {
            out.add(line);
        }

        // close our reader
        reader.close();

        return out.toArray(new String[0]);
    }

    public static String[] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        List<String> out = new ArrayList<>();
        while(scanner.hasNextLine()) {
            out.add(scanner.nextLine());
        }

        scanner.close();
        return out.toArray(new String[0]);
    }

    public static String[] readResource(String resource) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(FUtil.class.getClassLoader().getResourceAsStream(resource))));

        List<String> out = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null) {
            out.add(line);
        }

        reader.close();
        return out.toArray(new String[0]);
    }
}
