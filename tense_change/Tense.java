package tense_change;

import edu.stanford.nlp.ling.CoreAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.POSTaggerAnnotator;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.simple.*;

import java.util.List;
import java.util.Properties;

/**
 * Created by tsmen on 11/30/2017.
 */
public class Tense {

    /*
    public void tenseTran(String text){
        Properties props= new Properties();
        props.setProperty("annotators","tokenize, ssplit, pos");
        StanfordCoreNLP pipeline=new StanfordCoreNLP(props);
        Annotation annotation=new Annotation(text);
        pipeline.annotate(annotation);

        List<CoreMap> sentences=annotation.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence:sentences){
            for (CoreLabel token:sentence.get(CoreAnnotations.TokensAnnotation.class)){
                String word=token.get(CoreAnnotations.TextAnnotation.class);
                String pos=token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println(word + "/" + pos);
            }
        }
    }
    */

    public String simple(String s){
        String edit=s;
        String advice="";
        Document doc = new Document(s);
        for (Sentence sent : doc.sentences()) {
            for (Token token: sent.tokens()){
                String word=token.word();
                String pos=token.posTag();
                String change;
                if (pos.equals("VBD")){
                    String highlight="~"+word+"\\$";
                    edit=edit.replaceAll(word,highlight);
                    advice=advice+"recommend: "+word+"---->"+token.lemma()+"\n";
                }
            }
        }
        //tr.content=edit;
        return edit+"\n"+"SPLIT_SYMBOL"+advice;
    }

/*
    public TenseResult simple(String s){
        TenseResult tr=new TenseResult();
        String edit=s;
        Document doc = new Document(s);
        for (Sentence sent : doc.sentences()) {
            for (Token token: sent.tokens()){
                String word=token.word();
                String pos=token.posTag();
                String change;
                if (pos.equals("VBD")){
                    String highlight="~"+word+"\\$";
                    edit=edit.replaceAll(word,highlight);
                    tr.advice=tr.advice+"recommend: "+word+"---->"+token.lemma()+"\n";
                }
            }
        }
        tr.content=edit;
        return tr;
    }*/
}
