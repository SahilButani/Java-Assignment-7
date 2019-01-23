import java.util.*;
import java.io.*;
public class IOFiles
{
    public static void main(String[] args) throws Exception 
    {
        Map<Character, Integer> character_count = new TreeMap<>();

        File file = new File(args[0]); // input file
        FileWriter file_writer = new FileWriter("/home/zadmin/output.txt"); // output file
        Scanner sc= new Scanner(file);
        while(sc.hasNextLine())
        {
            char[] character_array = sc.nextLine().toLowerCase().toCharArray();
            
            for (Character ch : character_array) 
            {
                if (character_count.containsKey(ch))
                {
                    character_count.put(ch, character_count.get(ch) + 1);
                }
                else
                character_count.put(ch,1);
            }
        }
        //output is given to output.txt file
        for (Map.Entry<Character, Integer> entry : character_count.entrySet()) 
        {
            String s = entry.getKey() + " : " + entry.getValue() + "\n";
            file_writer.write(s);
        }
        
        file_writer.close();
    }
    
}
