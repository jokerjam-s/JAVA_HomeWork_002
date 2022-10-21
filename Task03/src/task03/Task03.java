/*
    Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида

    Расширение файла: txt
    Расширение файла: pdf
    Расширение файла:
    Расширение файла: jpg
 */
package task03;

import java.io.File;
import java.util.HashSet;

public class Task03 {
    private static File[] files;

    public static void main(String[] args) {
        clearScreen();

        //HashSet<String> fileCurentPath = getFilesList(System.getProperty("user.dir"));

        String path = System.getProperty("user.dir");

        System.out.println(new StringBuilder("Кталог: ").append(path).toString());
        for (String f : getFilesList(path)) {
            System.out.println("Расширение файла: " + f);
        }
    }

    // подготовка списка файлов в каталоге проекта
    public static HashSet<String> getFilesList(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();

        HashSet<String> fileExt = new HashSet<String>();

        for (File f : files) {
            if (f.isFile()) {
                fileExt.add(getFileExtension(f.getName()));
            }
        }

        return fileExt;
    }

    // получение расширения файла из имени
    private static String getFileExtension(String fileName) {
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
