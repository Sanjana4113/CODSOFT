import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCounter 
{
    public static void main(String[] args) 
    {
        String text = ""; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        text=sc.nextLine();
        String[] words = text.split("[\\s.,!?;:\"]+");
        int wordCount = words.length;
        Set<String> commonWords = new HashSet<>(Arrays.asList("a", "an", "the", "is", "this"));
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) 
        {
            if (!commonWords.contains(word.toLowerCase())) 
            {
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            } 
            else 
            {
                wordCount--; 
            }
        }
        System.out.println("Total words (excluding common words): " + wordCount);
        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
