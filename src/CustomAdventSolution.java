import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomAdventSolution {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        long initialPyramidSize = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (String s : fileData.get(i).split("\\.")) {
                initialPyramidSize += Long.parseLong(s);
            }
        }
        long numOfRings = fileData.size() / 2 + 1;
        long finalPyramidSize = (numOfRings * (2 * numOfRings + 1) * (2 * numOfRings - 1)) / 3;
        System.out.println(finalPyramidSize - initialPyramidSize);
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
