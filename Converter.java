import java.util.TreeMap;
public class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();
    public Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);
        arabKeyMap.put(1000, "M");
        arabKeyMap.put(900, "CM");
        arabKeyMap.put(500, "D");
        arabKeyMap.put(400, "CD");
        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");
    }
    public boolean isRoman(String number){
        return romanKeyMap.containsKey(number.charAt(0));
    }
    public String intToRoman(int number) {
        String roman = "";
        int arabKey;
        do {
            arabKey = arabKeyMap.floorKey(number);
            roman += arabKeyMap.get(arabKey);
            number -= arabKey;
        } while (number != 0);
        return roman;
    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int ara;
        int result = romanKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            ara = romanKeyMap.get(arr[i]);
            if (ara < romanKeyMap.get(arr[i + 1])) {
                result -= ara;
            } else {
                result += ara;
            }
        }
        return result;
    }
}
