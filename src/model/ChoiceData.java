package model;

public class ChoiceData {
    private String text;

    private String nextScene;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNextScene() {
        return nextScene;
    }

    public void setNextScene(String nextScene) {
        this.nextScene = nextScene;
    }

    @Override
    public String toString() {

        return "ChoiceData{" +
                "text='" + text + '\'' +
                ", nextScene='" + nextScene + '\'' +
                '}';
    }
}
