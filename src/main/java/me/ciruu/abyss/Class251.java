package me.ciruu.abyss;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import me.ciruu.abyss.Class250;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.managers.RunnableManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class Class251 {
    private static final Logger Field809;
    static final boolean Field810;

    public static void Method1066(String string, String string2, Consumer consumer) {
        RunnableManager.runRunnable(() -> Class251.Method1067(string, string2, consumer));
    }

    private static void Method1068(DynamicTexture dynamicTexture) {
        try {
            for (Field field : DynamicTexture.class.getDeclaredFields()) {
                if (!field.getType().getTypeName().equals(int[].class.getTypeName())) continue;
                field.setAccessible(true);
                field.set(dynamicTexture, new int[0]);
                break;
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    public static void Method1069(String string, String string2, BiConsumer biConsumer) {
        RunnableManager.runRunnable(() -> Class251.Method1070(string, string2, biConsumer));
    }

    private static void Method1071(InputStream inputStream, Consumer consumer) throws IOException {
        int n;
        IIOMetadataNode iIOMetadataNode;
        Object object;
        Object object2;
        Object object3;
        ArrayList<Object> arrayList = new ArrayList<Object>(2);
        ImageReader imageReader = ImageIO.getImageReadersByFormatName("gif").next();
        imageReader.setInput(ImageIO.createImageInputStream(inputStream));
        int n2 = 0;
        int n3 = 0;
        int n4 = -1;
        int n5 = -1;
        IIOMetadata iIOMetadata = imageReader.getStreamMetadata();
        Color color = null;
        if (iIOMetadata != null) {
            object3 = (IIOMetadataNode)iIOMetadata.getAsTree(iIOMetadata.getNativeMetadataFormatName());
            NodeList nodeList = ((IIOMetadataNode)object3).getElementsByTagName("GlobalColorTable");
            NodeList nodeList2 = ((IIOMetadataNode)object3).getElementsByTagName("LogicalScreenDescriptor");
            if (nodeList2 != null && nodeList2.getLength() > 0 && (object2 = (IIOMetadataNode)nodeList2.item(0)) != null) {
                n4 = Integer.parseInt(((IIOMetadataNode)object2).getAttribute("logicalScreenWidth"));
                n5 = Integer.parseInt(((IIOMetadataNode)object2).getAttribute("logicalScreenHeight"));
            }
            if (nodeList != null && nodeList.getLength() > 0 && (object2 = (IIOMetadataNode)nodeList.item(0)) != null) {
                object = ((IIOMetadataNode)object2).getAttribute("backgroundColorIndex");
                for (iIOMetadataNode = (IIOMetadataNode)((IIOMetadataNode)object2).getFirstChild(); iIOMetadataNode != null; iIOMetadataNode = (IIOMetadataNode)iIOMetadataNode.getNextSibling()) {
                    if (!iIOMetadataNode.getAttribute("index").equals(object)) continue;
                    int n6 = Integer.parseInt(iIOMetadataNode.getAttribute("red"));
                    n = Integer.parseInt(iIOMetadataNode.getAttribute("green"));
                    int n7 = Integer.parseInt(iIOMetadataNode.getAttribute("blue"));
                    color = new Color(n6, n, n7);
                    break;
                }
            }
        }
        object3 = null;
        boolean bl = false;
        int n8 = 0;
        while (true) {
            Object object4;
            int n9;
            try {
                object2 = imageReader.read(n8);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                break;
            }
            if (n4 == -1 || n5 == -1) {
                n4 = ((BufferedImage)object2).getWidth();
                n5 = ((BufferedImage)object2).getHeight();
            }
            object = (IIOMetadataNode)imageReader.getImageMetadata(n8).getAsTree("javax_imageio_gif_image_1.0");
            iIOMetadataNode = (IIOMetadataNode)((IIOMetadataNode)object).getElementsByTagName("GraphicControlExtension").item(0);
            NodeList nodeList = ((IIOMetadataNode)object).getChildNodes();
            n = Integer.parseInt(iIOMetadataNode.getAttribute("delayTime"));
            String string = iIOMetadataNode.getAttribute("disposalMethod");
            if (object3 == null) {
                object3 = new BufferedImage(n4, n5, 2);
                ((BufferedImage)object3).createGraphics().setColor(color);
                ((BufferedImage)object3).createGraphics().fillRect(0, 0, ((BufferedImage)object3).getWidth(), ((BufferedImage)object3).getHeight());
                bl = ((BufferedImage)object2).getWidth() == n4 && ((BufferedImage)object2).getHeight() == n5;
                ((BufferedImage)object3).createGraphics().drawImage((Image)object2, 0, 0, null);
            } else {
                int n10 = 0;
                int n11 = 0;
                for (n9 = 0; n9 < nodeList.getLength(); n9 += 1) {
                    object4 = nodeList.item(n9);
                    if (!object4.getNodeName().equals("ImageDescriptor")) continue;
                    NamedNodeMap namedNodeMap = object4.getAttributes();
                    n10 = Integer.parseInt(namedNodeMap.getNamedItem("imageLeftPosition").getNodeValue());
                    n11 = Integer.parseInt(namedNodeMap.getNamedItem("imageTopPosition").getNodeValue());
                }
                if (string.equals("restoreToPrevious")) {
                    BufferedImage bufferedImage = null;
                    for (int i = n8 - 1; i >= 0; --i) {
                        if (((Class250)arrayList.get(i)).Method956().equals("restoreToPrevious") && n8 != 0) continue;
                        bufferedImage = ((Class250)arrayList.get(i)).Method954();
                        break;
                    }
                    if (!Field810 && bufferedImage == null) {
                        throw new AssertionError();
                    }
                    object4 = bufferedImage.getColorModel();
                    boolean bl2 = bufferedImage.isAlphaPremultiplied();
                    WritableRaster writableRaster = bufferedImage.copyData(null);
                    object3 = new BufferedImage((ColorModel)object4, writableRaster, bl2, null);
                } else if (string.equals("restoreToBackgroundColor") && color != null && (!bl || n8 > 1)) {
                    ((BufferedImage)object3).createGraphics().fillRect(n2, n3, ((Class250)arrayList.get(n8 - 1)).Method957(), ((Class250)arrayList.get(n8 - 1)).Method958());
                }
                ((BufferedImage)object3).createGraphics().drawImage((Image)object2, n10, n11, null);
                n2 = n10;
                n3 = n11;
            }
            Object object5 = ((BufferedImage)object3).getColorModel();
            n9 = ((BufferedImage)object3).isAlphaPremultiplied() ? 1 : 0;
            object4 = ((BufferedImage)object3).copyData(null);
            BufferedImage bufferedImage = new BufferedImage((ColorModel)object5, (WritableRaster)object4, n9 != 0, null);
            object5 = new Class250(bufferedImage, n, string, ((BufferedImage)object2).getWidth(), ((BufferedImage)object2).getHeight());
            arrayList.add(object5);
            consumer.accept(object5);
            System.gc();
            ((Image)object3).flush();
            ++n8;
        }
        imageReader.dispose();
        System.gc();
    }

    private static void Method1070(String string, String string2, BiConsumer biConsumer) {
        try {
            Field809.info("Loading image '" + string + "' from" + string2);
            InputStream inputStream = new URL(string2).openStream();
            Class251.Method1071(inputStream, arg_0 -> Class251.Method1072(string, biConsumer, arg_0));
            inputStream.close();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void Method1072(String string, BiConsumer biConsumer, Class250 class250) {
        RunnableManager.addRunnableAsTask(() -> Class251.Method1073(class250, string, biConsumer));
    }

    private static void Method1073(Class250 class250, String string, BiConsumer biConsumer) {
        DynamicTexture dynamicTexture = new DynamicTexture(Class250.Method959(class250));
        ResourceLocation resourceLocation = Globals.mc.getTextureManager().getDynamicTextureLocation("abyss/capes_" + string, dynamicTexture);
        Class251.Method1068(dynamicTexture);
        biConsumer.accept(resourceLocation, Class250.Method960(class250));
        int n = Class250.Method959(class250).getWidth() * Class250.Method959(class250).getHeight() * 4 / 1024;
        Field809.info("Loaded image '" + string + "' (" + Class250.Method959(class250).getWidth() + " x" + Class250.Method959(class250).getHeight() + ") bytes:" + n + "kB");
    }

    private static void Method1067(String string, String string2, Consumer consumer) {
        try {
            Field809.info("Loading image '" + string + "' from" + string2);
            BufferedImage bufferedImage = ImageIO.read(new URL(string2));
            RunnableManager.addRunnableAsTask(() -> Class251.Method1074(bufferedImage, string, consumer));
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void Method1074(BufferedImage bufferedImage, String string, Consumer consumer) {
        DynamicTexture dynamicTexture = new DynamicTexture(bufferedImage);
        ResourceLocation resourceLocation = Globals.mc.getTextureManager().getDynamicTextureLocation("abyss/capes_" + string, dynamicTexture);
        Class251.Method1068(dynamicTexture);
        consumer.accept(resourceLocation);
        int n = bufferedImage.getWidth() * bufferedImage.getHeight() * 4 / 1024;
        Field809.info("Loaded image '" + string + "' (" + bufferedImage.getWidth() + " x" + bufferedImage.getHeight() + ") bytes:" + n + "kB");
    }

    static {
        Field810 = !Class251.class.desiredAssertionStatus();
        Field809 = LogManager.getLogger((String)"Image Util");
    }
}
