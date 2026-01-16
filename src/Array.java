public class Array {
    private int[] items;
    private int count;

    Array(int size) {
        items = new int[size];
        count = 0;
    }

    void Append(int item) {
        if (count == items.length) {
            System.out.println("Array full");
            return;
        } else {
            items[count] = item; // items[count++]= item;
            count++;
        }
    }

    void Traverse() {
        for (int i = 0; i < items.length; i++)
            System.out.println(items[i]);
    }

    boolean Search(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return true;
        }
        return false;
    }

    public int getCount() {
        return count;
    }

    // ===== ADDED ONLY (nothing above changed) =====
    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.Append(10);
        arr.Append(20);
        arr.Append(30);

        arr.Traverse();

        System.out.println("Found 20? " + arr.Search(60));
        System.out.println("Count = " + arr.getCount());
    }
}

