package algoriWeek2;

//���� ver

public class Search {

  public int seq1(int[] input, int val) {
      for (int i = 0; i < input.length; i++) {
          if (input[i] == val)
              return i;
      }
      return -1;
  }

  public int seq2(int[] input, int val) {
      for (int i = 0; i < input.length; i++) {
          if (input[i] == val)
              return i;
      }
      return -1;
  }

  public int binSR(int[] input, int val, int s, int e) {
      if (s > e)
          return -1; // ����: s�� e�� ������ ��� -1�� ��ȯ�ؾ� ��

      int mid = (s + e) / 2; // ����: mid�� if�� ������ �̵�

      if (input[mid] == val)
          return mid;
      else if (input[mid] > val)
          return binSR(input, val, s, mid - 1);
      else
          return binSR(input, val, mid + 1, e);
  }

  public static void main(String[] args) {
      int[] rdata = {10, 40, 20, 15, 50, 25};
      int[] sdata = {10, 40, 20, 15, 50, 25};

      Search s = new Search();
      System.out.println(s.seq1(rdata, 25));
      System.out.println(s.binSR(sdata, 25, 0, sdata.length - 1)); // ����: ) ����
  }
}

