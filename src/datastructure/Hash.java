package datastructure;

import datastructure.Hash.HashImpl.HashElement;
import java.util.LinkedList;

/**
 * Associative array
 *
 * - property of the data
 * - be fast to compute
 * - If two things are "equal" should return the same value
 * - Always return the same value for an object during one run of the code
 * - possible to return different values for an object in separate runs
 *   - not at disk but at Object hash code by memory address
 * - *minimize collisions*
 *
 * - hashCode index Array size -> odd, prime number
 */
public class Hash {

    public static void main(String[] args) {
        System.out.println(hashCode("this"));
        System.out.println(hashCode("shit"));
    }

    public static int hashCode(String s) {
        int g = 31;
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = g * hash + s.charAt(i);
        }
        return hash;
    }

    public static int makeAnIntegerPositive(int num) {
        int andNumber = 0x7fffffff; // 0111 1111 1111 1111 1111 1111 1111 1111
        return andNumber & num;
    }

    public static void loadFactor() {
        /**
         * loadFactor -> 용량 대비 데이터가 어느정도 찼을 때 내부적으로 사이즈 확장을 필요로 하는 자료구조에서 사용되는 개념
         * 언제 사이즈를 늘릴지 결정하는 척도, 기준
         * default 는 0.75f (ArrayList는 1)
         * 사이즈가 가변적인 자료구조에 쓰이며 current capacity와 곱을 이뤄 사이즈를 증가시켜야 하는 시기를 결정하는데 사용한다.
         */
    }

    public static void resolveCollisionsInAHash(int num) {
        /**
         * 만약 비어 있지 않은 공간에 값이 할당된다면
         * - linear probing -> 빈 공간이 생길 때까지 다음 공간으로 옮긴다.
         * - quadratic probing -> 빈 공간이 생길 때까지 1**2, 2**2, 3**2, 4**2 제곱씩 옮긴다
         * - double hashing -> hashCode func을 2개 사용, 두 func의 값은 같지 않음.
         *      두번째 hash 값은 0이 아니며 첫번째 hash 값 + 두번째 hash을 hashValue로 갖는다.
         * -
         *
         */

    }

    public static void chaining() {
        /**
         * Array의 index를 head로 하는 각각의 linked list를 생성
         * - 동일한 index의 값이 들어오면 addFirst(O(1))
         * - 가장 잘 만들어진 데이터 스트럭쳐
         * - Best case = O(1) 일 때
         * - Wortst case = O(n)일 때 -> 계속 같은 index에 chaining이 될 때
         *
         */
    }

    public static void rehashing() {
        /**
         * lambda(load factor) = number of entries/ number of linked list
         * 기존 리스트 -> 사이즈를 키움
         * chaining -> 사이즈를 키웠을 때 인덱스 값이 달라짐
         * 사이즈를 키운 뒤 초기화 후 -> rehashing
         */
    }

    public class HashImpl<K,V> implements HashInterface<K, V> {
        class HashElement<K, V> implements Comparable <HashElement<K, V>> {
            K key;
            V value;

            public HashElement(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public int compareTo(HashElement<K, V> o) {
                return (((Comparable<K>) this.key).compareTo(o.key));
            }
        }
        int numElements, tableSize;
        double maxLoadFactor;
        LinkedList<HashElement<K, V>> [] hArray; // LintList들의 Array라서 []를 붙여줌
        public HashImpl(int tableSize) {
            this.tableSize = tableSize;
            hArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
            // K[] keys = (K[]) new Object[10];
            for (int i=0; i< tableSize; i++) {
                hArray[i] = new LinkedList<HashElement<K,V>>();
            }
            // maxLoadFactor가 증가 -> 리사이징 시간이 오래 걸림
            maxLoadFactor = 0.75;
            numElements = 0;
        }
    }

    public interface HashInterface<K, V> {

    }
}
