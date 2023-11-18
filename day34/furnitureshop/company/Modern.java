package furnitureshop.company;

import furnitureshop.product.chair.Chair;
import furnitureshop.product.chair.ModernChair;
import furnitureshop.product.coffetable.CoffeTable;
import furnitureshop.product.coffetable.ModernCoffeTable;
import furnitureshop.product.sofa.ModernSofa;
import furnitureshop.product.sofa.Sofa;

public class Modern extends Company {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public CoffeTable createCoffeTable() {
        return new ModernCoffeTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

}
