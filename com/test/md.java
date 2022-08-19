package com.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class md {

    static String special1 = "Deprecated";

    public static void main(String[] args) {

        List<String> resList = buildList();
        System.out.println("resList " + resList.size());
        boolean isConstructor = true;

        if (isConstructor) {
            constructor(resList);

        } else {
            method(resList);
        }
    }

    private static void method(List<String> strings) {
        Res res = null;
        List<Res> resList = new ArrayList<>();
        int index = 0;
        for (String val : strings) {
            index++;
            if (index == 1) {
//                res = new Res();
                res.setResp(val);
            }
            if (index == 2) {
                res.setMethod(val);
            }
            if (index == 3) {
                res.setDes(val);
                resList.add(res);
                res = null;
                index = 0;
            }
        }

        resList.forEach(e -> System.out.println(e.getResp() + " " + e.getMethod()));

    }

    private static void constructor(List<String> strings) {

        strings = strings.stream().filter(e -> (!"```".equals(e) && !e.contains(special1))).collect(Collectors.toList());
        Res res = null;
        List<Res> resList = new ArrayList<>();
        int index = 0;
        for (String val : strings) {
            index++;
            if (index == 1) {
                res = new Res(val);
            } else {
                res.setDes(val);
                resList.add(res);
                res = null;
                index = 0;
            }
        }
        resList.forEach(e -> System.out.println(e.method  ));
    }

    private static List<String> buildList() {
        try {
            String path = "/Users/sx/Desktop/1.md";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            List<String> strings = new ArrayList<>();
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                boolean can = checkStr(line);
                if (can) {
                    continue;
                }
                strings.add(line);
            }
            return strings;
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    private static boolean checkStr(String line) {
        if (line == null) {
            System.out.println(1);
            return true;
        }
        if (line.length() == 0) {
            System.out.println(2);
            return true;
        }
        return line.contains(special1);
    }
}


class Res {

    String resp;

    String method;

    String des;

    public Res(String val) {
        this.method = val;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}