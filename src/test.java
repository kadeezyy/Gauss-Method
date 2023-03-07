import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Stack<Integer> stack = new Stack<>();
        int n = scanner.nextInt();
        ArrayList<Integer> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            m.add(scanner.nextInt());
            if (stack.size() == 0) {
                stack.push(m.get(i));
                continue;
            }
            int k = m.get(i);
            while (k < stack.peek()) {
                int ind = m.subList(0, i).lastIndexOf(stack.pop());
                m.set(ind, i);
                if (stack.size() == 0) break;
            }
            stack.push(k);
        }
        while (stack.size() > 0) {
            m.set(m.lastIndexOf(stack.pop()), -1);
        }
        for (int i : m) {
            System.out.printf("%d ", i);
        }
        out.close();
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public FastScanner() {
            try {
                br = new BufferedReader(new FileReader("input.txt"));
            } catch (Throwable e) {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer("");
            }
        }

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }
}
