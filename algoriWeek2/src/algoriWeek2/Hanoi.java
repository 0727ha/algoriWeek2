package algoriWeek2;

import java.util.Stack;

public class Hanoi {

    public void hanoi(int n, int f, int t) {
        if (n == 1) {
            System.out.println("Moved from " + f + " to " + t);
            return;
        } else {
            hanoi(n - 1, f, 3 - f - t); // f에서 옆말고 다른 곳으로 옮기므로 3-f-t
            hanoi(1, f, t);
            hanoi(n - 1, 3 - f - t, t);
        }
    }

    public static void hanoiIter(int n, int f, int t) {
        Stack<Integer> s = new Stack<>();
        s.push(n);
        s.push(f);
        s.push(t);
        int num, from, to;

        while (!s.isEmpty()) {
            to = s.pop();
            from = s.pop();
            num = s.pop();
            if (num == 1)
                System.out.println("Moved from " + from + " to " + to);
            else {
                s.push(num - 1);
                s.push(3 - from - to);
                s.push(to);

                s.push(1);
                s.push(from);
                s.push(to);

                s.push(num - 1);
                s.push(from);
                s.push(3 - from - to);
            }
        }
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        h.hanoi(3, 0, 1); // 3개를 0에서 1로 넘겨라
        hanoiIter(3, 0, 1);
    }
}
