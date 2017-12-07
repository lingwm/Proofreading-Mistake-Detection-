package tense_change;

/**
 * Created by Lingwei Meng on 2017/12/3.
 */
public class TenseResult {
    public String content;
    public String advice;

    public TenseResult() {
        content="";
        advice="";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
