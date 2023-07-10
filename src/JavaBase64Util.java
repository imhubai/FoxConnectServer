import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author fankunfeng
 * @Date 2019-01-22 14:39:23
 * @Describe Java8之后Util包Base64编码，比apache方式效率更高
 */
public class JavaBase64Util {
    public static final String UTF_8 = "UTF-8";
    public static Base64.Encoder encoder;
    public static Base64.Encoder urlEncoder;
    public static Base64.Decoder decoder;
    public static Base64.Decoder urlDecoder;

    static {
        encoder = Base64.getEncoder();
        urlEncoder = Base64.getUrlEncoder();
        decoder = Base64.getDecoder();
        urlDecoder = Base64.getUrlDecoder();
    }

    public static byte[] encode(byte[] bytes) {
        return encoder.encode(bytes);
    }

    public static String encode(String string) {
        byte[] encode = encode(string.getBytes());
        return new String(encode, StandardCharsets.UTF_8);
    }

    public static String encode2String(byte[] bytes) {
        return encoder.encodeToString(bytes);
    }

    public static byte[] encode2Byte(String string) {
        return encode(string.getBytes());
    }

    public static byte[] urlEncode(byte[] bytes) {
        return urlEncoder.encode(bytes);
    }

    public static String urlEncode(String string) {
        byte[] encode = urlEncode(string.getBytes());
        return new String(encode, StandardCharsets.UTF_8);
    }

    public static String urlEncode2String(byte[] bytes) {
        return urlEncoder.encodeToString(bytes);
    }

    public static byte[] urlEncode2Byte(String string) {
        return urlEncode(string.getBytes());
    }

    //decode
    public static byte[] decode(byte[] bytes) {
        return decoder.decode(bytes);
    }

    public static byte[] decode2Byte(String string) {
        return decoder.decode(string.getBytes());
    }

    public static String decode2String(byte[] bytes) {
        return new String(decoder.decode(bytes), StandardCharsets.UTF_8);
    }

    public static String decode(String string) {
        byte[] decode = decode(string.getBytes());
        return new String(decode, StandardCharsets.UTF_8);
    }

    //urlDecode
    public static byte[] urlDecode(byte[] bytes) {
        return urlDecoder.decode(bytes);
    }

    public static byte[] urlDecode2Byte(String string) {
        return urlDecode(string.getBytes());
    }

    public static String urlDecode2String(byte[] bytes) {
        return new String(urlDecode(bytes), StandardCharsets.UTF_8);
    }

    public static String urlDecode(String string) {
        byte[] decode = urlDecode(string.getBytes());
        return new String(decode, StandardCharsets.UTF_8);
    }
}