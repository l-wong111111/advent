import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6year2025 {
    public static void main(String[] args) {
        //System.out.println(part1());
        System.out.println(part2());
    }

    public static long part1() {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> signs = new ArrayList<>();
        Integer[][] numbers = new Integer[4][1000000];
        long totalVal = 0;
        System.out.println(fileData);
        for (int i = 0; i < 4; i++) {
            String line = fileData.get(i);
            for (int j = 0; j < line.split("\\s+").length ; j++) {
                numbers[i][j] = Integer.parseInt(line.split("\\s+")[j]);
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
        String line = fileData.get(4);
        for (int j = 0; j < line.split("\\s+").length ; j++) {
            signs.add(line.split("\\s+")[j]);
        }
        System.out.println(signs);
        for (int i = 0; i < line.split("\\s+").length; i++) {
            Long val = 0L;
            if (signs.get(i).equals("+")) {
                val += numbers[0][i];
                val += numbers[1][i];
                val += numbers[2][i];
                val += numbers[3][i];
            } else {
                val += numbers[0][i];
                val *= numbers[1][i];
                val *= numbers[2][i];
                val *= numbers[3][i];
            }
            if (val < 0) System.out.println(); //checks if any integers are more than 32 bit int limit which means have to change data types to long
            totalVal += val;
        }
        return totalVal;
    }

    public static long part2() {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add(fileData.get(0));
        numbers.add(fileData.get(1));
        numbers.add(fileData.get(2));
        numbers.add(fileData.get(3));
        String signs = fileData.get(4);
        long totalVal = 0L;
        boolean add = true;
        long val = 0;
        System.out.println(signs);
        System.out.println(numbers.get(0).length());
        for (int i = 0; i < numbers.get(0).length(); i++) {
            if (i < signs.length()) {
                add = (signs.charAt(i) == '+') || (add && signs.charAt(i) == ' ');//4 variations, is +, was +, is *, was *
            }
            long tempVal = 0;
            for (int j = 0; j < 4; j++) {
                if (!numbers.get(j).substring(i, i + 1).equals(" ")) {
                    tempVal = tempVal * 10 + Integer.parseInt(numbers.get(j).substring(i, i + 1));
                }
            }
            if (add) {
                val += tempVal;
            } else {
                if (val == 0) val = 1;
                if (tempVal == 0) tempVal = 1;
                val *= tempVal;
            }
            if (i < signs.length() - 1) {
                if (signs.charAt(i + 1) == '+' || signs.charAt(i + 1) == '*') {
                    totalVal += val;
                    val = 0;
                }
            }
            tempVal = 0;
        }
        return totalVal + val;
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
