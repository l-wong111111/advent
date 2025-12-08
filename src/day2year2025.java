import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2year2025 {
    public static void main(String[] args) {

        // Day 2 data parsing set up
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<Long> productIDs = new ArrayList<Long>();
        for (String s : fileData.get(0).split(",")) {
            long first = Long.parseLong(s.split("-")[0]);
            long second = Long.parseLong(s.split("-")[1]);
            for (long i = first; i <= second; i++) {
                productIDs.add(i);
            }
        }
        // Day 2 data parsing set up complete
        // "productIDs" is a list of "long" variables that make up each product ID from the file

        long partOneAnswer = 0;
        long partTwoAnswer = 0;

        for (Long p : productIDs) {
            if (isValidProductID(p)) {
                partOneAnswer += p;
            }

        }
        for (Long p : productIDs) {
            if (isValidProductID2(p)) {
                partTwoAnswer += p;
            }
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static boolean isValidProductID(long productID) {
        String pID = productID + "";
        String firstHalf = pID.substring(0, pID.length() / 2);
        String secondHalf = pID.substring(pID.length() / 2);
        return secondHalf.equals(firstHalf);
    }

    public static boolean isValidProductID2(long productID) {
        String pID = productID + "";

        for (int i = 1; i <= pID.length() / 2; i++) {
            String cutStr = pID.substring(0, i);
            boolean isValid = true;
            for (int j = i; j < pID.length(); j += i) {
                if (pID.length() % i != 0) {
                    isValid = false;
                    break;
                }
                if (!cutStr.equals(pID.substring(j, j + i))) isValid = false;
            }
            if (isValid) return true;
        }
        return false;
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