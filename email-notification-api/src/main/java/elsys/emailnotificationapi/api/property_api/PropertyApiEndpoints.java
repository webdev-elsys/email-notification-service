package elsys.emailnotificationapi.api.property_api;

public class PropertyApiEndpoints {
    private static final String baseUrl = System.getenv("PROPERTY_SERVICE_API_URL");
    private static final String properties = "/properties";

    public static String getOwnerUuidByPropertyUuid(String propertyUuid) {
        return baseUrl + properties + "/" + propertyUuid + "/ownerUuid";
    }
}
