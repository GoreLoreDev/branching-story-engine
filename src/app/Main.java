package app;

import model.Choice;
import model.Scene;
import model.Story;
import service.StoryFactory;

import java.util.ArrayList;
import java.util.List;
import service.StoryEngine;
import java.util.Scanner;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {

        StoryFactory factory =
                new StoryFactory();

        Story story =
                factory.createStory();

        StoryEngine engine =
                new StoryEngine();

        engine.startStory(story);

        MainWindow window =
                new MainWindow(engine);


        window.displayScene(
                engine.getCurrentScene().getTitle(),
                engine.getCurrentScene().getContent()
        );

    }





}






