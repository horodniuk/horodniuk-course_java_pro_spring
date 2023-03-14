package com.hl;

import com.hl.config.ProjectConfig;
import com.hl.model.Product;
import com.hl.services.Cart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    Cart cart = context.getBean(Cart.class);

    public void run() {
        displayMenu();
        consoleMode();
    }

    private void displayMenu() {
        System.out.println("1 - Add product \n" +
                           "2 - Remove product\n" +
                           "3 - Show cart\n" +
                           "0 - FINISH PROGRAM\n");
    }

    private void consoleMode() {
        int typed = -1;
        while (true) {
            System.out.println("\n Select an option number from menu:");
            try {
                typed = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }
            if (typed == 0) {
                System.out.println("program completed");
                return;
            } else {
                readUserInput(typed);
            }
        }
    }

    private void readUserInput(int typed) {
        switch (typed) {
            case 1:
                cart.addProductToCartById(readProductId());
                break;
            case 2:
                cart.removeProductFromCartById(readProductId());
                break;
            case 3:
                Map<Product, Integer> products = cart.getProductsInCart();
                System.out.println(products);
                break;
            default:
                System.out.println("Incorrect date. Try again");
        }
    }

    private Long readProductId() {
        System.out.println("Enter product's id");
        return scanner.nextLong();
    }
}
