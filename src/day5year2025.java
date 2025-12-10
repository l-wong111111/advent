import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// for this Day, I made an "IngredientRange" object that holds two numbers
// the minimum and the maximum for the range in the file
public class day5year2025 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<IngredientRange> ranges = new ArrayList<>();
        ArrayList<Long> ingredients = new ArrayList<Long>();

        for (String line : fileData) {
            if (line.contains("-")) {
                long min = Long.parseLong(line.split("-")[0]);
                long max = Long.parseLong(line.split("-")[1]);
                IngredientRange i = new IngredientRange(min, max);
                ranges.add(i);
            }
            else {
                long number = Long.parseLong(line);
                ingredients.add(number);
            }
        }


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

class IngredientRange {
    public long minimum;
    public long maximum;

    public IngredientRange(long min, long max) {
        minimum = min;
        maximum = max;
    }

    public String toString() {
        return minimum + "-" + maximum;
    }


}
