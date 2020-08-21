package com._520.test;

import java.io.*;

/**
 * @author Werdio丶
 * @since 2020-08-13 14:28:42
 */
public class ClassLoaderTest extends ClassLoader {

    private String path;

    public ClassLoaderTest(String path) {
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        return Class.forName(name, true, this);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classes = getClassByteData(name);

        assert classes != null;

        return defineClass(name, classes, 0, classes.length);

    }

    private byte[] getClassByteData(String name) {
        String filePath = "";
        try {
            filePath += new File("").getCanonicalPath() + "\\src";
            System.out.println(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath += File.separator + name.replace('.', File.separatorChar) + ".java";
        System.out.println(filePath);

        FileInputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        byte[] buffer = new byte[2048];

        try {
            inputStream = new FileInputStream(filePath);
            outputStream = new ByteArrayOutputStream();
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1){
                System.out.println(len);
                outputStream.write(buffer, 0, len);
            }

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderTest c = new ClassLoaderTest("F:\\\\");
        Class<?> aClass = c.findClass("com._520.test.User");
        System.out.println(aClass.getClassLoader());
    }
}
