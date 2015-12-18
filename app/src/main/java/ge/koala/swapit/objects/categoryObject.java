package ge.koala.swapit.objects;

/**
 * Created by dalkh on 19-Dec-15.
 */
public class categoryObject {
    private String name;
    private int categoryIcon;
    public categoryObject(String name, int categoryIcon) {
        this.name = name;
        this.categoryIcon = categoryIcon;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(int categoryIcon) {
        this.categoryIcon = categoryIcon;
    }


}
