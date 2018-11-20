package com.simbirsoft.qaa.course.task1;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class ClipboardHelper {

    public void putTextIntoClipboard(String text) {
        StringSelection content = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
    }

    public String getTextFromClipboard() throws IOException, UnsupportedFlavorException {
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        return (String) contents.getTransferData(DataFlavor.stringFlavor);
    }
}
