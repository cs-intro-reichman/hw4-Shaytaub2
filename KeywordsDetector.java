import java.util.Arrays;
public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) 
    {   
        for (int i=0; i<keywords.length; i++) // lowerCase to all keyWords
        {
            keywords [i] = lowerCase(keywords[i]);
        }
       
        String [] newSentences = new String[sentences.length];
        for (int i=0; i<newSentences.length; i++) // lowerCase to all sentsnces
        {
            newSentences [i] = sentences [i];
            sentences [i] = lowerCase(newSentences[i]);
        }
        for (int i=0; i<newSentences.length; i++)
        {
            for (int j=0; j<keywords.length; j++)
            {
            if (contains(sentences [i], keywords [j]))
                {
                    System.out.println(newSentences[i]);
                }   
            }
        }

        /*
        for (int i=0; i<sentences.length; i++) // בדיקה של כל משפט בנפרד
        {
            String sentenc = sentences[i].toLowerCase(); // אותיות קטנות למשפט שנבדק
            String [] wordsInSentenc = wordToSentence(sentenc); // שומר את המשפט באותיות קטנות בסטרינג חדש
            for (int j=0; j<wordsInSentenc.length; j++)
            {

            }              
        }
        */
    }

    public static String lowerCase(String str) {
        String lowString ="";
        for (int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            if (c>='A' && c<='Z')
            {
                lowString =lowString + (char)(c +('a' - 'A'));
            }
            else
            {
                lowString =lowString + str.charAt(i);
            }
        }
        return lowString;
    }  

    public static boolean contains (String str1, String str2) {
        
        for (int i = 0; i <= str1.length() - str2.length(); i++) 
        {
            boolean found = true;
            for (int j = 0; j < str2.length(); j++) 
            {
                if (str1.charAt(i + j) != str2.charAt(j)) 
                {
                    found = false;
                    break;
                }
            }
            if (found) 
            {
                return true;
            }
        }
        return false;   
    }
}
