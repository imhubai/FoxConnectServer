import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class QRcode {
    /**
     * 创建普通二维码
     *
     * @param width
     * @param height
     * @param format
     * @param content
     * @param path
     * @return
     */
    public static BufferedImage createImage(int width, int height, String format, String content, String path) {
        HashMap map = new HashMap();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        map.put(EncodeHintType.MARGIN, 1);
        BufferedImage image = null;
        try {
            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(content, BarcodeFormat.QR_CODE, width, height, map);
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0XFFFFFFFF);
                }
            }
            Path file = new File(path).toPath();
            ImageIO.write(image, format, file.toFile());

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
