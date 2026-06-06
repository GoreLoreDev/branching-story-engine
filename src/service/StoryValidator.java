package service;
import model.*;

import java.util.HashSet;
import java.util.Set;

public class StoryValidator {

    public void validateStory(Story story) {
        Set<String> validSceneIds =
                new HashSet<>();

        for (Scene scene :
                story.getScenes()) {

            validSceneIds.add(
                    scene.getSceneId()
            );

        }
        for (Scene scene :
                story.getScenes()) {

            for (Choice choice :
                    scene.getChoices()) {
                Scene nextScene =
                        choice.getNextScene();

                if (nextScene == null) {

                    System.out.println(
                            "ERROR: Broken scene reference in scene: "
                                    + scene.getSceneId()
                    );
                }

            }

        }
    }
}
