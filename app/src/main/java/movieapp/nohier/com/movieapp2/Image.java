package movieapp.nohier.com.movieapp2;

/**
 * Created by mohamed k on 15/08/2016.
 */
public class Image {
    private String title;
    private String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Image(String title, String path) {
        this.title = title;
        this.path = path;
    }
}
