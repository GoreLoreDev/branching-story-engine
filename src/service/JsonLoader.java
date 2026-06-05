package service;

import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

            Map<String, Scene> sceneMap =
                    new HashMap<>();

            for (SceneData sceneData :
                    storyData.getScenes()) {

                Scene scene = new Scene();

                scene.setChoices(
                        new ArrayList<>()
                );

                scene.setSceneId(
                        sceneData.getId()
                );

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

                sceneMap.put(
                        scene.getSceneId(),
                        scene
                );

            }

            for (SceneData sceneData :
                    storyData.getScenes()) {
                Scene currentScene =
                        sceneMap.get(
                                sceneData.getId()
                        );


                List<Choice> choices =
                        new ArrayList<>();
                if (sceneData.getChoices() == null) {

                    continue;
                }

                for (ChoiceData choiceData :
                        sceneData.getChoices()) {
                    Choice choice = new Choice();

                    choice.setChoiceText(
                            choiceData.getText()
                    );

                    Scene nextScene =
                            sceneMap.get(
                                    choiceData.getNextScene()
                            );

                    choice.setNextScene(
                            nextScene
                    );

                    choices.add(choice);

                }

                currentScene.setChoices(
                        choices
                );
            }

            story.setScenes(scenes);

            for (Scene scene : scenes) {

                if (scene.getSceneId().equals(
                        storyData.getStartingScene()
                )) {

                    story.setStartingScene(scene);

                    break;
                }
            }


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
