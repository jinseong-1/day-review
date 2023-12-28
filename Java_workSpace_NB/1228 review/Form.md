<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane 
prefHeight="250.0" prefWidth="200.0" 
xmlns="http://javafx.com/javafx/17" 
xmlns:fx="http://javafx.com/fxml/1" 
fx:controller="application.FormController">
   <children>
      <Label layoutX="14.0" layoutY="25.0" text="이름" />
      <Label layoutX="14.0" layoutY="59.0" text="국어" />
      <Label layoutX="14.0" layoutY="92.0" text="수학" />
      <Label layoutX="14.0" layoutY="121.0" text="영어" />
      <Button fx:id="btnSave" layoutX="43.0" layoutY="167.0" mnemonicParsing="false" text="저장" />
      <Button fx:id="btnCancel" layoutX="123.0" layoutY="167.0" mnemonicParsing="false" text="취소" />
      <TextField fx:id="txtName" layoutX="59.0" layoutY="21.0" prefWidth="150.0" />
      <TextField fx:id="txtKor" layoutX="59.0" layoutY="55.0" prefWidth="150.0" />
      <TextField fx:id="txtMath" layoutX="59.0" layoutY="88.0" prefWidth="150.0" />
      <TextField fx:id="txtEng" layoutX="59.0" layoutY="117.0" prefWidth="150.0" />
   </children>
</AnchorPane>
