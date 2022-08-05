package zxf.springboot.forwardservice.support.httpforward;

import java.net.URI;
import java.util.regex.Pattern;

public class HttpForwardUrlForward {
    private final URI baseUrl;
    private final Pattern pathMatch;
    private final String pathReplace;

    private HttpForwardUrlForward(URI baseUrl, Pattern pathMatch, String pathReplace) {
        this.baseUrl = baseUrl;
        this.pathMatch = pathMatch;
        this.pathReplace = pathReplace;
    }

    public static HttpForwardUrlForward create(String baseUrl, String pathMatch, String pathReplace) {
        return new HttpForwardUrlForward(URI.create(baseUrl), Pattern.compile(pathMatch), pathReplace);
    }

    public URI getForwardUrl(URI originalUrl) {
        return null;
    }
}
