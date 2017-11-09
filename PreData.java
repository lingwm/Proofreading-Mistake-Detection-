import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Created by Lingwei Meng on 2017/11/1.
 */
public class PreData {
    public static void main(String args[]){

        String text="";
        String s1="Abstract";
        String s2="Key words";
        File root=new File("rowdata");
        File[] files=root.listFiles();
        for(File file:files){
            //2003
            if(file.getName().endsWith(".doc")){
                try {
                    FileInputStream stream = new FileInputStream(file);
                    WordExtractor word = new WordExtractor(stream);
                    text = word.getText();
                    //去掉word文档中的多个换行
                    text = text.replaceAll("(\\r\\n){2,}", "\r\n");
                    text = text.replaceAll("(\\n){2,}", "\n");
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if(file.getName().endsWith(".docx")){       //2007
                try {
                    OPCPackage oPCPackage = POIXMLDocument.openPackage(file.getPath());
                    XWPFDocument xwpf = new XWPFDocument(oPCPackage);
                    POIXMLTextExtractor ex = new XWPFWordExtractor(xwpf);
                    text = ex.getText();
                    //去掉word文档中的多个换行
                    text = text.replaceAll("(\\r\\n){2,}", "\r\n");
                    text = text.replaceAll("(\\n){2,}", "\n");
                    System.out.println("ok");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int begin=text.indexOf(s1);
            int end=text.indexOf(s2);
            String result=text.substring(begin+10,end);

            String filename=file.getName();
            String outFilename=filename.substring(0,filename.indexOf(".doc"))+".txt";
            File output=new File("data/"+outFilename);
            try {
                if(!output.exists()){
                    output.createNewFile();
                }
                Writer writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
                writer.write(result);
                writer.flush();
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
