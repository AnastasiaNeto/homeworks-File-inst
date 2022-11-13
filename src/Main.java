import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Установку программы необходимо производить из Java кода с использованием класса File.
        Процесс будет состоять из следующих этапов:
        1. В папке Games создайте несколько директорий: src, res, savegames, temp.
        2. В каталоге src создайте две директории: main, test.
        3. В подкаталоге main создайте два файла: Main.java, Utils.java.
        4. В каталог res создайте три директории: drawables, vectors, icons.
        5. В директории temp создайте файл temp.txt.
    Файл temp.txt будет использован для записиси в него информации об успешноном или неуспешном создании файлов и
    директорий.
        */
        StringBuilder sb = new StringBuilder();
        List<File> dirList = Arrays.asList(
                new File("D://Games"),
                new File("D://Games//src"),
                new File("D://Games//res"),
                new File("D://Games//savegames"),
                new File("D://Games//temp"),
                new File("D://Games//src//main"),
                new File("D://Games//src//test"),
                new File("D://Games//res//drawables"),
                new File("D://Games//res//vectors"),
                new File("D://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("D://Games//src//main//Main.java"),
                new File("D://Games//src//main//Utils.java"),
                new File("D://Games//temp//temp.txt")
        );
        dirList.stream().forEach(dir -> {
            if (dir.mkdir()) sb.append("Каталог " + dir + " создан\n");
            else sb.append("Каталог " + dir + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("D://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


