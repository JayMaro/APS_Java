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
     */
}