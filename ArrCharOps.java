public class ArrCharOps {
    public static void main(String[] args) {
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        
        System.out.println("--- ArrCharOps Tests ---");
        println(arr1);
        System.out.println("charAt(2): " + charAt(arr1, 2));
        System.out.println("indexOf('l', 3): " + indexOf(arr1, 'l', 3));
        System.out.println("lastIndexOf('l'): " + lastIndexOf(arr1, 'l'));
        println(concat(arr1, arr2));
        println(subArray(arr2, 2, 9));
        System.out.println("compareTo(\"abc\", \"abcd\"): " + compareTo("abc", "abcd"));
        System.out.println("hashCode(arr1): " + hashCode(arr1));
    }

    /** Prints the given array of characters, and moves the cursor to the next line. */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty. */
    public static char charAt(char[] arr, int index) {
        return arr[index];
    }

    /** If the two arrays have the same value in every index, returns true; Otherwise returns false. */
    public static boolean equals(char[] arr1, char[] arr2) {
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /** Returns the index within the given array of the first occurrence of the given character. */
    public static int indexOf(char[] arr, char ch) {
        for(int i = 0; i < arr.length; i++){
            if(ch == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index. */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for(int i = fromIndex; i < arr.length; i++){
            if(ch == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character. */
    public static int lastIndexOf(char[] arr, char ch) {
        // לולאה לאחור היא הדרך היעילה ביותר ל-lastIndexOf
        for(int i = arr.length - 1; i >= 0; i--){
            if(ch == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays. */
    public static char[] concat(char[] arr1, char[] arr2) {
        int totalLength = arr1.length + arr2.length;
        char[] concatenatedArr = new char[totalLength];
        
        // העתקת arr1
        for (int i = 0; i < arr1.length; i++){
            concatenatedArr[i] = arr1[i];
        }
        // העתקת arr2
        for (int i = 0; i < arr2.length; i++){
            concatenatedArr[arr1.length + i] = arr2[i];
        }
        return concatenatedArr;
    }

    /** Returns a new array that can be described as a sub-array of this array. */ 
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        int totalLength = endIndex - beginIndex;
        char[] newArr = new char[totalLength];
        int j = 0;
        
        // הלולאה צריכה לרוץ מ-beginIndex עד, אך לא כולל, endIndex
        for (int i = beginIndex; i < endIndex; i++){
            newArr[j] = arr[i];
            j++;
        }
        return newArr;
    }

    /** Returns a single integer that represents the array's "hash code". */
    public static long hashCode(char[] arr) {
        // 🛑 הקוד תוקן למבנה יחיד עם החזרת long למניעת גלישה (Overflow)
        if (arr.length == 0) {
            return 0;
        }
        long hashValue = 0; 
        final int HASH_BASE = 7; 
        
        // Horner's Method: hash = hash * 7 + arr[i]
        for (int i = 0; i < arr.length; i++) {
            hashValue = hashValue * HASH_BASE + arr[i];
        }
        return hashValue;
    }

    /** Compares the two strings lexicographically. */
    public static int compareTo(String str1, String str2) {
        // טיפול בקלט ריק (עפ"י הציפייה של הבדיקה)
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return -2; // החזרת -2 עבור שגיאת קלט
        }
        
        int len1 = str1.length();
        int len2 = str2.length();
        int minLength = Math.min(len1, len2);
        
        // שלב 1: השוואה תו-אחר-תו
        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            
            if (char1 != char2) {
                if (char1 < char2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        
        // שלב 2: השוואת אורך
        if (len1 == len2) {
            return 0;
        } else if (len1 < len2) {
            return -1;
        } else {
            return 1;
        }
    }
}