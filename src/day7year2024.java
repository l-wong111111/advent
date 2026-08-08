import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day7year2024 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static long part1() {
        long ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        for (int i = 0; i < fileData.size(); i++) {
            long val = Long.parseLong(fileData.get(i).split(":")[0]);
            String[] tempNums = fileData.get(i).split(" ");
            int[] nums = new int[tempNums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(tempNums[j + 1]);
            }

            for (int j = 0; j < Math.pow(2, nums.length); j++) {
                long result = nums[0];
                for (int k = 1; k < nums.length; k++) {
                    if (((j >> (k - 1)) & 1) == 1) { // shifting bits and checking the values of each bit for adding/multiply
                        result += nums[k];
                    } else {
                        result *= nums[k];
                    }
                }
                if (result == val) {
                    ans += val;
                    System.out.println(Arrays.toString(nums));
                    break;
                }
            }
        }
        return ans;
    }

    public static long part2() {
        long ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        for (int i = 0; i < fileData.size(); i++) {
            long val = Long.parseLong(fileData.get(i).split(":")[0]);
            String[] tempNums = fileData.get(i).split(" ");
            int[] nums = new int[tempNums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(tempNums[j + 1]);
            }

            for (int j = 0; j < Math.pow(3, nums.length); j++) {
                long result = nums[0];
                int num = j;
                for (int k = 1; k < nums.length; k++) {
                    int option = num % 3;
                    if (option == 0) {
                        result += nums[k];
                    }
                    if (option == 1) {
                        result *= nums[k];
                    }
                    if (option == 2) {
                        String combined = result + "" + nums[k];
                        result = Long.parseLong(combined);
                    }
                    num /= 3;
                }
                if (result == val) {
                    ans += val;
                    System.out.println(Arrays.toString(nums));
                    break;
                }
            }
        }
        return ans;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
