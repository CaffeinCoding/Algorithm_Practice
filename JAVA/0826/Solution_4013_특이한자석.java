import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
    static int[] cnt = { 1, 2, 4, 8 };

    public static class Wheel {
        int left, right;
        ArrayList<Integer> arr;

        public Wheel(ArrayList<Integer> arr) {
            this.arr = arr;
        }

        public void turnL() {
            arr.add(arr.get(0));
            arr = (ArrayList<Integer>) arr.subList(1, arr.size() - 1);
            left = arr.get(2);
            right = arr.get(6);
        }

        public void turnR() {
            arr.add(0, arr.get(arr.size() - 1));
            arr = (ArrayList<Integer>) arr.subList(0, arr.size() - 2);
            left = arr.get(2);
            right = arr.get(6);
        }
    }

    public static class Node {
        Node front, back, left, right;
        int num;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Wheel[] list = new Wheel[4];
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(in.readLine());

        }
    }
}