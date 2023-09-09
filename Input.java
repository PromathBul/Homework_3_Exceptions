import java.util.Scanner;

/**
 * Input
 */
public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        query();
        String input = scanner.nextLine();
        while (!input.equals("stop")) {

            int answer = Check.checkLen(input);
            if (answer == 0)
                System.out.println("Вы ввели больше или меньше данных, чем нужно\nПопробуйте ввести снова");
            else {
                String[] data = input.split(" ");
                System.out.println("Input");
                for (String string : data) {
                    System.out.println(string);
                }
                Check.resultCheck(Check.checkFormat(data));
                String[] info = Parsing.Ordering(data);
                SaveInFile.writeFile(info);
            }
            query();
            input = scanner.nextLine();

        }
        scanner.close();
    }

    static public void query() {
        System.out.println("Введите следующие данные в произвольном порядке, разделяя их пробелом");
        System.out.println("- Фамилия имя отчество");
        System.out.println("- Дата рождения в формате dd.mm.yyyy");
        System.out.println("- Номер телефона (только цифры без +7 или 8)");
        System.out.println("- Пол: m или f");
        System.out.println("Или введите 'stop', чтобы прекратить ввод.");
    }
}
