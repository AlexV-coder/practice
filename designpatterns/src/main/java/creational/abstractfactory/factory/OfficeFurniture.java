package creational.abstractfactory.factory;

import creational.abstractfactory.chair.Chair;
import creational.abstractfactory.chair.OfficeChair;
import creational.abstractfactory.sofa.OfficeSofa;
import creational.abstractfactory.sofa.Sofa;
import creational.abstractfactory.table.OfficeTable;
import creational.abstractfactory.table.Table;

public class OfficeFurniture implements IFurnitureFactory {
    @Override
    public Chair getChair() {
        return new OfficeChair();
    }

    @Override
    public Sofa getSofa() {
        return new OfficeSofa();
    }

    @Override
    public Table getTable() {
        return new OfficeTable();
    }
}
