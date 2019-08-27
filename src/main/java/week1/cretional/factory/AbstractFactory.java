package week1.cretional.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AbstractFactory {

    final static Map<FactoryType, Supplier<Factory>> map = new HashMap<>();

    static {
        // map.put(FactoryType.SHAPE, ShapeFactory::new);
        //TODO commented out on purpose
    }

    public Factory getFactory(FactoryType factoryType) {
        Supplier<Factory> factory = map.get(factoryType);
        if (factory != null) {
            return factory.get();
        }
        throw new IllegalArgumentException("No such factory " + factoryType.name());
    }
}