package com.simbirsoft.qaa.course.task3.Helpers;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardHelper {

    public static void putTextIntoClipboard(String text) {
        StringSelection content = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
    }

    public static String getTextFromClipboard() throws IOException, UnsupportedFlavorException {
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        return (String) contents.getTransferData(DataFlavor.stringFlavor);
    }
}
