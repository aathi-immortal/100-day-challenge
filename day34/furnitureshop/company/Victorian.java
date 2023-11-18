package furnitureshop.company;

import furnitureshop.product.chair.Chair;
import furnitureshop.product.chair.VictorianChair;
import furnitureshop.product.coffetable.CoffeTable;
import furnitureshop.product.coffetable.VictoriaCoffeTable;
import furnitureshop.product.sofa.Sofa;
import furnitureshop.product.sofa.VictorianSofa;

public class Victorian extends Company {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public CoffeTable createCoffeTable() {
        return new VictoriaCoffeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

}
