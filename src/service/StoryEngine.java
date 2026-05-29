package service;

import model.*;

import java.util.Scanner;

public class StoryEngine {

    public void playStory(Story story) {

        Scanner sc = new Scanner(System.in);

        PlayerState playerState=new PlayerState();
        playerState.setFearLevel(0);

        Scene currentScene = story.getStartingScene();

        while (currentScene != null) {

            displayScene(currentScene, playerState);

            if (currentScene.getChoices() == null ||
                    currentScene.getChoices().isEmpty()) {

                break;
            }

            System.out.println("\nChoose an option:");

            int userChoice = sc.nextInt();

            if (userChoice < 1 ||
                    userChoice > currentScene.getChoices().size()) {

                System.out.println("Invalid choice.");
                return;
            }

            Choice selectedChoice =
                    currentScene.getChoices().get(userChoice - 1);

            Scene nextScene =
                    selectedChoice.getNextScene();

            currentScene = nextScene;
        }

        System.out.println("\nStory finished.");

        System.out.println("Play again? (y/n)");

        String answer = sc.next();

        if (answer.equalsIgnoreCase("y")) {

            playStory(story);

        }
    }

    public void displayScene(Scene scene, PlayerState playerState) {

        System.out.println("\nSCENE:");

        System.out.println(scene.getTitle());

        System.out.println(scene.getContent());

        playerState.setFearLevel(playerState.getFearLevel()+ scene.getFearEffect());

        System.out.println("\n Fear Level: "+ playerState.getFearLevel());

        if(scene.getSceneType()== SceneType.DEATH){

            System.out.println("\nYou Died");
            System.out.println("Fear level: " + playerState.getFearLevel());
        }

        if(scene.getSceneType()== SceneType.ESCAPE){
            System.out.println("\nYou Escaped");
        }

        if (scene.getChoices() == null ||
                scene.getChoices().isEmpty()) {

            System.out.println("\nTHE END");

            return;
        }

        System.out.println("\nCHOICES:");

        for (int i = 0;
             i < scene.getChoices().size();
             i++) {

            Choice choice =
                    scene.getChoices().get(i);

            System.out.println(
                    (i + 1) + ". " +
                            choice.getChoiceText()
            );
        }
    }
}