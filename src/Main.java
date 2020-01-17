import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> table = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if (table.containsKey(word))
                table.put(word, table.get(word) + 1);
            else
                table.put(word, 1);
        }

        ArrayList<Pair> list = new ArrayList<>();


        for(String word: table.keySet())
            list.add(new Pair(word, table.get(word)));

        Collections.sort(list);

        System.out.println(list.get(0).word);
    }

    public static class Pair implements Comparable<Pair>{
        String word;
        int cnt;

        public Pair(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.cnt == o.cnt)
                return this.word.compareTo(o.word);
            return o.cnt - this.cnt;
        }
    }
}
