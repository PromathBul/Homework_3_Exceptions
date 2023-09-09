public class Parsing {
    static public String[] Ordering(String[] data) {
        // System.out.println("Parsing");
        String[] result = new String[Check.LEN];
        // for (String string : result) {
        //     System.out.println(string);
        // }
        int count = 0;
        for (String string : data) {
            if(Check.isSex(string)){
            System.out.println("parsing" + string);
                result[5] = string;
            }
            else if(Check.isPhone(string))
                result[4] = string;
            else if(Check.isDate(string))
                result[3] = string;
            else {
                result[count] = string;
                count++;
            }
        } 
        return result;
    }
}
