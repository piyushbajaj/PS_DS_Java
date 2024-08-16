package Office.Vigoursoft.Regex;

/**
 * Project: DSAlgo
 * Package: Office.Vigoursoft
 * <p>
 * User: piyushbajaj
 * Date: 29/03/24
 * Time: 7:00 pm
 */
public enum FileExtension {
    CSV(CompressionCodec.NONE),
    ZIP(CompressionCodec.ZIP);

    private final CompressionCodec compressionCodec;

    private FileExtension(CompressionCodec compressionCodec) {
        this.compressionCodec = compressionCodec;
    }

    public CompressionCodec getCompressionCodec() {
        return this.compressionCodec;
    }
}
