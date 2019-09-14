package week2.structural.decorator;

public interface Pizza {
    //Here are the Decorators
    static Pizza withExtraCheese(Pizza pizza) {
        return new Pizza() {
            @Override
            public int getPriceOfPizza() {
                return pizza.getPriceOfPizza() + 200;
            }
        };
    }

    static Pizza withPepperoni(Pizza pizza) {
        return new Pizza() {
            @Override
            public int getPriceOfPizza() {
                return pizza.getPriceOfPizza() + 300;
            }
        };
    }

    static  Pizza witVeggies(Pizza pizza){
        return new Pizza() {
            @Override
            public int getPriceOfPizza() {
                return pizza.getPriceOfPizza() + 150;
            }
        };
    }

    int getPriceOfPizza();
}