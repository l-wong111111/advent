import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day12year2025 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        int count = 0;
        for (int i = 0; i < fileData.size(); i++) {
            int val = 0;
            String[] nums = fileData.get(i).split(" ");
            int max = Integer.parseInt(nums[0].substring(0, 2)) * Integer.parseInt(nums[0].substring(3, 5));
            for (int j = 1; j < 7; j++) {
                val += Integer.parseInt(nums[j]);
            }
            if (val * 8 < max) {
                count++;
                System.out.println(fileData.get(i));
            }
        }
        System.out.println(count);
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
