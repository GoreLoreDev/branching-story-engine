package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

import model.Choice;
import model.SaveData;
import model.Scene;
import model.Story;
import service.SaveService;
import service.StoryEngine;

import java.awt.BorderLayout;

public class MainWindow extends JFrame {

    private StoryEngine engine;

    private JTextArea storyArea;
    private JPanel choicePanel;
    JPanel controlPanel =
            new JPanel();
    private JTextArea statusArea;

    private Scene currentScene;



    private Story story;

    private SaveService saveService = new SaveService();

    public MainWindow(
            Story story,
            StoryEngine engine
    ) {

        currentScene =
                engine.getCurrentScene();


        this.engine=engine;
        this.story=story;

        setTitle("AI Horror Story Studio");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());



        JPanel mainPanel =
                new JPanel(new BorderLayout());



        storyArea = new JTextArea();
        statusArea=new JTextArea();

        statusArea.setEditable(false);

        statusArea.setText("Fear Level: 0");

        storyArea.setText(
                "Welcome to Horror Story Studio"
        );

        choicePanel=new JPanel();



        JButton saveButton =
                new JButton("Save Game");


        saveButton.addActionListener(e -> {

            SaveData saveData =
                    new SaveData();

            saveData.setCurrentSceneId(
                    currentScene.getSceneId()
            );

            saveData.setFearLevel(
                    engine.getPlayerState()
                            .getFearLevel()
            );

            saveService.saveGame(
                    saveData
            );

        });

        JButton loadButton =
                new JButton("Load Game");



        loadButton.addActionListener(e -> {

            SaveData saveData =
                    saveService.loadGame();

            if (saveData == null) {

                return;
            }

            Scene loadedScene = null;

            for (Scene scene :
                    story.getScenes()) {
                if (scene.getSceneId().equals(
                        saveData.getCurrentSceneId()
                )) {

                    loadedScene = scene;

                    break;
                }

            }

            engine.setCurrentScene(
                    loadedScene
            );

            engine.setFearLevel(
                    saveData.getFearLevel()
            );

            currentScene = loadedScene;

            renderScene(currentScene);
        });

        choicePanel.setLayout(
                new GridLayout(0, 1) //unlimited rows, 1 col
        );
        controlPanel.add(saveButton);

        controlPanel.add(loadButton);

        add(choicePanel, BorderLayout.SOUTH);

        add(controlPanel, BorderLayout.NORTH);


        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);

        storyArea.setFont(
                new Font("Serif",
                        Font.PLAIN,
                        20)
        );



        JScrollPane scrollPane =
                new JScrollPane(storyArea);



        add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(scrollPane,
                BorderLayout.CENTER);

        mainPanel.add(statusArea,
                BorderLayout.NORTH);

        mainPanel.add(choicePanel,
                BorderLayout.SOUTH);



        displayChoices();






        setVisible(true);
    }

    public void displayScene(String title,
                             String content) {

        storyArea.setText(
                title + "\n\n" + content
        );
    }



    public void displayChoices(){
        choicePanel.removeAll();



        if (currentScene.getChoices().isEmpty()) {

            JButton endButton =
                    new JButton("Story Ended");

            endButton.setEnabled(false);

            choicePanel.add(endButton);

            choicePanel.revalidate();

            choicePanel.repaint();

            return;
        }

        for (Choice choice :
                currentScene.getChoices()) {

            JButton button =
                    new JButton(choice.getChoiceText());

            button.addActionListener(e -> {

                engine.chooseChoice(choice);

                currentScene =
                        engine.getCurrentScene();

                renderScene(currentScene);

            });

            choicePanel.add(button);

        }



        choicePanel.revalidate();

        choicePanel.repaint();
    }

    public void renderScene(Scene scene){
        displayScene(
                scene.getTitle(),
                scene.getContent()
        );
        updateStatus();
        displayChoices();

    }
    public void updateStatus() {
        statusArea.setText(
                "Fear Level: " +
                        engine.getPlayerState().getFearLevel()
        );
    }
}