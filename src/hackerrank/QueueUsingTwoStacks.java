package hackerrank;

import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inQueue = new ArrayList<>();
        ArrayList<Integer> outQueue = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            if (inputs[0].equals("1")) {
                inQueue.add(Integer.parseInt(inputs[1]));
            } else {
                if (outQueue.size() == 0) {
                    while (inQueue.size() != 0) {
                        outQueue.add(inQueue.remove(0));
                    }
                }
                if (outQueue.size() != 0) {
                    if (inputs[0].equals("2")) {
                        outQueue.remove(0);
                    } else {
                        System.out.println(outQueue.get(0));
                    }
                }
            }
        }
    }
}
