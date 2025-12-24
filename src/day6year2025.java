import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class day6year2025 {
    public static void main(String[] args) {
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
        System.out.println(totalVal);
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
