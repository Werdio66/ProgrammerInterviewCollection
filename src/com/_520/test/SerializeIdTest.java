package com._520.test;

import java.io.*;

/**
 * @author Werdio丶
 * @since 2020-08-19 15:09:27
 */

public class SerializeIdTest implements java.io.Serializable {

    private static final long serialVersionUID = 868389L;

    private String name = "fhaghakha";

    @Override
    public String toString() {
        return "SerializeIdTest{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        String path = new File("").getCanonicalPath();
        path += "\\text.txt";
        System.out.println(path);
        OutputStream outputStream = new FileOutputStream(path);

        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        oos.writeObject(new SerializeIdTest());

        oos.flush();


        FileInputStream in = new FileInputStream(path);

        ObjectInputStream ois = new ObjectInputStream(in);

        Object o = ois.readObject();
        System.out.println(o);

    }


}
