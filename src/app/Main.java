package app;

import model.Choice;
import model.Scene;
import model.Story;
import model.ValidationReport;
import service.JsonLoader;
import service.StoryFactory;
import service.StoryValidator;


import java.util.ArrayList;
import java.util.List;
import service.StoryEngine;
import java.util.Scanner;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {
        JsonLoader loader =
                new JsonLoader();

        loader.loadStory();

//        StoryFactory factory =
//                new StoryFactory();
//
//        Story story =
//                factory.createStory();



        Story story =
                loader.loadStory();

        StoryValidator validator =
                new StoryValidator();

        ValidationReport report =
                validator.validateStory(
                        story
                );
        System.out.println(report);

        StoryEngine engine =
                new StoryEngine();

        engine.startStory(story);

        MainWindow window =
                new MainWindow(story, engine);


        window.renderScene(
                engine.getCurrentScene()
        );


    }





}






