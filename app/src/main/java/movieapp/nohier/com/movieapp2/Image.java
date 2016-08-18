package movieapp.nohier.com.movieapp2;

/**
 * Created by mohamed k on 15/08/2016.
 */
public class Image {
    private String title;
    private String path;
    private String overview;
    private double vote;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }



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

    public Image(String title, String path,String overview,double vote) {
        this.title = title;
        this.path = path;
        this.overview = overview;
        this.vote=  vote;
    }
}
