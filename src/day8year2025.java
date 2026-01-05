import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class day8year2025 {
    public static void main(String[] args) {
        System.out.println(part1());
    }

    public static long part1() {
        ArrayList<String> fileData = getFileData("src/data");
        System.out.println(fileData);
        long totalVal = 0;
        ArrayList<Double> distances = new ArrayList<>();
        ArrayList<String> pairs = new ArrayList<>();
        ArrayList<String> pairs2 = new ArrayList<>();
        ArrayList<Integer> pairsizes = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = i + 1; j < fileData.size(); j++) {
                distances.add(getDistance(fileData.get(i), fileData.get(j)));
                pairs.add(i + "," + j);
            }
        }
        System.out.println(pairs);
        for (int i = 0; i < 1000; i++) {
            System.out.println(Collections.min(distances));
            int minIndex = distances.indexOf(Collections.min(distances));
            pairs2.add(pairs.get(minIndex));
            distances.remove(minIndex);
            pairs.remove(minIndex);
        }
        System.out.println(pairs2);
        while (!pairs2.isEmpty()) {
            ArrayList<Integer> nums = new ArrayList<>();
            ArrayList<Integer> nums2 = new ArrayList<>();
            nums.add(Integer.parseInt(pairs2.get(0).split(",")[0]));
            nums.add(Integer.parseInt(pairs2.get(0).split(",")[1]));
            pairs2.remove(0);
            boolean foundNewPair = true;
            while (foundNewPair) {
                foundNewPair = false;
                for (int i = 0; i < pairs2.size(); i++) {
                    int object1 = Integer.parseInt(pairs2.get(i).split(",")[0]);
                    int object2 = Integer.parseInt(pairs2.get(i).split(",")[1]);
                    if (nums.contains(object1) || nums.contains(object2)) {
                        foundNewPair = true;
                        nums.add(object1);
                        nums.add(object2);
                        pairs2.remove(i);
                    }
                }
            }
            for (int i = 0; i < nums.size() ; i++) {
                if (!nums2.contains(nums.get(i))) {
                    nums2.add(nums.get(i));
                }
            }
            System.out.println(nums2);
            pairsizes.add(nums2.size());
        }
        System.out.println(pairsizes);
        pairsizes.sort(Comparator.reverseOrder());
        totalVal = (long) pairsizes.get(0) * pairsizes.get(1) * pairsizes.get(2);
        return totalVal;
    }

    public static double getDistance(String s1, String s2) {
        double val1 = Math.pow(Integer.parseInt(s1.split(",")[0]) - Integer.parseInt(s2.split(",")[0]), 2);
        double val2 = Math.pow(Integer.parseInt(s1.split(",")[1]) - Integer.parseInt(s2.split(",")[1]), 2);
        double val3 = Math.pow(Integer.parseInt(s1.split(",")[2]) - Integer.parseInt(s2.split(",")[2]), 2);
        return Math.sqrt(val1 + val2 + val3);
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
