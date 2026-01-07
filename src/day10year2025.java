import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class day10year2025 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        for (int i = 0; i < fileData.size(); i++) {
            String finalLight = fileData.get(i).split(" ")[0];
            finalLight = finalLight.substring(1, finalLight.length() - 1);
            int lightLength = finalLight.length();
            String[] temp = fileData.get(i).split(" ");
            ArrayList<String> switches = new ArrayList<>();
            String temp_ = "";

            // find length of
            for (int k = 0; k < lightLength; k++) {
                temp_ += ".";
            }

            //converting to .# format
            for (int j = 1; j < temp.length - 1; j++) {
                String conversion = temp_;
                String[] moreTemp = temp[j].split("[^0-9]"); //first index val is empty string
                System.out.println(moreTemp[0]);
            }

        }
    }

    public static String addStrings(String s1, String s2) {
        String finalStr = "";
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
               finalStr += "." ;
            } else {
                finalStr += "#";
            }
        }
        return finalStr;
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
