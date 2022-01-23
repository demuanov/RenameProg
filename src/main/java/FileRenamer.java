import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class FileRenamer {
    private static final String mainPath = "C:\\IMAGES\\";

    public static Set<String> listFilesUsingFileWalkAndVisitor(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (!Files.isDirectory(file)) {
//                    fileList.add(file.toString());
                    fileList.add(file.getFileName().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return fileList;
    }

 /*   public static listFilesRename(Set <String> input){

    }*/

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("output_numbers.txt");
            Set<String> files = listFilesUsingFileWalkAndVisitor(mainPath);
//            files.stream().forEach(element-> System.out.println(element));
            for (String element : files) {
                writer.write(element + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File inputNumbers = new File("input_numbers.txt");

    }


}
