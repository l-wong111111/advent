import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2year2022 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> opp = new ArrayList<>();
        ArrayList<String> you = new ArrayList<>();
        int score = 0;
        for (int i = 0; i < fileData.size(); i++) {
            opp.add(fileData.get(i).split(" ")[0    ]);
            you.add(fileData.get(i).split(" ")[1]);
        }
        System.out.println(opp);
        System.out.println(you);
        for (int i = 0; i < you.size(); i++) {
            String conversion = "";
            String oppVal = opp.get(i);
            if (oppVal.equals("A")) conversion = "X";
            if (oppVal.equals("B")) conversion = "Y";
            if (oppVal.equals("C")) conversion = "Z";
            if (conversion.equals(you.get(i))) {
                score += 3;
            }
            if (you.get(i).equals("X")) {
                score++;
                if (conversion.equals("Z")) score += 6;
            }
            if (you.get(i).equals("Y")) {
                score += 2;
                if (conversion.equals("X")) score += 6;
            }
            if (you.get(i).equals("Z")) {
                score += 3;
                if (conversion.equals("Y")) score += 6;
            }
        }
        int score1 = score;
        score = 0;
        for (int i = 0; i < you.size(); i++) {
            String conversion = "";
            String oppVal = opp.get(i);
            if (oppVal.equals("A")) conversion = "X";
            if (oppVal.equals("B")) conversion = "Y";
            if (oppVal.equals("C")) conversion = "Z";
            if (you.get(i).equals("X")) {
                if (conversion.equals("X")) score += 3;
                if (conversion.equals("Y")) score += 1;
                if (conversion.equals("Z")) score += 2;
            }
            if (you.get(i).equals("Y")) {
                score += 3;
                if (conversion.equals("X")) score += 1;
                if (conversion.equals("Y")) score += 2;
                if (conversion.equals("Z")) score += 3;
            }
            if (you.get(i).equals("Z")) {
                score += 6;
                if (conversion.equals("X")) score += 2;
                if (conversion.equals("Y")) score += 3;
                if (conversion.equals("Z")) score += 1;
            }
        }
        System.out.println(score1);
        System.out.println(score);
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
