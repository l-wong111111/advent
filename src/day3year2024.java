import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3year2024 {
    public static void main(String[] args) {
        System.out.println(part1());
    }

    public static int part1() {
        int ans = 0;
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String line = fileData.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (!line.substring(j).contains("mul(")) {
                    break;
                }
                if (line.substring(j, j + 4).equals("mul(")) {
                    int val = j + 4;
                    char character = line.charAt(val);
                    boolean valid = true;
                    while (!(character == ')') ) {
                        if (!Character.isDigit(character) && !(character == ',')) {
                            valid = false;
                            break;
                        }
                        val++;
                        character = line.charAt(val);
                    }
                    if (valid) {
                        list.add(line.substring(j + 4, val));
                    }
                }
            }
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int v1 = Integer.parseInt(list.get(i).split(",")[0]);
            int v2 = Integer.parseInt(list.get(i).split(",")[1]);
            ans += (v1 * v2);
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
