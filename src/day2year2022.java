import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2year2022 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> opp = new ArrayList<>();
        ArrayList<String> you = new ArrayList<>();
        int totalScore = 0;
        for (int i = 0; i < fileData.size(); i++) {
            opp.add(fileData.get(i).split(" ")[0]);
            you.add(fileData.get(i).split(" ")[1]);
        }
        for (int i = 0; i < you.size(); i++) {
            String conversion = "";
            String yourVal = opp.get(i);
            int score = 0;
            if (yourVal.equals("A")) conversion = "X";
            if (yourVal.equals("B")) conversion = "Y";
            if (yourVal.equals("C")) conversion = "Z";
            if (conversion.equals(you.get(i))) {
                score += 3;
            }
            if (yourVal.equals("X")) {
                score++;
                if (yourVal.equals("Y")) score
            }
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
