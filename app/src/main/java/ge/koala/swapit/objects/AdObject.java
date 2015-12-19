package ge.koala.swapit.objects;

/**
 * Created by Geolabedu on 19.12.15.
 */
public class AdObject {
    private String name,description,imageUrl;
    public AdObject(String name,String description,String imageUrl){
        this.name=name;
        this.description=description;
        this.imageUrl=imageUrl;
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
