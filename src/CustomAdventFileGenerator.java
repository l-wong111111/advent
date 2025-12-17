public class CustomAdventFileGenerator {
    public static void main(String[] args) {
        //int size = (int) (Math.random() * 100) * 2 + 501;
        int size = 5;
        String str = "";
        int num = (size / 2) + 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int maxValI = num - Math.abs(num - i);
                int maxValJ = num - Math.abs(num - j);
                int smallerVal = maxValJ;
                if (maxValI < maxValJ) smallerVal = maxValI;
                System.out.print((int) (Math.random() * smallerVal) + ".");
            }
            System.out.println();
        }
    }
}
