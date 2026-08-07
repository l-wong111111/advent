import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6year2024 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");

        return ans;
    }

    public static int part2() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        String[][] map = new String[fileData.size()][fileData.get(0).length()];
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(0).length(); j++) {
                map[i][j] = fileData.get(i).substring(j, j + 1);
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("x")) ans++;
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
