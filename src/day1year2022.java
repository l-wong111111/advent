import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1year2022 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        int highest = 0;
        int total = 0;
        System.out.println(fileData);
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).isEmpty()) {
                if (highest < total) highest = total;
                total = 0;
            } else {
                total += Integer.parseInt(fileData.get(i));
            }
        }
        System.out.println(highest);
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
