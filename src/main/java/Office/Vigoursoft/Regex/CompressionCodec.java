package Office.Vigoursoft.Regex;

/**
 * Project: DSAlgo
 * Package: Office.Vigoursoft
 * <p>
 * User: piyushbajaj
 * Date: 29/03/24
 * Time: 7:02 pm
 */
public enum CompressionCodec {
    NONE("none", ""),
    GZIP("gzip", ".gz"),
    ZIP("zip", ".zip"),
    SNAPPY_FRAMED("sz", ".sz");

    private final String name;
    private final String fileExtension;

    private CompressionCodec(String name, String fileExtension) {
        this.name = name;
        this.fileExtension = fileExtension;
    }

    public String getName() {
        return this.name;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public String toString() {
        return this.name;
    }

    public static CompressionCodec fromName(String pName) {
        if ("none".equals(pName)) {
            return NONE;
        } else if ("gzip".equals(pName)) {
            return GZIP;
        } else if ("zip".equals(pName)) {
            return ZIP;
        } else if ("sz".equals(pName)) {
            return SNAPPY_FRAMED;
        } else {
            throw new IllegalArgumentException("Unknown compression codec name " + pName);
        }
    }
}
