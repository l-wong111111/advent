import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// for this Day, I made an "IngredientRange" object that holds two numbers
// the minimum and the maximum for the range in the file
public class day5year2025 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/data");
        ArrayList<Long> ingredients = new ArrayList<Long>();
        ArrayList<Long> range1 = new ArrayList<>();
        ArrayList<Long> range2 = new ArrayList<>();

        for (String line : fileData) {
            if (line.contains("-")) {
                long min = Long.parseLong(line.split("-")[0]);
                long max = Long.parseLong(line.split("-")[1]);
                IngredientRange i = new IngredientRange(min, max);
                range1.add(min);
                range2.add(max);
            }
            else {
                long number = Long.parseLong(line);
                ingredients.add(number);
            }
        }
        System.out.println(range1);
        System.out.println(range2);


        long partOneAnswer = 0;

        for (int i = 0; i < ingredients.size(); i++) {
            long val = ingredients.get(i);
            for (int j = 0; j < range1.size(); j++) {
                if ((val >= range1.get(j)) == (val <= range2.get(j))) {
                    partOneAnswer++;
                    break;
                }
            }
        }
        System.out.println(partOneAnswer);

        //part 2

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

    public long getMaximum() {
        return maximum;
    }

    public long getMinimum() {
        return minimum;
    }
}
