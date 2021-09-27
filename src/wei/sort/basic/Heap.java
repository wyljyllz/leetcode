package wei.sort.basic;

/**
 * @ClassName Heap
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;

    public Heap(int MaxN) {
        this.heap = (T[]) new Comparable[MaxN + 1];
        }

     public boolean isEmpty() {
        return N == 0;
    }
    public int Size() {
        return N;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private void swim(int k) { //上浮操作
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
        }
    }

    private void sink(int k) { //下沉操作

        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j+1))
                j++;
            if(!less(k, j))
                break;
            swap(k, j);
            k = j;

        }
    }

    public void insert(Comparable v) {
        heap[++N] = (T) v;
        swim(N);
    }

    public T delMax() {
        T Max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return Max;
    }


}
