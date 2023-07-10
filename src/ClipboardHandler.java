import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardHandler implements ClipboardOwner {
    private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public ClipboardHandler() {
        clipboard.setContents(clipboard.getContents(null), this);
    }

    public static String getSysClipboardText() {
        String ret = "";
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipTf = clipboard.getContents(null);
        if (clipTf != null) {
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    ret = (String) clipTf
                            .getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    /**
     * 2.将字符串复制到剪切板。
     */
    public static void setSysClipboardText(String writeMe) {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clipboard.setContents(tText, null);
    }

    /**
     * 3. 从剪切板获得图片。
     */
    public static Image getImageFromClipboard() throws Exception {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable cc = clipboard.getContents(null);
        if (cc == null)
            return null;
        else if (cc.isDataFlavorSupported(DataFlavor.imageFlavor))
            return (Image) cc.getTransferData(DataFlavor.imageFlavor);
        return null;

    }

    /**
     * 4.复制图片到剪切板。
     */
    public static void setClipboardImage(final Image image) throws Exception {
        Transferable trans = new Transferable() {
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.imageFlavor};
            }

            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return DataFlavor.imageFlavor.equals(flavor);
            }

            public Object getTransferData(DataFlavor flavor)
                    throws UnsupportedFlavorException, IOException {
                if (isDataFlavorSupported(flavor))
                    return image;
                throw new UnsupportedFlavorException(flavor);
            }

        };
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans,
                null);
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String text = null;
        Object image = null;
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                // 获取文本数据
                if (contents.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    image = contents.getTransferData(DataFlavor.imageFlavor);
                } else {
                    text = (String) clipboard.getData(DataFlavor.stringFlavor);
                }
            } catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
        }
        //xxx back
        clipboard.setContents(clipboard.getContents(null), this);
    }
}