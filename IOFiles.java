import java.util.*;
import java.io.*;
public class IOFiles{
    public static void main(String[] args) throws Exception {
        Map<Character, Integer> cc = new TreeMap<>();
        for(char c='a';c<='z';c++){
            cc.put(c,0);
        }
        File file = new File(args[0]); // input file
        FileWriter fw = new FileWriter("/home/zadmin/output.txt"); // output file
        Scanner sc= new Scanner(file);
        while(sc.hasNextLine()) {
            char[] c = sc.nextLine().toLowerCase().toCharArray();
            for (Character ch : c) {
                if (Character.isLetter(ch)) {
                    cc.put(ch, cc.get(ch) + 1);
                }
            }

        }
        for (Map.Entry<Character, Integer> entry : cc.entrySet()) {
            String s = entry.getKey() + " : " + entry.getValue() + "\n";
            fw.write(s);

        }
        fw.close();
    }
}