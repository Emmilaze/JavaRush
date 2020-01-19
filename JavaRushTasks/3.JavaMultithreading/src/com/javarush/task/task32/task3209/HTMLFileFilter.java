package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.getName().toLowerCase()).contains((".html").toLowerCase()) || (f.getName().toLowerCase()).contains((".htm").toLowerCase()) || f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
