package creational.abstractfactory;

import creational.abstractfactory.chair.Chair;
import creational.abstractfactory.factory.FactoryGenerator;
import creational.abstractfactory.factory.IFurnitureFactory;
import creational.abstractfactory.sofa.Sofa;
import creational.abstractfactory.table.Table;

public class Main {
    public static void main(String[] args) {
        //IFurnitureFactory factory = FactoryGenerator.getFactory("Modern");
        //IFurnitureFactory factory = FactoryGenerator.getFactory("Victorian");
        IFurnitureFactory factory = FactoryGenerator.getFactory("Office");
        Chair chair = factory.getChair();
        Sofa sofa = factory.getSofa();
        Table table = factory.getTable();

        chair.printChairInfo();
        sofa.printSofaInfo();
        table.printTableInfo();
    }
}
