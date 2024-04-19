package datastructure;

/*
 * root / leaves
 * parent / child
 * siblings
 * node(점) / edge(선)
 * levels root(1) / child(2)
 */
public class TreesAndHeap {

}

class Tree {
    // Tree Traversal

}

class Heap {

    /*
    parent is > children -> max heap
    parent is < children -> min heap
    max children is 2
    level(height) = log2(n+1)-1

    add
     -> 빈 자리에 더하고 부모와 비교 후 스왑
        -> insert next available space
        -> trickle up
    remove
    -> 항상 최상단의 root를 제거해야 한다.
    -> 가장 마지막 노드를 최상단으로 옮긴다.
    -> 자식과 비교하며 스왑한다. (이 때 둘중 큰 노드와 스왑한다.)
        -> remove the root(Always!)
        -> replace with the last element
        -> trickle down(compare two and swap with bigger one)

    Index
    - children index: 2*parent+1, 2*parent+2
    - parent index: floor((child-1)/2)
    -> 이를 통해 Heap을 간단하게 Array로 구현할 수 있다.

    HeapSort
    - array를 통해 구현한 Heap에서 가장 큰(작은) 값이 항상 마지막 값과 스왑되고 정렬된다.
    - 따라서 remove를 root까지 계속 실행한다면 큰(작은) 역순서대로 정렬된다.
     */
    class BinaryHeapImpl<E> {

        int lastPosition;   // how many element we have
        E[] array; // = (E[]) new Object[size]

        public void add(E obj) {
            array[++lastPosition] = obj;
            trickleUp(lastPosition);
        }

        public void swap(int from, int to) {
            E tmp = array[from];
            array[from] = array[to];
            array[to] = tmp;
        }

        public void trickleUp(int position) {
            if (position == 0) {
                return;
            }
            int parent = (int) Math.floor((position - 1) / 2);
            if (((Comparable<E>) array[position]).compareTo(array[parent]) > 0) {
                swap(position, parent);
                trickleUp(parent);
            }
        }

        public E remove() {
            E tmp = array[0];
            swap(0, lastPosition--);
            trickleDown(0);
            return tmp;
        }

        public void trickleDown(int parent) {
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            if (left == lastPosition &&
                (((Comparable<E>) array[parent]).compareTo(array[left]) < 0)) {
                swap(parent, left);
                return;
            }
            if (right == lastPosition &&
                (((Comparable<E>) array[parent]).compareTo(array[right]) < 0)) {
                swap(parent, right);
                return;
            }
            if (left >= lastPosition || right >= lastPosition) {
                return;
            }
            if ((((Comparable<E>) array[left]).compareTo(array[right]) > 0) &&
                (((Comparable<E>) array[parent]).compareTo(array[left]) > 0)) {
                swap(parent, left);
                trickleDown(left);
            } else if ((((Comparable<E>) array[parent]).compareTo(array[right]) < 0)) {
                swap(parent, right);
                trickleDown(right);
            }
        }
    }
}