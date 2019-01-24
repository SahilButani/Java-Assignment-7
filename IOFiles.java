
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

public class IOFiles
{
    /*
     * This function counts characters from an input file given in command line
     * and stores it in a treemap
     @param input_file takes a string as input which contains path of a text file
     */
    public static Map<Character, Integer> countCharacters(String input_file) throws Exception
    {
        Map<Character, Integer> character_count = new TreeMap<>();
        File file = new File(input_file); // input file

        Scanner sc= new Scanner(file);
        while(sc.hasNextLine()) {
            char[] character_array = sc.nextLine().toLowerCase().toCharArray();
            for (Character ch : character_array) {
                if (character_count.containsKey(ch)) {
                    character_count.put(ch, character_count.get(ch) + 1);
                }
                else
                    character_count.put(ch,1);
            }

        }
        return character_count;

    }
    /*
     * This function takes treemap as input and writes the content in a file named output.txt
     */

    public static void writeOutputToFile(Map<Character,Integer> character_count) throws Exception
    {
        FileWriter file_writer = new FileWriter("/home/zadmin/output.txt"); // output file
        for (Map.Entry<Character, Integer> entry : character_count.entrySet())
        {
            String s = entry.getKey() + " : " + entry.getValue() + "\n";
            file_writer.write(s);

        }

        file_writer.close();
    }
    /*
     * Main method calls the writeOutputToFile, which in turn calls countCharacters.
     */
    public static void main(String[] args) throws Exception
    {

        writeOutputToFile(countCharacters(args[0]));

    }
}
