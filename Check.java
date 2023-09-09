import java.util.Date;

public class Check {
    public static int LEN = 6;

    public static int checkLen(String input) {
        String[] data = input.split(" ");
        if (data.length == LEN)
            return 1;
        return 0;
    }

    public static boolean isSex(String sex) {
        // System.out.println(sex);
        // boolean check = sex.equals("m") || sex.equals("f");
        // System.out.println(check);
        return sex.equals("m") || sex.equals("f");
    }

    public static boolean isPhone(String phone) {
        if (phone.length() != 10)
            return false;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean isDate(String date) {
        if (date.length() != 10)
            return false;
        String[] parsingDate = date.split("\\.");

        if (parsingDate[0].length() != 2 || parsingDate[1].length() != 2 || parsingDate[2].length() != 4)
            return false;
        for (String string : parsingDate) {
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isDigit(string.charAt(i)))
                    return false;
            }
        }
        if(Integer.parseInt(parsingDate[0]) > 31 || Integer.parseInt(parsingDate[1]) > 12 || Integer.parseInt(parsingDate[2]) < 1900 || Integer.parseInt(parsingDate[2]) > new Date().getYear())
            return false;
        return true;
    }

    public static boolean isLetters(String letters) {
        if (isSex(letters))
            return false;
        for (int i = 0; i < letters.length(); i++) {
            if (!Character.isAlphabetic(letters.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean[] checkFormat(String[] list) {
        boolean[] flags = new boolean[LEN];
        int countName = 0;
        for (String data : list) {
            if (isSex(data)) {
                flags[5] = true;
                // System.out.println(data);
            }     
            else if (isPhone(data))
                flags[4] = true;
            else if (isDate(data)){
                flags[3] = true;
                // System.out.println(data);
            }
            else if (isLetters(data))
                countName++;
        }
        if (countName == 3) {
            flags[0] = true;
            flags[1] = true;
            flags[2] = true;
        }
        return flags;
    }

    public static void resultCheck(boolean[] array) {
        if (!array[0] || !array[1] || !array[2])
            throw new RuntimeException("В фамилии, имени или отчестве содержатся не буквенные значения");
        if (!array[3])
            throw new RuntimeException("Дата рождения неверного формата. Необходимо соблюдать формат: dd.mm.yyyy. Либо неверно указана дата (от 01 до 31), месяц (от 01 до 12) или год (от 1900 до текущего).");
        if (!array[4])
            throw new RuntimeException("В номере телефона либо содержаться символы, отличные от цифр, либо количество цифр не равно 10.");
        if (!array[5])
            throw new RuntimeException("Пол должен отмечаться только буквами 'm' и 'f'.");
    }
}