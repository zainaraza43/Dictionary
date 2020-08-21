import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class Load {
    public static void main(String[] args) throws Exception {
        HttpResponse<String> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/hatchback/typeOf")
                .header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                .header("x-rapidapi-key", "52addc995dmsh1614c843ae3e988p1965cfjsn56f9eb0b6eb4")
                .asString();
    }
}
