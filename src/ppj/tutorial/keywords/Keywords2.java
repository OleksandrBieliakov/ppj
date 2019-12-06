package ppj.tutorial.keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public
class Keywords2 {


    public static void main(String[] args){
        new Keywords2();
    }

    public Keywords2(){

        String data = this.fisToStringBuffer(
                "src\\ppj\\tutorial\\keywords\\Keywords2.java"
        );

        for(int i=0;i<keyWords.length; i++) {
            int last = 0;
            int count = 0;
            while ((last = data.indexOf(keyWords[i], last + 1)) != -1) {
                count++;
            }
            System.out.println(keyWords[i] + " " + count);
        }
    }

    public String[] keyWords = {
            "abstract","continue","for","new","switch","assert","default","if","package","synchronized","boolean","do","goto","private","this","break","double","implements","protected","throw","byte","else","import","public","throws","case","enum","instanceof","return","transient","catch","extends","int","short","try","char","final","interface","static","void","class","finally","long","strictfp","volatile","const","float","native","super","while"
    };

    public String fisToStringBuffer(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            StringBuffer str = new StringBuffer();
            int read;
            while((read = fis.read()) != -1){
                str.append((char)read);
            }
            return str.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}