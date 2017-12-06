import tense_change.Tense;
import tense_change.TenseResult;
import title.CaseTransform;

/**
 * Created by Lingwei Meng on 2017/12/1.
 */
public class Run {
    public static void main(String args[]){

        String title="to rjfh before djahd as";
        CaseTransform c=new CaseTransform();
        String newtitle=c.transfor(title);
        System.out.println(newtitle);

        /*
        Tense tense=new Tense();
        String s="I went to school. He recommended this book.";
        TenseResult tr=tense.simple(s);
        System.out.println(tr.content);
        if (tr.advice!=null){
            System.out.println(tr.advice);
        }
        */



    }
}
