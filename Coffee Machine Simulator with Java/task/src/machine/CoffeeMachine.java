package machine;

import java.util.Scanner;

class Coffee {
    private final int water;
    private final int milk;
    private final int beans;
    private final int cost;

    public Coffee(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }
}

class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private int coffeeCount;

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.coffeeCount = 0;
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void buy(Coffee coffee) {
        if (coffeeCount >= 10) {
            System.out.println("I need cleaning!");
            return;
        }

        if (calcIfEnough(coffee.getWater(), coffee.getMilk(), coffee.getBeans())) {
            water -= coffee.getWater();
            milk -= coffee.getMilk();
            beans -= coffee.getBeans();
            money += coffee.getCost();
            cups--;
            coffeeCount++;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public boolean checkCleaning() {
        return coffeeCount >= 10;
    }

    public void clean() {
        coffeeCount = 0;
        System.out.println("I have been cleaned!");
    }

    private boolean calcIfEnough(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        } else {
            return true;
        }
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine coffeeMachine = new Machine(400, 540, 120, 9, 550);
        Coffee espresso = new Coffee(250, 0, 16, 4);
        Coffee latte = new Coffee(350, 75, 20, 7);
        Coffee cappuccino = new Coffee(200, 100, 12, 6);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, clean, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    if (coffeeMachine.checkCleaning()) {
                        System.out.println("I need cleaning!");
                        break;
                    }
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice = scanner.next();
                    switch (choice) {
                        case "1":
                            coffeeMachine.buy(espresso);
                            break;
                        case "2":
                            coffeeMachine.buy(latte);
                            break;
                        case "3":
                            coffeeMachine.buy(cappuccino);
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int beans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int cups = scanner.nextInt();
                    coffeeMachine.fill(water, milk, beans, cups);
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.remaining();
                    break;
                case "clean":
                    coffeeMachine.clean();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid action!");
            }
        }
    }
}