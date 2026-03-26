import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class day2year2024 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        int count = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] nums = fileData.get(i).split(" ");
            int temp = Integer.parseInt(nums[0]);
            int count2 = 0;
            boolean b = true;
            if (temp < Integer.parseInt(nums[nums.length - 1])) b = false;

            for (int j = 1; j < nums.length; j++) {
                if (Math.abs(Integer.parseInt(nums[j]) - temp) <= 3 && Math.abs(Integer.parseInt(nums[j]) - temp) >= 1) {
                    if (Integer.parseInt(nums[j]) > temp == b) {
                        count2++;
                        continue;
                    }
                } else {
                    count2++;
                    continue;
                }
                temp = Integer.parseInt(nums[j]);
            }
            if (count2 < 2) {
                count++;
            } else {
                System.out.println(i);
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
