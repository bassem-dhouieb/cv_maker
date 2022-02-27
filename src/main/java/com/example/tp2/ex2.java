package com.example.tp2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex2 extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        Tooltip tooltip = new Tooltip("Choisire niveau expertise");




        Label titre = new Label("Curriculum vitae");
        titre.setFont(Font.font("System", FontWeight.BOLD,20));

//        TitledPane for Personnel information
        GridPane g1 = new GridPane();
        g1.setStyle("-fx-border-color: blue");

        Label nameL = new Label("Nom & prenom :");
        TextField nameT = new TextField();
        g1.add(nameL,0,0);
        g1.add(nameT,1,0,3,1);
        GridPane.setMargin(nameT,new Insets(5));

        Label emailL = new Label("Email :");
        TextField emailT = new TextField();
        g1.add(emailL,0,1);
        g1.add(emailT,1,1,3,1);
        GridPane.setMargin(emailT,new Insets(5));

        Label telL = new Label("Tel :");
        TextField telT = new TextField();
        g1.add(telL,0,2);
        g1.add(telT,1,2,3,1);
        GridPane.setMargin(telT,new Insets(5));

        Label dateL = new Label("Date de naissance");
        ComboBox<String> cBoxY = new ComboBox<>();
        cBoxY.getItems().addAll("1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021");
        cBoxY.getSelectionModel().select(70);
        ComboBox<String> cBoxD = new ComboBox<>();
        cBoxD.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
        cBoxD.getSelectionModel().select(0);
        ComboBox<String> cBoxM = new ComboBox<>();
        cBoxM.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
        cBoxM.getSelectionModel().select(0);
        g1.add(dateL,0,3);
        g1.add(cBoxD,1,3);
        g1.add(cBoxM,2,3);
        g1.add(cBoxY,3,3);
        GridPane.setMargin(cBoxY,new Insets(5));
        GridPane.setMargin(cBoxD,new Insets(5));
        GridPane.setMargin(cBoxM,new Insets(5));

        Label sexeL = new Label("Sexe :");
        RadioButton f = new RadioButton("femme");
        RadioButton h = new RadioButton("homme");
        ToggleGroup tg = new ToggleGroup();
        f.setToggleGroup(tg);
        h.setToggleGroup(tg);
        g1.add(sexeL,0,4);
        g1.add(f,1,4);
        g1.add(h,2,4);
        GridPane.setMargin(f,new Insets(5));
        GridPane.setMargin(h,new Insets(5));

        Label formation = new Label("Formation :");
        ComboBox<String> cBoxF = new ComboBox<>();
        cBoxF.getItems().addAll("ingenieur","prepa","licence");
        cBoxF.getSelectionModel().select(0);
        g1.add(formation,0,5);
        g1.add(cBoxF,1,5);

        Image bassem = new Image(new File("src/img.png").toURI().toString());
        ImageView img = new ImageView(bassem);
        img.setOnMouseClicked((MouseEvent e) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                System.out.println("File Was Selected");
                URL url = null;
                try {
                    url = file.toURI().toURL();
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                img.setImage(new Image(url.toExternalForm()));
                System.out.println(url.toString().substring(5));

                duplicate_file(url.toString().substring(5),"src/resume/assets/img/profile.jpg");


            }


        });
        img.setFitHeight(200);
        img.setFitWidth(200);
        g1.add(img,4,0,1,4);

        TitledPane t1 = new TitledPane();
        t1.setText("Information Personelles");
        t1.setContent(g1);


 //        TitledPane for competence technique
        GridPane g2 = new GridPane();
        g2.setStyle("-fx-border-color: blue");

        Label java = new Label("JAVA :");
        ComboBox<String> cBoxJava = new ComboBox<>();
        cBoxJava.getItems().addAll("Debutant","Confirme","Expert");
        cBoxJava.getSelectionModel().select(0);
        g2.add(java,0,0);
        g2.add(cBoxJava,1,0);
        GridPane.setMargin(cBoxJava,new Insets(5,5,15,5));
        cBoxJava.setTooltip(tooltip);

        Label python = new Label("PYTHON :");
        ComboBox<String> cBoxPython = new ComboBox<>();
        cBoxPython.getItems().addAll("Debutant","Confirme","Expert");
        cBoxPython.getSelectionModel().select(0);
        g2.add(python,0,1);
        g2.add(cBoxPython,1,1);
        GridPane.setMargin(cBoxPython,new Insets(5));
        cBoxPython.setTooltip(tooltip);

        Label machine = new Label("MACHINE LEARNING :");
        ComboBox<String> cBoxMachine = new ComboBox<>();
        cBoxMachine.getItems().addAll("Debutant","Confirme","Expert");
        cBoxMachine.getSelectionModel().select(0);
        g2.add(machine,0,2);
        g2.add(cBoxMachine,1,2);
        GridPane.setMargin(cBoxMachine,new Insets(5));
        cBoxMachine.setTooltip(tooltip);

        Label commentaire = new Label("Commentaire :");
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefColumnCount(18);
        textArea.setPrefRowCount(6);
        g2.add(commentaire,2,0);
        g2.add(textArea,2,1,1,2);

        TitledPane t2 = new TitledPane();
        t2.setText("Competences technique");
        t2.setContent(g2);



        CheckBox checkBox = new CheckBox("Enregistrer une version pdf de la candidature avant d'envoyer");

        Button envoyer = new Button("Envoyer");
        Button annuler = new Button("Annuler");

        HBox hBox = new HBox(3);
        hBox.getChildren().addAll(envoyer,annuler);
        hBox.setAlignment(Pos.CENTER);


        envoyer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {




                    if (checkBox.isSelected()){
                        System.out.println("ok");
                        duplicate_file("src/index.html","src/resume/index.html");

                        modifyFile("src/resume/index.html","88first name88",nameT.getText().split(" ")[0]);
                    modifyFile("src/resume/index.html","88last name88",nameT.getText().split(" ")[1]);
                    modifyFile("src/resume/index.html","88email88",emailT.getText());
                    modifyFile("src/resume/index.html","88tel88",telT.getText());
                    modifyFile("src/resume/index.html","88birth88",cBoxD.getValue()+"/"+cBoxM.getValue()+"/"+cBoxY.getValue());
                    modifyFile("src/resume/index.html","88field88",cBoxF.getValue());
                    modifyFile("src/resume/index.html","88java88",cBoxJava.getValue());
                    modifyFile("src/resume/index.html","88python88",cBoxPython.getValue());
                    modifyFile("src/resume/index.html","88machine88",cBoxMachine.getValue());
                    modifyFile("src/resume/index.html","88comment88",textArea.getText());
                        RadioButton selectedRadioButton = (RadioButton) tg.getSelectedToggle();
                        String toogleGroupValue = selectedRadioButton.getText();
                        modifyFile("src/resume/index.html","88gander88",toogleGroupValue);


                    }

            }
        });

        root.getChildren().addAll(titre,t1,t2,checkBox,hBox);
        stage.setTitle("Candidature PFE");
        stage.setScene(new Scene(root,650,600));
        stage.setResizable(false);
        stage.show();
    }

    private void duplicate_file(String sourceUrl,String destUrl) {
        var source = new File(sourceUrl);
        var dest = new File(destUrl);

        try (var fis = new FileInputStream(source);
             var fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {

                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
