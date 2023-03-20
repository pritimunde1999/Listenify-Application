package listenify.application;

public class Songs {

    public String title;

    public double duration;

    public Songs(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    //it is function provided by java to presenting the object in nice manner
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
