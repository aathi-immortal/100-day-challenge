package furnitureshop.company;

import furnitureshop.product.chair.ArchDecoChair;
import furnitureshop.product.chair.Chair;
import furnitureshop.product.coffetable.ArchDecoCoffeTable;
import furnitureshop.product.coffetable.CoffeTable;
import furnitureshop.product.sofa.ArchDecoSofa;
import furnitureshop.product.sofa.Sofa;

public class ArcDeco extends Company {

    @Override
    public Chair createChair() {
        return new ArchDecoChair();
    }

    @Override
    public CoffeTable createCoffeTable() {
        return new ArchDecoCoffeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ArchDecoSofa();
    }

}
