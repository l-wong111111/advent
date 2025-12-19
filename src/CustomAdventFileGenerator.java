public class CustomAdventFileGenerator {
    public static void main(String[] args) {
        int size = (int) (Math.random() * 100) * 2 + 301; //the console cannot handle rows or columns over a value near 500 so the range has to be 301-501 here
        // 301 can be replaced with another value if console can handle it

        //int size = 605; // this won't work with intelliJ
        String str = "";
        int ring = 0;
        int num = (size / 2) + 1;
        int missingBoxes = 0;
        int answer = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int valI = num - Math.abs(num - i);
                int valJ = num - Math.abs(num - j);
                ring = Math.min(valI, valJ);
                missingBoxes = (int) (Math.sqrt((Math.pow(Math.random(), 5) * ring + 0.9) * ring));
                if (j != size) System.out.print(ring - missingBoxes + ".");
                //bug testing code below
                //if (ring - (int) (Math.sqrt((Math.pow(Math.random(), 8) * ring + 0.9) * ring)) > ring)
                    //System.out.println("error");
                //System.out.print(valI + ".");
                answer += missingBoxes;
            }
            System.out.println(ring - missingBoxes);
        }
        System.out.println(answer); // for seeing if solution matches answer
    }
}
