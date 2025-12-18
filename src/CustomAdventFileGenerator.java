public class CustomAdventFileGenerator {
    public static void main(String[] args) {
        int size = (int) (Math.random() * 100) * 2 + 501;
        //int size = 25;
        String str = "";
        int num = (size / 2) + 1;
        for (int i = 1; i <= size; i++) {
            int ring = 0;
            for (int j = 1; j <= size; j++) {
                int valI = num - Math.abs(num - i);
                int valJ = num - Math.abs(num - j);
                ring = valJ;
                if (valI < valJ) ring = valI;
                if (j != size) System.out.print(ring - (int) (Math.sqrt((Math.pow(Math.random(), 8) * ring + 0.9) * ring)) + ".");
            }
            System.out.println(ring - (int) (Math.sqrt((Math.pow(Math.random(), 8) * ring + 0.9) * ring)));
        }
    }
}
