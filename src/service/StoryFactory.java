package service;

import model.Choice;
import model.Scene;
import model.Story;
import model.SceneType;
import java.util.ArrayList;
import java.util.List;

public class StoryFactory {
    public Story createStory() {
        Story story = new Story();
        story.setTitle("The Cabin in Blackwood Forest");

        story.setDescription(
                "A branching horror story about a cursed cabin."
        );
        Scene introScene = new Scene();

        introScene.setTitle("Abandoned Cabin");

        introScene.setContent(
                "You enter a cold abandoned cabin deep in the forest."
        );

        introScene.setSceneType(SceneType.NORMAL);

        introScene.setFearEffect(10);

        introScene.setStory(story);

        Scene basementScene = new Scene();

        basementScene.setTitle("Dark Basement");

        basementScene.setContent(
                "The basement smells like rotten flesh."
        );

        basementScene.setSceneType(SceneType.DEATH);

        basementScene.setFearEffect(50);

        basementScene.setStory(story);

        Scene escapeScene = new Scene();

        escapeScene.setTitle("Forest Escape");

        escapeScene.setContent(
                "You sprint back into the forest while something follows you."
        );

        escapeScene.setSceneType(SceneType.ESCAPE);

        escapeScene.setFearEffect(-10);

        escapeScene.setStory(story);

        Choice basementChoice = new Choice();

        basementChoice.setChoiceText(
                "Open the basement door"
        );

        basementChoice.setNextScene(
                basementScene
        );

        List<Scene> scenes = new ArrayList<>();
        scenes.add(introScene);

        scenes.add(basementScene);

        scenes.add(escapeScene);

        story.setScenes(scenes);

        story.setStartingScene(introScene);


        Choice runChoice = new Choice();

        runChoice.setChoiceText(
                "Run outside"
        );

        runChoice.setNextScene(
                escapeScene
        );


        List<Choice> introChoices =
                new ArrayList<>();

        introChoices.add(basementChoice);

        introChoices.add(runChoice);


        introScene.setChoices(introChoices);

        return story;
    }
}
