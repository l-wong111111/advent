import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

public class day3year2022 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> firstHalf = new ArrayList<>();
        ArrayList<String> secondHalf = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            firstHalf.add(fileData.get(i).substring(0, fileData.get(i).length() / 2));
            secondHalf.add(fileData.get(i).substring(fileData.get(i).length() / 2));
        }
        for (int i = 0; i < firstHalf.size(); i++) {
            ArrayList<String> chars = new ArrayList<>();
            for (int j = 0; j < firstHalf.get(i).length(); j++) {
                if (firstHalf.get(i).charAt(j) == secondHalf.get(i).charAt(j) && !chars.contains(firstHalf.get(i).charAt(j))) {
                    chars.add(firstHalf.get(i).substring(i, i + 1));
                }
            }
            System.out.println(chars);
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                //if (!line.equals(""))
                fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
