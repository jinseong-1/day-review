<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.TableView?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane 
prefHeight="200.0" prefWidth="300.0" 
xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" 
fx:controller="application.practiceAController">
   <children>
      <TableView fx:id="vTable" fixedCellSize="0.0" layoutY="-7.0" prefHeight="200.0" prefWidth="400.0" />
      <Button fx:id="btnAdd" layoutX="125.0" layoutY="204.0" mnemonicParsing="false" text="추가" />
      <Button fx:id="styGrap" layoutX="181.0" layoutY="204.0" mnemonicParsing="false" text="학생별 막대그래프" />
   </children>
</AnchorPane>
