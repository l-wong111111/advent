import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day5year2024 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int ans = 0;
        boolean a = true;
        ArrayList<String[]> list1 = new ArrayList<>();
        ArrayList<String[]> list2 = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/data");
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).equals("")) {
                a = false;
                continue;
            }
            if (a) {
                list1.add(fileData.get(i).split("\\|"));
            } else {
                list2.add(fileData.get(i).split(","));
            }
        }
        // searching if duplicate numbers exist
//        for (int i = 0; i < list2.size(); i++) {
//            String b = list2.get(i)[1];
//            for (int j = 2; j < list2.get(i).length; j++) {
//                if (list2.get(i)[j].equals(b)) System.out.println("duplicate found");
//            }
//        }
        for (int i = 0; i < list2.size(); i++) {
            boolean isValid = true;
            for (int j = 0; j < list1.size(); j++) {
                String left = list1.get(j)[0];
                String right = list1.get(j)[1];
                int idxleft = -1;
                int idxright = -1;
                for (int k = 0; k < list2.get(i).length; k++) {
                    if (list2.get(i)[k].equals(left)) idxleft = k;
                    if (list2.get(i)[k].equals(right)) idxright = k;
                }
                if (idxleft > idxright) {
                    if (idxright == -1) continue;
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println(Arrays.toString(list2.get(i)));
                int pos = list2.get(i).length / 2;
                ans += Integer.parseInt(list2.get(i)[pos]);
            }
        }
        return ans;
    }

    public static int part2() {
        int ans = 0;
        boolean a = true;
        ArrayList<String[]> list1 = new ArrayList<>();
        ArrayList<String[]> list2 = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/data");
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).equals("")) {
                a = false;
                continue;
            }
            if (a) {
                list1.add(fileData.get(i).split("\\|"));
            } else {
                list2.add(fileData.get(i).split(","));
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            boolean isValid = true;
            for (int j = 0; j < list1.size(); j++) {
                String left = list1.get(j)[0];
                String right = list1.get(j)[1];
                int idxleft = -1;
                int idxright = -1;
                for (int k = 0; k < list2.get(i).length; k++) {
                    if (list2.get(i)[k].equals(left)) idxleft = k;
                    if (list2.get(i)[k].equals(right)) idxright = k;
                }
                if (idxleft > idxright) {
                    if (idxright == -1) continue;
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println(Arrays.toString(list2.get(i)));
                int pos = list2.get(i).length / 2;
                ans += Integer.parseInt(list2.get(i)[pos]);
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
