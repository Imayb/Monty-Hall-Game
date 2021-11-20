package montyhall2;


import java.util.Random;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MontyHall2 extends Application
{
	
  private RadioButton door1;  
  private RadioButton door2;  
  private RadioButton door3;
  private RadioButton yes;
  private RadioButton no;
  private Button e;
  private Label hostLabel; 
  private Label resultLabel;
  private ImageView doorImage1;
  private ImageView doorImage2;
  private ImageView doorImage3;
  private Image goat;
  private Image car;
  private int carDoor;
  
    public static void main(String[] args)
	{
		launch(args);
	}
   @Override     
	public void start(Stage primaryStage)
	{
         Random rand = new Random();
         carDoor = rand.nextInt(3) +1;
            //Label control
            Label openingLabel = new Label("Welcome to the Monty Hall game, 'Let's Make a Deal'. "
                    + "Behind one door is a car that you could win! Behind the others are goats....choose wisely.");
            // New line so text does not run off
            openingLabel.setWrapText(true);
            //Label control to hold a question
            Label newLabel = new Label("Which door do you pick?");
            
                //RadioButton controls
		door1 = new RadioButton("Door 1");
                door2 = new RadioButton("Door 2");
                door3 = new RadioButton("Door 3");
                //Radio buttons added to toggle group
                ToggleGroup radioGroup = new ToggleGroup();
                
                door1.setToggleGroup(radioGroup);
                door2.setToggleGroup(radioGroup);
                door3.setToggleGroup(radioGroup);
                
        yes = new RadioButton();
        no = new RadioButton();
        //Yes/no radio buttons added to toggle group        
       ToggleGroup newRadioGroup = new ToggleGroup();
       
       yes.setToggleGroup(newRadioGroup);
       no.setToggleGroup(newRadioGroup);
                
        //Button control to confirm choice       
        e = new Button("Confirm");
        //Event handler registered
        e.setOnAction(new Handler());
       // e = new Button("Comfirm 2");
       // e.setOnAction(new Handler);
        //Label controls to be set later
        hostLabel = new Label();
        resultLabel = new Label();
       
       //Image components
       Image imageDoor1 = new Image("file:Door.jpg");
       Image imageDoor2 = new Image("file:Door.jpg");
       Image imageDoor3 = new Image("file:Door.jpg");
       //New image objects to change to later
       goat = new Image("file:goat.jpg");
       car = new Image("file:car.jpg");
       
       //Image view components
       doorImage1 = new ImageView(imageDoor1);
       doorImage2 = new ImageView(imageDoor2);
       doorImage3 = new ImageView(imageDoor3);
       
       //resize images
       doorImage1.setPreserveRatio(true);
       doorImage1.setFitHeight(150);
       doorImage1.setFitWidth(150);
       doorImage2.setPreserveRatio(true);
       doorImage2.setFitHeight(150);
       doorImage2.setFitWidth(150);
       doorImage3.setPreserveRatio(true);
       doorImage3.setFitHeight(150);
       doorImage3.setFitWidth(150);
       
       //HBox container to hold the images
       HBox image = new HBox(40, doorImage1, doorImage2, doorImage3);
       //Set center to be alighned better with the buttons
       image.setAlignment(Pos.CENTER);

        //HBox container to hold the question label that goes with the door buttons
	HBox firstHbox = new HBox (70, newLabel, door1, door2, door3);
        //HBox container for yes/no buttons
        HBox yesNoButtons = new HBox(40, yes, no);
        yesNoButtons.setAlignment(Pos.CENTER);
        
        //VBox to hold everything together to be put into the scene
        VBox everything = new VBox(80, openingLabel, image, firstHbox, hostLabel,yesNoButtons,e, resultLabel);
        //Set everything to be center stage
        everything.setAlignment(Pos.CENTER);
        
        everything.setPadding(new Insets(15));
        //Scene object, everything as root node
        Scene scene = new Scene(everything, 900, 900);
        //Apply CSS to the scene
        scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
       //Stage title
        primaryStage.setTitle("Let's Make a Deal");
        //Scene added to the stage
        primaryStage.setScene(scene);
        // Shows the window
        primaryStage.show();
        }
       class Handler implements EventHandler <ActionEvent>
       { 
         @Override       
        public void handle(ActionEvent e)
       {
          
         
         //If -else decision structure
if(carDoor == 1 && door1.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 2. Would you like to switch to door 3?");
             doorImage2.setImage(goat);
            
             yes.setText("Yes");
             no.setText("No");
           
             
              if(yes.isSelected())
              {
                  door3.setSelected(true);
                  if(carDoor == 3 && door3.isSelected())
                  {
                  result = "You Win!";
                  doorImage3.setImage(car);
              }
              else {
                  result = "You Lose.";
                 
              
              }
             resultLabel.setText(result);
              }
   
                   
       else if (no.isSelected())
             
        {
            door1.setSelected(true);
          
             if(carDoor == 1 && door1.isSelected())
             {
                 result = "You win!";
                 doorImage1.setImage(car);
             }
             else 
             {
                 result = "You lose.";
                 
               
             }
       
           resultLabel.setText(result);
        
        }
         } 
      
else if(carDoor == 2 && door1.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 3. Would you like to switch to door 2?");
             doorImage3.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door2.setSelected(true);
                  if(carDoor == 2 && door2.isSelected())
                  {
                  result = "You Win!";
                  doorImage2.setImage(car);
                   }
              
              else {
                  result = "You Lose.";
                  
                  }
              resultLabel.setText(result);
              }
       
                   
        else if (no.isSelected())
             
        {
            door1.setSelected(true);
            
             if(carDoor == 1 && door1.isSelected())
             {
                 result = "You win!";
                 doorImage1.setImage(car);
             }
             else 
             {
                 result = "You lose.";
             
     
             }
           resultLabel.setText(result);
        
        }
         } 
else if(carDoor == 3 && door1.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 2. Would you like to switch to door 3?");
             doorImage2.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door3.setSelected(true);
                  if(carDoor == 3 && door3.isSelected())
                  {
                  result = "You Win!";
                  doorImage3.setImage(car);
              }
              else {
                  result = "You Lose.";
           
                  }
             resultLabel.setText(result);
              }


         
             
         else  if (no.isSelected())
             
        {
            door1.setSelected(true);
         
             if(carDoor == 1 && door1.isSelected())
             {
                 result ="You win!";
                 doorImage1.setImage(car);
             }
             else 
             {
                 result = "You lose.";
               
                
             }

           resultLabel.setText(result);
        
        }
         }
else if(carDoor == 1 && door2.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 3. Would you like to switch to door 1?");
             doorImage3.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door1.setSelected(true);
                  if(carDoor == 1 && door1.isSelected())
                  {
                  result = "You Win!";
                  doorImage1.setImage(car);
              }
              else {
                  result = "You Lose.";
              
                  }    
              resultLabel.setText(result);
              }


         
             
        else if (no.isSelected())
             
        {
            door2.setSelected(true);
             if(carDoor == 2 && door2.isSelected())
             {
                 result = "You win!";
                 doorImage2.setImage(car);
             }
             else 
             {
                 result = "You lose.";
              
             }

    
           resultLabel.setText(result);
        
        }
         }  
else if(carDoor == 2 && door2.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 3. Would you like to switch to door 1?");
             doorImage3.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door1.setSelected(true);
                  if(carDoor == 1 && door1.isSelected())
                  {
                  result = "You Win!";
                  doorImage1.setImage(car);
              }
              else {
                  result = "You Lose.";
              
                  }
              resultLabel.setText(result);
              }
     
             
        else  if (no.isSelected())
             
        {
            door2.setSelected(true);
            
             if(carDoor == 2 && door2.isSelected())
             {
                 result = "You win!";
                 doorImage2.setImage(car);
             }
             else 
             {
                 result = "You lose.";
             
             }

           resultLabel.setText(result);
        
        }
         } 
else if(carDoor == 3 && door2.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 1. Would you like to switch to door 3?");
             doorImage1.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door3.setSelected(true);
                  if(carDoor == 3 && door3.isSelected())
                  {
                  result = "You Win!";
                  doorImage3.setImage(car);
              }
              else {
                  result = "You Lose.";
                 
                  }
              resultLabel.setText(result);
              }
 
             
      else if (no.isSelected())
             
        {
            door2.setSelected(true);
          
             if(carDoor == 2 && door2.isSelected())
             {
                 result = "You win!";
                 doorImage2.setImage(car);
             }
             else 
             {
                 result = "You lose.";
             
             }

           resultLabel.setText(result);
        
        }
      }
else if(carDoor == 1 && door3.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 2. Would you like to switch to door 1?");
             doorImage2.setImage(goat);
             
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door1.setSelected(true);
                  if(carDoor == 1 && door1.isSelected())
                  {
                  result = "You Win!";
                  doorImage1.setImage(car);
              }
              else {
                  result = "You Lose.";
              
                  }
              resultLabel.setText(result);
              }

           
       else if (no.isSelected())
             
        {
            door3.setSelected(true);
          
             if(carDoor == 3 && door3.isSelected())
             {
                 result = "You win!";
                 doorImage3.setImage(car);
             }
             else 
             {
                 result = "You lose.";
                 
             }

   
           resultLabel.setText(result);
        
        }
         }
else if(carDoor == 2 && door3.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 1. Would you like to switch to door 2?");
             doorImage1.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door2.setSelected(true);
                  if(carDoor == 2 && door2.isSelected())
                  {
                  result = "You Win!";
                  doorImage2.setImage(car);
              }
              else {
                  result = "You Lose.";
                  
                  }
              resultLabel.setText(result);
              }
     
             
       else if (no.isSelected())
             
        {
            door3.setSelected(true);
            
             if(carDoor == 3 && door3.isSelected())
             {
                 result = "You win!";
                 doorImage3.setImage(car);
             }
             else 
             {
                 result = "You lose.";
                 
             }

   
           resultLabel.setText(result);
        
        }
     }
      
else  if(carDoor == 3 && door3.isSelected())
         {
             String result;
             hostLabel.setText("Host opens door 1. Would you like to switch to door 2?");
             doorImage1.setImage(goat);
             
             yes.setText("Yes");
             no.setText("No");
             
              if(yes.isSelected())
              {
                  door2.setSelected(true);
                  if(carDoor == 2 && door2.isSelected())
                  {
                  result = "You Win!";
                  doorImage2.setImage(car);
              }
              else {
                  result = "You Lose.";
                 
                  }
              resultLabel.setText(result);
              }

         
             
      else if (no.isSelected())
             
        {
            door3.setSelected(true);
         
             if(carDoor == 3 && door3.isSelected())
             {
                 result = "You win!";
                 doorImage3.setImage(car);
             }
             else 
             {
                 result = "You lose.";
              
             }
   
           resultLabel.setText(result);
        }     
          }
        }
      } 
  }
