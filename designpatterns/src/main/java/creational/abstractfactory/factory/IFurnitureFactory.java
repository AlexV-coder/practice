package creational.abstractfactory.factory;

import creational.abstractfactory.chair.Chair;
import creational.abstractfactory.sofa.Sofa;
import creational.abstractfactory.table.Table;

public interface IFurnitureFactory {
    public Chair getChair();
    public Sofa getSofa();
    public Table getTable();
}
