package br.com.carlosmolin.pbanalyzer.validator;

import br.com.carlosmolin.pbanalyzer.enums.FileType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileValidator {

    public Path validateArgs(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Nenhum arquivo informado.");
        }

        Path filePath = Paths.get(args[0]);

        if (!Files.exists(filePath)) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + filePath);
        }

        if (Files.isDirectory(filePath)) {
            throw new IllegalArgumentException("O caminho informado é um diretório: " + filePath);
        }

        return filePath;
    }

    public FileType detectFileType(Path filePath) {
        String fileName = filePath.getFileName().toString();
        return FileType.fromFilename(fileName);
    }

    public ValidatedFile validateAndDetect(String[] args) {
        Path path = validateArgs(args);
        FileType type = detectFileType(path);
        return new ValidatedFile(path, type);
    }

    public static class ValidatedFile {
        private final Path path;
        private final FileType type;

        public ValidatedFile(Path path, FileType type) {
            this.path = path;
            this.type = type;
        }

        public Path getPath() {
            return path;
        }

        public FileType getType() {
            return type;
        }
    }
}
