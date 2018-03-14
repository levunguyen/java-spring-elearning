package elearning.demo.utility;

public class Constants {

    public static final String URI_API = "/api";

    public static final String URI_VIDEO = "/video";

    public static final String URI_COURSES = "/courses";
    public static final String URI_COURSE = "/course";
    public static final String SIGN_UP_URL = "/sign-up";

    public static final String SECRET = "elearning";
    public static final long EXPIRATION_TIME = 86400000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    private Constants() {
        throw new InstantiationError( "Must not instantiate this class" );
    }

}
