import java.util.Scanner;

public class MVCPattern {
}
// Model class
class Model {
    private int data;  // Data to be displayed and manipulated by the application

    // Method to set the value of the data
    public void setData(int data) {
        this.data = data;
    }

    // Method to get the value of the data
    public int getData() {
        return data;
    }
}

// View class
class View {
    // Method to display the data from the model
    public void displayData(int data) {
        System.out.println("Data: " + data);
    }

    // Method to get user input
    public int getUserInput() {
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}

// Controller class
class Controller {
    private Model model;  // Reference to the model
    private View view;  // Reference to the view

    // Constructor to create a controller with a given model and view
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.displayData(model.getData());
    }

// Method to handle user input and update the model
}
