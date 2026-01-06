import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class day9year2025 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static long part1() {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<Long> nums1 = new ArrayList<>();
        ArrayList<Long> nums2 = new ArrayList<>();
        ArrayList<Long> areas = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            nums1.add(Long.parseLong(fileData.get(i).split(",")[0]));
            nums2.add(Long.parseLong(fileData.get(i).split(",")[1]));
        }
        System.out.println(nums2);
        System.out.println(nums1);
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                areas.add(((Math.abs(nums1.get(i) - nums1.get(j)) + 1) * (Math.abs(nums2.get(i) - nums2.get(j)) + 1))); // use + 1 because finding the difference in length and width and adding to the missing initial length and width
            }
        }
        Long largestVal = Collections.max(areas);
        return largestVal;
    }

    public static long part2() {
        // planning notes here: first find every connection between the points by finding
        // coords with common x values or common y values

        //  ..............  lines can make these shape things possibly so make a maze like algorithm
        //  #XXXXXX#XXX#..  where you find spots that wont be part of a shape and see if
        //  X......XXXXX..  rectangles contain them to decide if you ignore the rectangle area or not
        //  X.#XXXX#XXXX..
        //  X.XXXXXXXXXX..
        //  X.#XXXXXX#XX..
        //  X........XXX..
        //  X........#X#..
        //  #.............
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<Long> nums1 = new ArrayList<>();
        ArrayList<Long> nums2 = new ArrayList<>();
        ArrayList<String> connections = new ArrayList<>();
        ArrayList<String> connectionPoints = new ArrayList<>();
        String[][] map = new String[100][100];
        ArrayList<Long> areas = new ArrayList<>();

        for (int i = 0; i < fileData.size(); i++) {
            nums1.add(Long.parseLong(fileData.get(i).split(",")[0]));
            nums2.add(Long.parseLong(fileData.get(i).split(",")[1]));
        }

        for (int i = 0; i < nums1.size(); i++) {
            for (int j = i + 1; j < nums1.size(); j++) {
                if (nums1.get(i) == nums1.get(j)) {
                    connections.add(fileData.get(i) + " " + fileData.get(j));
                    connectionPoints.add(fileData.get(i));
                    connectionPoints.add(fileData.get(j));
                }
                if (nums2.get(i) == nums2.get(j)) {
                    connections.add(fileData.get(i) + " " + fileData.get(j));
                    connectionPoints.add(fileData.get(i));
                    connectionPoints.add(fileData.get(j));
                }
            }
        }
        System.out.println(connections);
        for (int i = 0; i < connectionPoints.size(); i++) {
            int xVal = Integer.parseInt(connectionPoints.get(i).split(",")[0]);
            int yVal = Integer.parseInt(connectionPoints.get(i).split(",")[1]);
            map[xVal][yVal] = "X";
            for (int j = ; j < ; j++) {

            }
        }
        return 2;
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
