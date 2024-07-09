/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class GeometricObject {
     abstract double calculateArea();
     abstract double calculatePerimeter();
    
}
class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
class Circle extends GeometricObject {
    private double radius;
    public Circle(double radius){
        this.radius = radius;
}
     public double calculateArea() {
        return radius * radius * Math.PI;
    }

    public double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }
}
class Square extends Rectangle {
      public Square(double side) {
        super(side, side);
    }
}
class GeometricCalculator extends JFrame{
   private JComboBox<String> shapeComboBox;
    private JTextField widthField;
    private JTextField heightField;
    private JButton calculateButton;
    private JLabel resultLabel;
    
    public GeometricCalculator() {
        setTitle("Geometric Calculator");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocation(400, 200);
        String[] shapes = {"Rectangle", "Circle", "Square"};
        shapeComboBox = new JComboBox<>(shapes);
        widthField = new JTextField();
        heightField = new JTextField();
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Result:");
//        shapeComboBox.setBounds(350, 10, 120, 30);
     
      setLayout(new GridLayout(4, 2, 20, 20));
     

        add(new JLabel("Select Shape:"));
        add(shapeComboBox);
        add(new JLabel("Width/Radius:"));
        add(widthField);
        add(new JLabel("Height (for Rectangle):"));
        add(heightField);
        add(calculateButton);
        add(resultLabel);
          calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplay();
            }
        });

}
      private void calculateAndDisplay() {
         String selectedShape = (String) shapeComboBox.getSelectedItem();
        double width = Double.parseDouble(widthField.getText());
        double height = Double.parseDouble(heightField.getText());

        GeometricObject geometricObject = null ;
        switch (selectedShape) {
            case "Rectangle":
                geometricObject = new Rectangle(width, height);
                break;
            case "Circle":
                geometricObject = new Circle(width); // Assuming width is the radius for Circle
                break;
            case "Square":
                geometricObject = new Square(width);
                break;
            default:
                System.out.println("Invalid shape selected");
        }

        double area = geometricObject.calculateArea();
        double perimeter = geometricObject.calculatePerimeter();

        resultLabel.setText("Area: " + area + ", Perimeter: " + perimeter);
    }
      
      }
