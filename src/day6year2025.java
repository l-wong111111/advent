import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class day6year2025 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        Integer[][] numbers = new Integer[3][1000000];
        for (int i = 0; i < 4; i++) {
            String[] line = fileData.get(i).split(" ");
            for (int j = 0; j < line.length ; j++) {
                numbers[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(numbers);
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
