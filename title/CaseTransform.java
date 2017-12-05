package title;

/**
 * Created by tsmen on 11/30/2017.
 */
public class CaseTransform {

    private String words="aboard, about, above, across, cross, after, against, along, alongside, amid," +
            "among, around, round, as, at, on, atop, before, behind, below, beneath, beside, besides, between, beyond, " +
            "by, despite, down, during, except, for, from, in, inside, into, less, like, near, of, off, on, onto, opposite, " +
            "out, outside, over, past, since, than, through, throughout, to, toward, towards, " +
            "under, underneath, unlike, until, up, upon, with, within, without, worth,after, although, as, " +
            "as if, as long as, as much as, as soon as, as though, because, before, even if, even though, if, " +
            "in case, lest, once, only if, provided that, since, so that, than, that, though, till, unless, until, " +
            "when, whenever, where, wherever, while";


    public String transfor(String title){
        //transform the whole title to uppercase
        String newtitle=title.toUpperCase();

        //take out the head and tail word
        String[] titlewords=newtitle.split(" ");
        int lastWord=titlewords.length-1;
        StringBuffer buffer=new StringBuffer();
        for (int i=1;i<titlewords.length-1;i++){
            buffer.append(titlewords[i]);
            buffer.append(" ");
        }
        newtitle=buffer.toString();

        //set Prepositions and Subordinating conjunctions to lowercase
        words=words.replaceAll("\\s*", "");
        String[] wordlist=words.split(",");
        for (String str:wordlist){
            String up=str.toUpperCase();
            newtitle=newtitle.replaceAll(up,str);
        }

        //combine the head, middle, tail words
        newtitle=titlewords[0]+" "+newtitle+titlewords[lastWord];

        return newtitle;
    }
}
