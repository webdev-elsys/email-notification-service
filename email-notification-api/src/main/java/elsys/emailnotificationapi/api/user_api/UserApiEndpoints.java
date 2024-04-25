package elsys.emailnotificationapi.api.user_api;

public class UserApiEndpoints {
    private static final String baseUrl = System.getenv("USER_SERVICE_API_URL");
    private static final String users = "/users";

    public static String getUserEmail(String userUuid) {
        return baseUrl + users + "/" + userUuid + "/email";
    }
}
