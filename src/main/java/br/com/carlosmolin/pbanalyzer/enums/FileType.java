package br.com.carlosmolin.pbanalyzer.enums;

public enum FileType {
    WINDOW(".srw"),
    USEROBJECT(".sru"),
    DATAOBJECT(".srd"),
    FUNCTION(".srf"),
    STRUCT(".srs"),
    APPLICATION(".sra"),
    UNKNOWN("");

    private final String extension;

    FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public static FileType fromFilename(String filename) {
        for (FileType type : values()) {
            if (filename.toLowerCase().endsWith(type.extension)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}