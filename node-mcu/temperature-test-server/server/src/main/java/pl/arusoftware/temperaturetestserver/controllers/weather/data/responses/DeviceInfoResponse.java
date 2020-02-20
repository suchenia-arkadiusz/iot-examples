package pl.arusoftware.temperaturetestserver.controllers.weather.data.responses;

public class DeviceInfoResponse {
    private String id;
    private String displayName;

    public DeviceInfoResponse() {}

    public DeviceInfoResponse(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "DeviceInfoResponse{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
