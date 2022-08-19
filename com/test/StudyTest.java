package com.test;

//import jdk.internal.vm.annotation.Stable;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudyTest implements Serializable {



//    @java.io.Serial
    public static void main(String[] args) {
        String key1 = "    aaa    ";
        System.out.println("    aaa    ".hashCode());
        System.out.println(key1.hashCode());
        String key2 = key1.intern();
        System.out.println(key1 == key2);

        String s1 = new String("a");
        String s2 =s1.intern();
        String s3 = "a";
        System.out.println("a hashcode "+ System.identityHashCode("a"));
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));


        System.out.println("--------------");
        //1： 首先会在Heap中创建对象，然后在常量池中放入zhagnsan 和 wangwu ，但是并不会放入zhagnsanwangwu
        String a = new String("zhangsan") + "wangwu";
        // 2：调用 intern ，因为字符串常量池中没有”zhangsanwangwu”这种拼接后的字符串，
        // 所以将堆中String对象的引用地址添加到字符串常量池中。jdk1.7后常量池引入到了Heap中，所以可以直接存储引用
        String b = a.intern();
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

        // 3：因为 a 的地址和 b的地址一致，锁以是true
        System.out.println(a == b);

        //4：因常量池中已经存在 zhangsanwangwu 了，所以直接返回引用就是 a 类型 a ==b 锁 a==b==c
        String c = "zhangsanwangwu";
        System.out.println(a == c); // true
        System.out.println(b == c); // true

        // 5：首先会在Heap中创建对象，然后会在常量池中存储 zhang 和 san
        String d = new String("zhang") + "san";
        // 6： 返回的是 常量池中的 地址，因在a变量时已经将 zhangsan 放入到了常量池中
        String f = d.intern();
        System.out.println(d = f); // false


        String k1 = "112";
        String k2 = new String("");
        System.out.println(1);
        char[] abc = new char[10];
        byte[] bytes = new byte[2];
        try {
//            Charset charset =  Charset.availableCharsets();
            Charset charset = StandardCharsets.UTF_8;
            String k3 = new String(bytes,0,1,"ISO-8859-1");
            String k4 = new String(bytes,0,1,"ISO-8859-1");

            System.out.println(k3);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }


        byte[] bytes1 = k1.getBytes();

        byte[] bytes2 = "".getBytes();

        byte[] bytes3 = "小明".getBytes();

        byte[] bytes4 = "\u0000".getBytes();

        char c1 = 'a';
        char c2 = '啊';
        char c3 = '\1';

        int x = 6500000;
//        Character.highSurrogate(x);
        char c4 = (char)x;
        System.out.println(c4);

        String str = "jaflkdjslkjal";
        int length = str.length();
        int max = Integer.MAX_VALUE;
        length = 2147483631;
        System.out.println("======");
        //65536-16
        int capacity = (length < Integer.MAX_VALUE - 16)
                ? length + 16 : Integer.MAX_VALUE;
        //false

        System.out.println(capacity);
        length = length-10000;
        int capacity1 = (length < Integer.MAX_VALUE - 16)
                ? length + 16 : Integer.MAX_VALUE;

        System.out.println(capacity1);
        //        while (true){
//            int i = 1;
//        }
        boolean ss = str.contentEquals(new StringBuffer("jaflkdjslkj"));
        boolean ss1 = str.contentEquals(new StringBuffer("jaflkdjslkjal"));

        System.out.println(ss);
        System.out.println(ss1);




        List<Character> chars = new ArrayList<>();
        for (int i = 0; i< 1000; i++){
            char ccc = (char)i ;
            chars.add(ccc);
            System.out.println(i + "   "+ ccc);
        }
        System.out.println(1);



        java.security.Permission permission;


        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        for (Integer integer : integerList){

        }
        for(int i = 0; i<integerList.size();i++){

        }
    }




}
