package ge.koala.swapit.objects;

/**
 * Created by Geolabedu on 19.12.15.
 */
public class AdObject {
    private String name,description,imageUrl,state,location;
    public AdObject(String name,String description,String imageUrl,String state,String location){
        this.name=name;
        this.description=description;
        this.imageUrl=imageUrl;
        this.state=state;
        this.location=location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
