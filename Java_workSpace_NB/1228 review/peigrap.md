<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.chart.PieChart?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.layout.VBox?>

<VBox 
alignment="CENTER" 
xmlns="http://javafx.com/javafx/17" 
xmlns:fx="http://javafx.com/fxml/1" 
fx:controller="application.PieChartCotroller">
   <children>
      <PieChart fx:id="pieChart" prefHeight="300.0" prefWidth="300.0" />
      <Button fx:id="btnClose" mnemonicParsing="false" text="닫기" />
   </children>
</VBox>
