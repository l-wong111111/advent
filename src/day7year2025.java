import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day7year2025 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        String[][] grid = get2DArray(fileData);
        // set position to first line
        // change data file first line from S to |
        String position = ".......................................................................|.......................................................................";
        int count = 0;
        int inc = 0;
        for (int i = 0; i < grid.length; i++) {
            inc = 0;
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
                if (grid[i][j].equals("^") && position.charAt(j) == '|') {
                    count++;
                    position = position.substring(0, j - 1) + "|.|"  + position.substring(j + 2);
                    inc++;
                }
            }
            System.out.println(inc);
            System.out.println(position);
        }
        System.out.println(count);
    }

    public static String[][] get2DArray(ArrayList<String> fileData) {

        String borderRow = "";
        for (int i = 0; i < fileData.get(0).length(); i++) {
            borderRow += ".";
        }

        fileData.add(0, borderRow);
        fileData.add(borderRow);

        for (int i = 0; i < fileData.size(); i++) {
            String s = fileData.get(i);
            s = "." + s + ".";
            fileData.set(i, s);
        }

        int rows = fileData.size();
        int cols = fileData.get(0).length();
        String[][] grid = new String[rows][cols];


        for (int i = 0; i < fileData.size(); i++) {
            String row = fileData.get(i);
            for (int j = 0; j < row.length(); j++) {
                String entry = row.substring(j, j+1);
                grid[i][j] = entry;
            }
        }

        return grid;
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

