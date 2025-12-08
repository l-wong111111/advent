import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3year2025 {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        long partTwoAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }
        for (String batteries : fileData) {
            long voltage = getLargestCombinationPart2(batteries);
            partTwoAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        int firstNum = 0;
        int secondNum = 0;
        for (int i = 9; ; i--) {
            if (batteries.substring(0, batteries.length() - 1).contains(i + "")) {
                firstNum = i;
                break;
            }
        }
        String cutStr = batteries.substring(batteries.indexOf(firstNum + "") + 1);
        for (int i = 9; i > 0; i--) {
            if (cutStr.contains(i + "")) {
                secondNum = i;
                break;
            }
        }
        System.out.println(firstNum + "" + secondNum);
        System.out.println(cutStr);
        return firstNum * 10 + secondNum;
    }

    public static long getLargestCombinationPart2(String batteries) {
        long addNum = 0;
        long finalNum = 0;
        String cutStr = batteries;
        for (int a = 11; a > -1; a--) {
            for (int i = 9; ; i--) {
                if (cutStr.substring(0, cutStr.length() - a).contains(i + "")) {
                    addNum = i;
                    break;
                }
            }
            cutStr = cutStr.substring(cutStr.indexOf(addNum + "") + 1);
            finalNum = finalNum * 10 + addNum;
        }
        return finalNum;
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