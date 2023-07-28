package dz_5;

import java.io.*;
import java.nio.file.Path;

/** Код выполняет следующие шаги:
 Определяет исходную директорию и путь для создания резервной копии.
 Проверяет, является ли исходная директория действительно директорией.
 Если нет, выбрасывается исключение IllegalArgumentException.
 Создает резервную директорию, если она не существует.
 Получает список файлов в исходной директории.
 Для каждого файла в списке проверяет, является ли он файлом.
 Если файл, то создает пути источника и резервной копии.
 Открывает потоки для чтения из источника и записи в резервную копию.
 Читает данные из источника и записывает их в резервную копию.
 Закрывает потоки ввода-вывода.Код создает резервную копию всех файлов в указанной директории,
 сохраняя их во вновь созданную папку "./backup".
 */
public class BackupFiles {
    public static void main(String[] args) {
        String sourceDirectory = "путь_к_исходной_директории";
        String backupDirectory = "./backup";

        try {
            createBackup(sourceDirectory, backupDirectory);
            System.out.println("Резервная копия успешно создана.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании резервной копии: " + e.getMessage());
        }
    }

    public static void createBackup(String sourceDirectory, String backupDirectory) throws IOException {
        File sourceDir = new File(sourceDirectory);
        File backupDir = new File(backupDirectory);

        if (!sourceDir.isDirectory()) {
            throw new IllegalArgumentException(sourceDirectory + " не является директорией.");
        }

        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Path sourcePath = file.toPath();
                    Path backupPath = backupDir.toPath().resolve(file.getName());

                    try (InputStream inputStream = new FileInputStream(sourcePath.toFile()); OutputStream outputStream = new FileOutputStream(backupPath.toFile())) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, length);
                        }
                    }
                }
            }
        }
    }
}