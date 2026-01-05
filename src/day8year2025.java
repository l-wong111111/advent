import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class day8year2025 {
    public static void main(String[] args) {
        //long part1Ans = part1();
        long part2Ans = part2();
        //System.out.println(part1Ans);
        System.out.println(part2Ans);
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

    public static long part2() {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<Double> distances = new ArrayList<>();
        ArrayList<String> pairs = new ArrayList<>();
        ArrayList<String> pairs2 = new ArrayList<>();
        ArrayList<Boolean> boo = new ArrayList<>();
        String mostRecentPair = "";
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = i + 1; j < fileData.size(); j++) {
                distances.add(getDistance(fileData.get(i), fileData.get(j)));
                pairs.add(i + "," + j);
            }
        }
        while (pairs2.size() < 50000) {
            int minIndex = distances.indexOf(Collections.min(distances));
            pairs2.add(pairs.get(minIndex));
            distances.remove(minIndex);
            pairs.remove(minIndex);
            System.out.println(distances.size()); // while loop condition was initially (!distances.isEmpty())
            // but there are 500000 values in distances that took a while to run so i just took the
            // 50000 smallest distances and their cords, the last distance that combines every
            // junction box is the 5470th smallest distance so the condition could be pairs.size() < 10000
        }
        int pos = pairs2.indexOf("362,954");
        for (int i = 0; i < fileData.size(); i++) {
            boo.add(false);
        }
        boo.set(Integer.parseInt(pairs2.get(0).split(",")[0]), true);
        boo.set(Integer.parseInt(pairs2.get(0).split(",")[1]), true);
        pairs2.remove(0);
        while (boo.contains(false)) {
            for (int i = 0; ;i++) {
                int object1 = Integer.parseInt(pairs2.get(i).split(",")[0]);
                int object2 = Integer.parseInt(pairs2.get(i).split(",")[1]);
                mostRecentPair = pairs2.get(i);
                if (boo.get(object1)) {
                    boo.set(object2, true);
                    pairs2.remove(i);
                    break;
                }
                if (boo.get(object2)) {
                    boo.set(object1, true);
                    pairs2.remove(i);
                    break;
                }
            }
        }
        System.out.println(mostRecentPair);
        System.out.println(pos);
        System.out.println(fileData.get(Integer.parseInt(mostRecentPair.split(",")[0])));
        System.out.println(fileData.get(Integer.parseInt(mostRecentPair.split(",")[1])));
        int val1 = Integer.parseInt(fileData.get(Integer.parseInt(mostRecentPair.split(",")[0])).split(",")[0]);
        int val2 = Integer.parseInt(fileData.get(Integer.parseInt(mostRecentPair.split(",")[1])).split(",")[0]);
        return (long) val1 * val2;
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
