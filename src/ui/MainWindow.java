package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;

import model.Choice;
import model.Scene;
import service.StoryEngine;

import java.awt.BorderLayout;

public class MainWindow extends JFrame {

    private StoryEngine engine;

    private JTextArea storyArea;
    private JPanel choicePanel;

    public MainWindow(StoryEngine engine) {

        this.engine=engine;

        setTitle("AI Horror Story Studio");

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());



        JPanel mainPanel =
                new JPanel(new BorderLayout());



        storyArea = new JTextArea();

        storyArea.setText(
                "Welcome to Horror Story Studio"
        );

        choicePanel=new JPanel();
        choicePanel.setLayout(
                new GridLayout(0, 1) //unlimited rows, 1 col
        );


        storyArea.setEditable(false);



        JScrollPane scrollPane =
                new JScrollPane(storyArea);



        add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(scrollPane,
                BorderLayout.CENTER);

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

        Scene currentScene =
                engine.getCurrentScene();

        for (Choice choice :
                currentScene.getChoices()) {

            JButton button =
                    new JButton(choice.getChoiceText());

            button.addActionListener(e -> {

                engine.chooseChoice(choice);

                Scene nextScene =
                        engine.getCurrentScene();

                displayScene(
                        nextScene.getTitle(),
                        nextScene.getContent()
                );

                displayChoices();

            });

            choicePanel.add(button);
        }



        choicePanel.revalidate();

        choicePanel.repaint();
    }
}