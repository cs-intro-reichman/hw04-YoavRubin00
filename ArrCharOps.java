/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        // Replace the following statement with your code
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if(arr1.length == arr2.length){
        for (int i = 0; i<arr1.length; i++){
            if (arr1[i]!=arr2[i]) {
                return false;
            }
        }
        return true;
        }
        return false;
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for(int i = 0; i<arr.length; i++){
            if(ch == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for(int i = fromIndex; i<arr.length; i++){
            if(ch == arr[i]){
                return i;
            }
        }
        return -1;
    }


    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for(int i = arr.length-1; i>=0; i--){
            if(ch == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
     int totalLength = arr1.length + arr2.length;
     char[] concatenatedArr = new char[totalLength];
     for (int i=0; i<arr1.length;i++){
        concatenatedArr[i] = arr1[i];
     }
     for (int i=0; i<arr2.length;i++){
        concatenatedArr[arr1.length+i] = arr2[i];
     }
        return concatenatedArr;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        // Replace the following statement with your code
        int totalLength = endIndex - beginIndex;
        int j= 0;
        char[] newArr = new char[totalLength];
             for (int i=beginIndex; i<endIndex;i++){
        newArr[j] = arr[i];
        j++;
     }
    return newArr;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
// בהנחה שאתה נמצא במחלקה ArrCharops, שיש לה גישה למתודות plus ו-times.

public static int hash(char[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int hashValue = 0;
        final int HASH_BASE = 7; 
        for (int i = 0; i < arr.length; i++) {
            hashValue = hashValue * HASH_BASE + arr[i];
        }
        return hashValue;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
/** * Compares the two strings lexicographically based on their Unicode values.
 * Assumes both strings are not empty.
 * @return -1 if str1 is less than str2, 0 if equal, and 1 if str1 is greater than str2.
 */
    // הנחה: שתי המחרוזות אינן ריקות (עפ"י דרישת התרגיל)
    int len1 = str1.length();
    int len2 = str2.length();
    // האינדקס המקסימלי שנבדוק הוא האורך של המחרוזת הקצרה יותר
    int minLength = Math.min(len1, len2);
    // שלב 1: השוואה תו-אחר-תו (עד לאורך המחרוזת הקצרה יותר)
    for (int i = 0; i < minLength; i++) {
        char char1 = str1.charAt(i);
        char char2 = str2.charAt(i);
        if (char1 != char2) {
            if (char1 < char2) {
                // אם התו ב-str1 קטן יותר (למשל 'a' לעומת 'b')
                return -1;
            } else {
                // אם התו ב-str1 גדול יותר (למשל 't' לעומת 'k')
                return 1;
            }
        }
    }
    // 3. בדיקה אם המחרוזות שוות באורך (שוויון מלא)
    if (len1 == len2) {
        return 0; // "hello" שווה ל-"hello"
    } 
    else if (len1 < len2) {
        // str1 קצרה יותר וכל התווים שלה זהים לתווים ב-str2
        return -1; // "abc" קטן מ-"abcd"
    } 
    else {
        return 1; // "abcd" גדול מ-"abc"
    }
}
}
