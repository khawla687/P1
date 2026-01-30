public class Array {
    private int[] items;
    private int count;

    Array(int size) {
        items = new int[size];
        count = 0;
    }
    boolean isFull(){
        return (count==items.length);}

    void Append(int item) {
        if (isFull()) {
            System.out.println("Array full");
        } else {
            items[count] = item; // items[count++]= item;
            count++;
        }
    }
    void Traverse() {
        for (int i = 0; i < count; i++){
            System.out.println(items[i] + " ");}
        System.out.println();
    }
    boolean Search(int item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item){
                System.out.println("Found at position " + i);
                return true;
            }
        }
        return false;
    }
    void insert(int pos, int newitem){
        if (isFull()){
            System.out.println("Cant insert new item");
            return;
        }
        for(int i=count; i> pos; i--){
            items[i]= items[i-1];}
            items[pos]= newitem;
            count++;
        System.out.println("Inserted value: " + newitem);
    }
    void delete(int pos){
        for(int i =pos; i<count-1; i++){
            items[i]= items[i+1];}
            count--;

    }
    int [] Enlarge(int newsize) {
        if (newsize> items.length){
    int [] newarray= new int [newsize];
    for(int i=0,j=0; i<count; i++, j++){
        newarray[j]= items[i];}
        return newarray;

    } else
        return items;}

    public int getCount() {
        return count;
    }
    void TraverseAll() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    int [] Merge(int [] other){
        int [] largeArray= new int[items.length+ other.length];
        int index=0;
        for (int i=0; i<count; i++, index++){
            largeArray[index]= items[i];}
            for (int j=0; j<other.length; index++, j++){
                largeArray[index]= other[j];}
                return largeArray;
            }

    public static void main(String[] args) {
        Array arr = new Array(3);
        arr.Append(10);
        arr.Append(20);
        arr.Append(30);
        arr.Traverse();
        //arr.delete(4);
        System.out.println("After Enlarge " );
        arr.items=arr.Enlarge(6);
        System.out.println(arr.items.length );
        arr.TraverseAll();
        int [] other= {40, 50, 60};
        int [] merged= arr.Merge(other);
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
        }
        /*arr.insert(4, 100);
        arr.Traverse();

        System.out.println("Found 20? " + arr.Search(50));
        System.out.println("Count = " + arr.getCount());*/
    }


