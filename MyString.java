public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String newstr = "";
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            //בדיקה אם הוא אות קטנה או גדולה
            if(ch>='A' && ch<='Z'){
                char lowerch = (char)(ch+32);
                newstr = newstr + lowerch;
            }else{
                newstr = newstr+ch;
            }
            }
            return newstr;
        }
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        boolean isContain = false;
        if(str2.length()>str1.length()){
            return false;
        }
        if (str2.length()==0) {
            return true;
        }
        for(int i = 0; i<str1.length()-str2.length(); i++){
            int j = 0;
            while(j<str2.length()){
            if(str1.charAt(i+j) != str2.charAt(j)){
                break;
            }
            j++;
        }
        if (j==str2.length()) {
            return true;
        }
        return false;
    }
}
