package service;

import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import model.StoryData;
import model.Story;
import model.Scene;
import model.SceneData;
import model.SceneType;

import java.util.ArrayList;
import java.util.List;

public class JsonLoader {
    public Story loadStory() {
        Story story = null;
        try {

            FileReader reader =
                    new FileReader(
                            "resources/story.json"
                    );

            Gson gson = new Gson();

            StoryData storyData =
                    gson.fromJson(
                            reader,
                            StoryData.class
                    );

            story = new Story();

            story.setTitle(
                    storyData.getTitle()
            );

            story.setDescription(
                    storyData.getDescription()
            );

            List<Scene> scenes =
                    new ArrayList<>();

            for (SceneData sceneData :
                    storyData.getScenes()) {

                Scene scene = new Scene();

                scene.setTitle(
                        sceneData.getTitle()
                );

                scene.setContent(
                        sceneData.getContent()
                );

                scene.setFearEffect(
                        sceneData.getFearEffect()
                );

                scene.setSceneType(
                        SceneType.valueOf(
                                sceneData.getSceneType()
                        )
                );

                scenes.add(scene);

            }

            story.setScenes(scenes);

            System.out.println(story);


            System.out.println(
                    storyData.getTitle()
            ); //GSON NOW READS JSON, CREATES JAVA OBJECT, FILLS FIELDS AUTOMATICALLY

            System.out.println(
                    storyData.getScenes()
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
        return story;
    }
}
