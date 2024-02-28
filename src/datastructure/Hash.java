package datastructure;

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
}
