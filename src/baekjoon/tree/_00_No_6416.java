package baekjoon.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _00_No_6416 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> numList = new ArrayList<>();
    static List<Integer> receiveList = new ArrayList<>();
    static List<Integer> sendList = new ArrayList<>();
    static int caseCount = 1;

    public static void main(String[] args) throws IOException {
        // 정점 - 간선 = 1
        // 보낸 항목 - 받은 항목 = 루트 노드
        // 받은 항목에 같은 항목이 존재하면 안됨
        while (true) {
            String input = br.readLine();
            if (input.equals("")) continue;
            numList.addAll(Arrays.stream(input.split(" +")).map(Integer::parseInt).collect(Collectors.toList()));
            if (numList.get(numList.size() - 1) == 0) {
                boolean isTree = true;
                int edge = 0;
                Set<Integer> vertext = new HashSet<>();
                for (int i = 0; i < numList.size() - 2; i += 2) {
                    sendList.add(numList.get(i));
                    if (receiveList.contains(numList.get(i + 1))) {
                        isTree = false;
                        break;
                    }
                    receiveList.add(numList.get(i+1));
                    vertext.add(numList.get(i));
                    vertext.add(numList.get(i+1));
                    edge++;
                }
                List<Integer> uniqueSendList = sendList.stream().distinct().collect(Collectors.toList());
                uniqueSendList.removeAll(receiveList);
                if (edge == 0) {
                    bw.write("Case " + caseCount++ + " is a tree.\n");
                } else if (isTree && uniqueSendList.size() == 1 && vertext.size()-1 == edge) {
                    bw.write("Case " + caseCount++ + " is a tree.\n");
                } else {
                    bw.write("Case " + caseCount++ + " is not a tree.\n");
                }
                numList.clear();
                sendList.clear();
                receiveList.clear();
            } else if (numList.get(numList.size() - 1) < 0) {
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}