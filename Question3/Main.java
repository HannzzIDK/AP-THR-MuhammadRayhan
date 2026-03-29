class Food {
    protected String name;
    protected int price;

    Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    protected int calcPrice() {
        int priceAfterTax = price + 5000;
        return priceAfterTax;
    }

    protected String getInfo() {
        return name + " " + calcPrice();
    }
}

class RegularMenu extends Food {
    RegularMenu(String name, int price) {
        super(name, price);
    }

    @Override
    protected int calcPrice() {
        return super.calcPrice() + 10000;
    }
}

class SpecialMenu extends Food {
    SpecialMenu(String name, int price) {
        super(name, price);
    }

    @Override
    protected int calcPrice() {
        return super.calcPrice() + 20000;
    }
}

public class Main {
    public static void main(String[] args) {
        Food[] foods = new Food[3];
        foods[0] = new Food("Beef Rendang", 15000);
        foods[1] = new RegularMenu("Chicken Ramen", 20000);
        foods[2] = new SpecialMenu("Fiery Fried Rice", 80000);

        for (int i = 0; i < foods.length; i++) {
            System.out.println("Name: " + foods[i].name);
            System.out.println("Price: " + foods[i].calcPrice());
            System.out.println();
        }
    }
}