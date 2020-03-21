package com.company;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Created by chupacabra on 12/12/15.
 */
public class CharCount {

    public static void main(String[] args) throws Exception {
        String line;
        int stringCode = 0;
        int stringMemValue = 0;
        int stringEscaped = 0;

        BufferedReader in = new BufferedReader(new FileReader("Text_Files/stringstocount.txt"));

        while ((line = in.readLine()) != null) {
            int currentNum = 0;
            stringCode += line.length();
            stringMemValue += line.length();
            stringEscaped += StringEscapeUtils.escapeJava(line).length() + 2;
            while(currentNum < line.length()){
                switch (line.charAt(currentNum)) {
                    case '\"':
                        --stringMemValue;
                        ++currentNum;
                        break;
                    case '\\':
                        stringMemValue -= 1;
                        if(line.charAt(currentNum + 1) == 'x') {
                            stringMemValue -= 2;
                            currentNum += 4;
                        } else {
                            currentNum += 2;
                        }
                        break;
                    default:
                        ++currentNum;
                }
            }
        }
        int total = stringCode - stringMemValue;
        int escapedTotal = stringEscaped - stringCode;
        System.out.println("TOTAL: " + total);
        System.out.println("ESCAPTED TOTAL: " + escapedTotal);
    }
}
