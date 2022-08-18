/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculadora.tareafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author kency
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Button limpiar;
    @FXML private Button estudiante;
    @FXML private Label txtOperacion;
    @FXML private Label txtResultado;

    @FXML 
    private void InfoEstudiante(ActionEvent event){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Informacion del Estuante");
    alert.setContentText("Cuenta: 20201004556");
    alert.setHeaderText("KENCY PAMELA OSEGUERA VALDEZ");
    alert.showAndWait();
    }
    
    private double num1 = 0;
    private double total = 0;
    private String operador = "";
    private boolean ch = true;
    
    @FXML
    private void btn_limpiar(ActionEvent event) {
        txtOperacion.setText("");
        txtResultado.setText("0");
    }
    
    public Double crea(double num1, double num2, String operador){
        
        switch(operador){
         
            case "+":
                return (num1 + num2);
            
            case "-":
                return (num1 - num2);
            
            case "*":
                return (num1 * num2);
            
            case "^":
                return (Math.pow(num1, num2));
                
            case "%":
                return ((num1*num2)/100); //Ejemplo 15% de 240 = 36
            
            case "/":
                if (num2 == 0)
                    return 0.0;
                return (num1 / num2);
            default:
               break;
        }
     return 0.0;       
    }
    
    public void Numero(String numero){
        txtResultado.setText(txtResultado.getText() + numero);
    }
    
    public void VistaOper(String numero){ 
        txtOperacion.setText(txtOperacion.getText() + numero );
    }
    
    public void Vista(String operador){
        txtOperacion.setText(txtOperacion.getText()+ " " + operador + " ");
        
    }	
    
    public void computerProcess(ActionEvent event){
        
        if (ch){
            txtResultado.setText("");
            txtOperacion.setText("");
            ch = false;
        }
        
        Button button = (Button)event.getSource();
        String value = button.getText();
        Numero(value);
        VistaOper(value);
    }
    
    public void operadorProcess(ActionEvent event){
         Button button = (Button)event.getSource();
        String value = button.getText();
        
        if (!value.equals("=")){
            
            if (!operador.isEmpty())
                return;
            operador = value;
            Vista(operador);
            num1 = Double.parseDouble(txtResultado.getText());
            txtResultado.setText("");
        }else{
            if (operador.isEmpty())
                return;
            double num2 = Double.parseDouble(txtResultado.getText());
            total = crea(num1,num2,operador);
            txtResultado.setText(String.valueOf(total));
            operador ="";
            ch = true;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
