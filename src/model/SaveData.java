package model;

public class SaveData {
    private String currentSceneId;

    private int fearLevel;

    public String getCurrentSceneId() {
        return currentSceneId;
    }

    public void setCurrentSceneId(String currentSceneId) {
        this.currentSceneId = currentSceneId;
    }

    public int getFearLevel() {
        return fearLevel;
    }

    public void setFearLevel(int fearLevel) {
        this.fearLevel = fearLevel;
    }

    @Override
    public String toString() {

        return "SaveData{" +
                "currentSceneId='" + currentSceneId + '\'' +
                ", fearLevel=" + fearLevel +
                '}';
    }
}
