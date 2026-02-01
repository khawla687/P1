public class ReverseArray {
    public static void main(String[] args) {
        int[] x1 = {2,3,1,4};
        int[] x2 = {1,2,3,4,5};
        print(flip(x1)); // outputs {4,1,3,2}
        print(flip(x2)); // outputs {5,4,3,2,1}
    }
    // Reverse the elements in x and return that array:
    public static int[] flip(int[] x) {
        flip2(x, 0, x.length-1);
        return x;
    }
    // Reverse the elements in x in place, so do not create new arrays:
    private static void flip2(int[] x, int a, int b) {
        int length = b - a + 1;
        if (length<= 1) {
            return;
        }
        int half = length / 2;
        boolean odd = (length % 2 == 1);
        int midright = odd ? a + half + 1 : a + half;
        // swap left and right halves
        for (int i = 0; i < half; i++) {
            int temp = x[a + i];
            x[a + i] = x[midright + i];
            x[midright + i] = temp;
        }
        // recurse on left and right halves
        flip2(x, a, a + half - 1);
        flip2(x, midright, b);
    }
    public static void print(int[] x) {
        System.out.print("{");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if (i < x.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }}
