package creational.abstractfactory.factory;

import creational.abstractfactory.chair.Chair;
import creational.abstractfactory.chair.VictorianChair;
import creational.abstractfactory.sofa.Sofa;
import creational.abstractfactory.sofa.VictorianSofa;
import creational.abstractfactory.table.Table;
import creational.abstractfactory.table.VictorianTable;

public class VictorianFurniture implements IFurnitureFactory {
    @Override
    public Chair getChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa getSofa() {
        return new VictorianSofa();
    }

    @Override
    public Table getTable() {
        return new VictorianTable();
    }
}
