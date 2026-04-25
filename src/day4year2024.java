import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4year2024 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                String line = fileData.get(i);
                if (j < fileData.get(i).length() - 3) { // left and right
                    if (line.substring(j, j + 4).equals("XMAS")) ans++;
                    if (line.substring(j, j + 4).equals("SAMX")) ans++;
                }
                if (i < fileData.size() - 3) { // up and down
                    if (fileData.get(i).charAt(j) == 'X' && fileData.get(i + 1).charAt(j) == 'M' && fileData.get(i + 2).charAt(j) == 'A' && fileData.get(i + 3).charAt(j) == 'S') ans++;
                    if (fileData.get(i).charAt(j) == 'S' && fileData.get(i + 1).charAt(j) == 'A' && fileData.get(i + 2).charAt(j) == 'M' && fileData.get(i + 3).charAt(j) == 'X') ans++;
                }
                if (i < fileData.size() - 3 && j < fileData.get(i).length() - 3) { //diagonal up to down
                    if (fileData.get(i).charAt(j) == 'X' && fileData.get(i + 1).charAt(j + 1) == 'M' && fileData.get(i + 2).charAt(j + 2) == 'A' && fileData.get(i + 3).charAt(j + 3) == 'S') ans++;
                    if (fileData.get(i).charAt(j) == 'S' && fileData.get(i + 1).charAt(j + 1) == 'A' && fileData.get(i + 2).charAt(j + 2) == 'M' && fileData.get(i + 3).charAt(j + 3) == 'X') ans++;
                }
                if (i >= 3 && j < fileData.get(i).length() - 3) { //diagonal down to up
                    if (fileData.get(i).charAt(j) == 'X' && fileData.get(i - 1).charAt(j + 1) == 'M' && fileData.get(i - 2).charAt(j + 2) == 'A' && fileData.get(i - 3).charAt(j + 3) == 'S') ans++;
                    if (fileData.get(i).charAt(j) == 'S' && fileData.get(i - 1).charAt(j + 1) == 'A' && fileData.get(i - 2).charAt(j + 2) == 'M' && fileData.get(i - 3).charAt(j + 3) == 'X') ans++;
                }
            }
        }
        return ans;
    }

    public static int part2() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> coords = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                int temp = 0;
                if (i < fileData.size() - 2 && j < fileData.get(i).length() - 2) { //diagonal up to down
                    if (fileData.get(i).charAt(j) == 'M' && fileData.get(i + 1).charAt(j + 1) == 'A' && fileData.get(i + 2).charAt(j + 2) == 'S') temp++;
                    if (fileData.get(i).charAt(j) == 'S' && fileData.get(i + 1).charAt(j + 1) == 'A' && fileData.get(i + 2).charAt(j + 2) == 'M') temp++;
                }
                if (i < fileData.size() - 2 && j < fileData.get(i).length() - 2) { //diagonal down to up
                    if (fileData.get(i + 2).charAt(j) == 'M' && fileData.get(i + 1).charAt(j + 1) == 'A' && fileData.get(i).charAt(j + 2) == 'S') temp++;
                    if (fileData.get(i + 2).charAt(j) == 'S' && fileData.get(i + 1).charAt(j + 1) == 'A' && fileData.get(i).charAt(j + 2) == 'M') temp++;
                }
                if (temp == 2) ans++;
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
