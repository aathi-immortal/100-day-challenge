package furnitureshop;

import furnitureshop.company.ArcDeco;
import furnitureshop.company.Company;
import furnitureshop.company.Modern;
import furnitureshop.company.Victorian;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        Company company = new ArcDeco();
        Company company2 = new Victorian();
        Company company3 = new Modern();
        company.createChair().prepare();
        company2.createSofa().prepare();
        company.createSofa().prepare();

    }
}