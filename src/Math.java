import java.io.*;
import java.util.Scanner;

public class Math {
    public static void main(String[] args) {
        String fileName = "Math.txt";
        String newFileName = "MathResult.txt";
        File file = new File(fileName);
        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku");
            }
        }
        if (fileExists)
            System.out.println("Plik " + fileName + " istnieje.");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lines = 0;
        try {
            FileWriter fw = new FileWriter(newFileName);
            BufferedWriter bfw = new BufferedWriter(fw);
            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                String[] temp = name.split(" ");
                System.out.println(name);
                int result = 0;
                switch (temp[1]){
                    case "+":
                        result = Integer.parseInt(temp[0]) + Integer.parseInt(temp[2]);
                        break;
                    case "-":
                        result = Integer.parseInt(temp[0]) - Integer.parseInt(temp[2]);
                        break;
                    case "*":
                        result = Integer.parseInt(temp[0]) * Integer.parseInt(temp[2]);
                        break;
                    case "/":
                        result = Integer.parseInt(temp[0]) / Integer.parseInt(temp[2]);
                        break;
                    default:
                        System.out.println("Nie ma takiego działania!");
                }
                bfw.write(name + " = " + result);
                bfw.newLine();
                lines++;
            }
            bfw.flush();
        } catch (NumberFormatException | IOException  e){
            System.out.println("Koniec działań");
        }
        scan.close();
    }
}
