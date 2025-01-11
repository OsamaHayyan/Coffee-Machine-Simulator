package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        System.out.println();
        switch (action) {
            case "remaining":
                remaining();
                main(args);
                break;
            case "buy":
                buy();
                main(args);
                break;
            case "fill":
                fill();
                main(args);
                break;
            case "take":
                take();
                main(args);
                break;
            case "exit":
                break;
        }
    }

    static public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    static public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        var choice = scanner.next();
        int waterEspresso = 250;
        int beansEspresso = 16;
        int waterLatte = 350;
        int milkLatte = 75;
        int beansLatte = 20;
        int waterCappuccino = 200;
        int milkCappuccino = 100;
        int beansCappuccino = 12;
        switch (choice) {
            case "1":
                if (calcIfEnough(waterEspresso, 0, beansEspresso, 1)) {
                    water -= waterEspresso;
                    beans -= beansEspresso;
                    money += 4;
                    cups--;
                }
                break;
            case "2":
                if (calcIfEnough(waterLatte, milkLatte, beansLatte, 1)) {
                    water -= waterLatte;
                    milk -= milkLatte;
                    beans -= beansLatte;
                    money += 7;
                    cups--;
                }
                break;
            case "3":
                if (calcIfEnough(waterCappuccino, milkCappuccino, beansCappuccino, 1)) {
                    water -= waterCappuccino;
                    milk -= milkCappuccino;
                    beans -= beansCappuccino;
                    money += 6;
                    cups--;
                }
                break;
            case "back":
                break;
        }
        System.out.println();
    }

    static public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
        System.out.println();
    }

    static public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    static public boolean calcIfEnough(int waterNeeded, int milkNeeded, int beansNeeded, int cupsNeeded) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups < cupsNeeded) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }
}