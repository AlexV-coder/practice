package creational.abstractfactory.factory;

public class FactoryGenerator {

    public static IFurnitureFactory getFactory(String type) {
        switch (type) {
            case "Modern": return new ModernFurniture();
            case "Office": return new OfficeFurniture();
            case "Victorian": return new VictorianFurniture();
            default: return null;
        }
    }
}
