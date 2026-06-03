package model;
import java.util.List;

public class Story {

    private int id;
    private String title;
    private String description;
    private List<Scene> scenes;
    private Scene startingScene;


    public Story() {
    }

    public Story(int id, String title, String description, List<Scene> scenes, Scene startingScene) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.scenes = scenes;
        this.startingScene = startingScene;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", scenes=" + scenes +
                '}';
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public Scene getStartingScene() {
        return startingScene;
    }

    public void setStartingScene(Scene startingScene) {
        this.startingScene = startingScene;
    }
}