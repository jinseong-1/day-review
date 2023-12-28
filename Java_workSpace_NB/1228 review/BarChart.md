<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.chart.BarChart?>
<?import javafx.scene.chart.CategoryAxis?>
<?import javafx.scene.chart.NumberAxis?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.VBox?>


<VBox 
fx:controller="application.BarChartController"
alignment="CENTER" spacing="10.0"
xmlns:fx="http://javafx.com/fxml/1" 
xmlns="http://javafx.com/javafx/17">
   <children>
      <HBox prefHeight="100.0" prefWidth="200.0" alignment="CENTER">
         <children>
            <BarChart fx:id="barChart" minHeight="200.0">
              <xAxis>
                <CategoryAxis side="BOTTOM" />
              </xAxis>
              <yAxis>
                <NumberAxis side="LEFT" />
              </yAxis>
            </BarChart>
         </children>
      </HBox>
      <Button fx:id="btnClose" mnemonicParsing="false" text="닫기">
         <VBox.margin>
            <Insets bottom="10.0" left="10.0" right="10.0" top="10.0" />
         </VBox.margin>
      </Button>
   </children>
</VBox>
