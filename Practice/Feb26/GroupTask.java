import java.util.ArrayList;
import java.util.Iterator;

public class RemoveInForLoopDemo {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("B");

        System.out.println("Original list: " + list);

        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);

            Iterator<String> it = list.listIterator(i + 1);

            while (it.hasNext()) {
                String nextValue = it.next();

                if (nextValue.equals(current)) {
                    it.remove();
                }
            }
        }

        System.out.println("After removing ALL duplicates: " + list);
    }
}


