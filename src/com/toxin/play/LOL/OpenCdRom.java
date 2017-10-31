package com.toxin.play.LOL;

import java.io.File;
import java.io.FileWriter;

public class OpenCdRom {
    public static void open(String drive) {
        try {
            File file = File.createTempFile("realhowto",".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
                    + "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
                    + drive + "\") \n"
                    + "cd.Eject";
            fw.write(vbs);
            fw.close();
            Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
                        null, "Press OK to open CD", "CDUtils",
                javax.swing.JOptionPane.DEFAULT_OPTION);
        OpenCdRom.open("D:\\");
    }
}