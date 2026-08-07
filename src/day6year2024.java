import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
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
        String[][] map = new String[fileData.size()][fileData.get(0).length()];
        int xPos = 0;
        int yPos = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(0).length(); j++) {
                map[i][j] = fileData.get(i).substring(j, j + 1);
                if (map[i][j].equals("^")) {
                    xPos = j;
                    yPos = i;
                }
//                System.out.print(map[i][j]);
            }
//            System.out.println();
        }

        boolean outOfBounds = false;
        String type = "up";
        while (!outOfBounds) {
            try {
                System.out.println(xPos + " " + yPos);
                if (type.equals("up")) {
                    if (map[yPos - 1][xPos].equals("#")) {
                        type = "right";
                        continue;
                    }
                    yPos -= 1;
                    map[yPos][xPos] = "x";
                }
                if (type.equals("right")) {
                    if (map[yPos][xPos + 1].equals("#")) {
                        type = "down";
                        continue;
                    }
                    xPos += 1;
                    map[yPos][xPos] = "x";
                }
                if (type.equals("down")) {
                    if (map[yPos + 1][xPos].equals("#")) {
                        type = "left";
                        continue;
                    }
                    yPos += 1;
                    map[yPos][xPos] = "x";
                }
                if (type.equals("left")) {
                    if (map[yPos][xPos - 1].equals("#")) {
                        type = "up";
                        continue;
                    }
                    xPos -= 1;
                    map[yPos][xPos] = "x";
                }



            } catch (Exception e) {
                outOfBounds = true;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
                if (map[i][j].equals("x")) ans++;
            }
            System.out.println();
        }
        return ans + 1;
    }

    public static int part2() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");

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
