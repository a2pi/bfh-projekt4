package main;


import interfaces.Position;
import interfaces.Tree;

public class SwissTree {

    public static void main(String[] args){

        LinkedTree<String> Country = new LinkedTree<>();

        Position<String> Switzerland = Country.addRoot("Switzerland\n");

        Position<String> kantomZurich = Country.insertChild(Switzerland, "Kanton Zürich\n");
        Position<String> kantonBern = Country.insertChild(Switzerland, "Kanton Bern\n");
        Position<String> kantonLuzern = Country.insertChild(Switzerland, "Kanton Luzern\n");
        Position<String> kantonUri = Country.insertChild(Switzerland, "Kanton Uri\n");
        Position<String> kantonSchwyz = Country.insertChild(Switzerland, "Kanton Schwyz\n");
        Position<String> kantonObwalden = Country.insertChild(Switzerland, "Kanton Obwalden\n");
        Position<String> kantonNidwalden = Country.insertChild(Switzerland, "Kanton Nidwalden\n");
        Position<String> kantonGlarus = Country.insertChild(Switzerland, "Kanton Glarus\n");
        Position<String> kantonZug = Country.insertChild(Switzerland, "Kanton Zug\n");
        Position<String> kantonFribourg = Country.insertChild(Switzerland, "Kanton Fribourg\n");
        Position<String> kantonSolothurn = Country.insertChild(Switzerland, "Kanton Solothurn\n");
        Position<String> kantonBaselStadt = Country.insertChild(Switzerland, "Kanton Basel-Stadt\n");
        Position<String> kantonBaselLandschaft = Country.insertChild(Switzerland, "Kanton Basel-Landschaft\n");
        Position<String> kantonSchaffhausen = Country.insertChild(Switzerland, "Kanton Schaffhausen\n");
        Position<String> kantonAppenzellAusserrhoden = Country.insertChild(Switzerland, "Kanton Appenzell Ausserrhoden\n");
        Position<String> kantonAppenzellInnerrhoden = Country.insertChild(Switzerland, "Kanton Appenzell Innerrhoden\n");
        Position<String> kantonStGallen = Country.insertChild(Switzerland, "Kanton St. Gallen\n");
        Position<String> kantonGraubuenden = Country.insertChild(Switzerland, "Kanton Graubünden\n");
        Position<String> kantonAargau = Country.insertChild(Switzerland, "Kanton Aargau\n");
        Position<String> kantonThurgau = Country.insertChild(Switzerland, "Kanton Thurgau\n");
        Position<String> kantonTicino = Country.insertChild(Switzerland, "Kanton Ticino\n");
        Position<String> kantonvaud = Country.insertChild(Switzerland, "Kanton Vaud\n");
        Position<String> kantonValais = Country.insertChild(Switzerland, "Kanton valais\n");
        Position<String> kantonBNeuchatel = Country.insertChild(Switzerland, "Kanton Neuchâtel\n");
        Position<String> kantonGeneva = Country.insertChild(Switzerland, "Kanton Genf\n");
        Position<String> kantonJura = Country.insertChild(Switzerland, "Kanton Jura\n");


        Position<String> zurich = Country.insertChild(kantomZurich, "Zürich");
        Position<String> duebendorg = Country.insertChild(kantomZurich, "Dübendorf");
        Position<String> winterthur = Country.insertChild(kantomZurich, "Winterthur)");
        Position<String> buelach = Country.insertChild(kantomZurich, "Bülach)");
        Position<String> Kloten = Country.insertChild(kantomZurich, "Kloten)");

        Position<String> bern = Country.insertChild(kantonBern, "Bern");
        Position<String> biel = Country.insertChild(kantonBern, "Biel");


        System.out.println(Country.elements());
        System.out.println(Country.toString());
    }
}
