package creational.abstractfactory.factory;

import creational.abstractfactory.chair.Chair;
import creational.abstractfactory.chair.ModernChair;
import creational.abstractfactory.sofa.ModernSofa;
import creational.abstractfactory.sofa.Sofa;
import creational.abstractfactory.table.ModernTable;
import creational.abstractfactory.table.Table;

public class ModernFurniture implements IFurnitureFactory {

    @Override
    public Chair getChair() {
        return new ModernChair();
    }

    @Override
    public Sofa getSofa() {
        return new ModernSofa();
    }

    @Override
    public Table getTable() {
        return new ModernTable();
    }
}
