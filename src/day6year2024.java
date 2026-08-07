import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6year2024 {
    public static void main(String[] args) {
        // ran part 1 130 x 130 times to test the speed if i can brute force by placing a new barrier everywhere
//        for (int i = 0; i < (130 * 130); i++) {
//            part1();
//        }
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        String[][] map = new String[fileData.size()][fileData.get(0).length()];
        int xPos = 0;
        int yPos = 0;
//        System.out.println(fileData.size());
//        System.out.println(fileData.get(0).length());
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
//                System.out.println(xPos + " " + yPos);
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
        //option 5 is a special example, the loop is 2 squares
        //plan is probably to test every position of a new # and see if it hits the # twice, which means it will loop
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        String[][] initialMap = new String[fileData.size()][fileData.get(0).length()];
        int initXPos = 0;
        int initYPos = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(0).length(); j++) {
                initialMap[i][j] = fileData.get(i).substring(j, j + 1);
                if (initialMap[i][j].equals("^")) {
                    initXPos = j;
                    initYPos = i;
                }
            }
        }
        for (int rows = 0; rows < fileData.size(); rows++) {
            for (int cols = 0; cols < fileData.get(0).length(); cols++) {
                if (rows == initYPos && cols == initXPos) continue;
                if (initialMap[rows][cols].equals("#")) continue;
                String[][] map = new String[initialMap.length][];
                for (int i = 0; i < map.length; i++) {
                    map[i] = initialMap[i].clone();
                }
                int xPos = initXPos;
                int yPos = initYPos;
                map[rows][cols] = "#";
                int count = 0;
                int steps = 0;

                boolean outOfBounds = false;
                String type = "up";
                while (!outOfBounds) {
                    steps++;
                    try {
                        //im guessing 112, 15 puts you in a different loop that doesnt involve the blockade placed
//                        if (ans == 58) System.out.println(rows + " " + cols);
                        if (type.equals("up")) {
                            if (map[yPos - 1][xPos].equals("#")) {
                                type = "right";
                                if (yPos - 1 == rows && xPos == cols) count++;
                                continue;
                            }
                            yPos -= 1;
                            map[yPos][xPos] = "x";
                        }
                        if (type.equals("right")) {
                            if (map[yPos][xPos + 1].equals("#")) {
                                type = "down";
                                if (yPos == rows && xPos + 1 == cols) count++;
                                continue;
                            }
                            xPos += 1;
                            map[yPos][xPos] = "x";
                        }
                        if (type.equals("down")) {
                            if (map[yPos + 1][xPos].equals("#")) {
                                type = "left";
                                if (yPos + 1 == rows && xPos == cols) count++;
                                continue;
                            }
                            yPos += 1;
                            map[yPos][xPos] = "x";
                        }
                        if (type.equals("left")) {
                            if (map[yPos][xPos - 1].equals("#")) {
                                type = "up";
                                if (yPos == rows && xPos - 1 == cols) count++;
                                continue;
                            }
                            xPos -= 1;
                            map[yPos][xPos] = "x";
                        }
                    } catch (Exception e) {
                        outOfBounds = true;
                    }
                    if (count >= 2 || steps > 1000000) {
                        ans++;
                        System.out.println(ans);
                        break;
                    }
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
