package test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by ls on 18/7/10.
 */
public class Base64Test {

    public static void main(String[]args){
        byte[] data = "ls".getBytes();
        String encode = new BASE64Encoder().encode(data);
        System.out.println(encode);
        try {
            byte[] bytes = new BASE64Decoder().decodeBuffer(encode);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
