package algoriWeek2;

public class MySort {

    public int[] selectionSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (data[i] > data[j]) {
                    data = swap(data, i, j); // 이 부분에서 swap 메서드를 호출해야 합니다.
                }
            }
        }
        return data;
    }

    public int[] bubbleSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) { // 오름차순으로 정렬되어야 하므로 i를 증가시켜야 합니다.
            for (int j = 0; j < n - i - 1; j++) { // 이 부분에서는 n - i - 1로 변경해야 합니다.
                if (data[j] > data[j + 1]) {
                    data = swap(data, j, j + 1); // 이 부분에서 swap 메서드를 호출해야 합니다.
                }
            }
        }
        return data;
    }

    public int[] quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
        return data;
    }

    public int[] quickSort(int[] data, int p, int r) {
        if (p < r) {
            int q = partition(data, p, r);
            quickSort(data, p, q - 1);
            quickSort(data, q + 1, r);
        }
        return data;
    }

    public int partition(int[] data, int p, int r) {
        int x = data[r];
        int k = p - 1;
        for (int i = p; i < r; i++) {
            if (data[i] <= x) {
                k++;
                data = swap(data, k, i);
            }
        }
        data = swap(data, k + 1, r);
        return k + 1;
    }

    public int[] mergeSort(int[] data) {
        // 여기에 병합 정렬 코드를 구현하세요.
        return data;
    }

    public int[] insertionSort(int[] data) {
        // 여기에 삽입 정렬 코드를 구현하세요.
        return data;
    }

    private int[] swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        return data;
    }

    public static void main(String[] args) {
        int[] data = {113, 336, 74, 71, 86, 176, 313, 80, 225, 342,
                170, 292, 275, 266, 79, 16, 109, 175, 245, 156,
                50, 61, 277, 167, 81, 24, 76, 186, 78, 101,
                301, 62, 152, 219, 294};
        int dataSize = data.length;
        int[] dataSorted = new int[dataSize];

        System.out.println("\n< Initial Data >");
        showData(data);

        MySort ms = new MySort();
        dataSorted = data.clone();
        ms.selectionSort(dataSorted);
        System.out.println("\n< Selection Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
        ms.bubbleSort(dataSorted);
        System.out.println("\n< Bubble Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
        ms.quickSort(dataSorted);
        System.out.println("\n< Quick Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
        ms.mergeSort(dataSorted);
        System.out.println("\n< Merge Sort >");
        showData(dataSorted);

        dataSorted = data.clone();
        ms.insertionSort(dataSorted);
        System.out.println("\n< Insertion Sort >");
        showData(dataSorted);
    }

    private static void showData(int[] data) {
        int n = data.length;
        int nRow = 1 + (int) n / 10;
        for (int i = 0; i < nRow; i++) {
            for (int j = i * 10; j < Math.min(n, (i + 1) * 10); j++)
                System.out.print("  " + data[j]);
            System.out.println();
        }
    }
}
