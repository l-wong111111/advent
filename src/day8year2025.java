import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day8year2025 {
    public static void main(String[] args) {
        System.out.println(part1());
    }

    public static long part1() {
        ArrayList<String> fileData = getFileData("src/data");
        long totalVal = 0;
        long minimumVal = 0;
        ArrayList<Integer> circuits = new ArrayList<>();
        ArrayList<String> pairs = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = i; j < fileData.size(); j++) {
                if (pairs )
            }
        }
        return totalVal;
    }

    public static long getDistance(String s1, String s2) {
        long val1 = (long) Math.pow(Integer.parseInt(s1.split(",")[0]) - Integer.parseInt(s2.split(",")[0]), 2);
        long val2 = (long) Math.pow(Integer.parseInt(s1.split(",")[1]) - Integer.parseInt(s2.split(",")[1]), 2);
        long val3 = (long) Math.pow(Integer.parseInt(s1.split(",")[2]) - Integer.parseInt(s2.split(",")[2]), 2);
        return (long) Math.sqrt(val1 + val2 + val3);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
