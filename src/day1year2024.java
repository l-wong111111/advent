import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class day1year2024 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        System.out.println(fileData);
        ArrayList<Integer> data1 = new ArrayList<>();
        ArrayList<Integer> data2 = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            for (String s : fileData.get(i).split("   ")) {
                data1.add(Integer.parseInt(s));
                data2.add(Integer.parseInt(s));
            }
        }
        for (int i = 0; i < fileData.size(); i++) {
            data1.remove(i + 1);
            data2.remove(i);
        }
        data1.sort(Comparator.naturalOrder());
        data2.sort(Comparator.naturalOrder());
        System.out.println(data1);
        System.out.println(data2);
        int val = 0;
        for (int i = 0; i < data1.size(); i++) {
            val += Math.abs((data2.get(i) - data1.get(i)));
        }
        System.out.println("Part 1 Answer = " + val);
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
