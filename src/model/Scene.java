package model;

import java.util.List;

public class Scene {

    private int id;
    private String title;
    private String content;
    private SceneType sceneType;
    private Story story;
    private List<Choice> choices;
    private int fearEffect;


    public Scene() {
    }

    public Scene(int id, String title, String content, List<Choice> choices, Story story, SceneType sceneType, int fearEffect) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.choices = choices;
        this.story=story;
        this.sceneType = sceneType;
        this.fearEffect=fearEffect;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", choices=" + choices +
                '}';
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
    }

    public int getFearEffect() {
        return fearEffect;
    }

    public void setFearEffect(int fearEffect) {
        this.fearEffect = fearEffect;
    }
}