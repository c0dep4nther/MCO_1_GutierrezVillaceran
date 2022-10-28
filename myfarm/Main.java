package myfarm;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to MyFarm!");

    }
    //initializing player
    private FarmerDetails farmer;
    public  Main(){
        farmer=new FarmerDetails();
    }
    //Initializing seed types
    public void setupSeeds(){
        farmer.addSeeds("Turnip","Vegetable",1,1,2,0,1,1,1,5,6);
        farmer.addSeeds("Carrot","Vegetable",1.5f,1,2,0,1,1,2,10,9);
        farmer.addSeeds("Rose","Flower",1,1,2,0,1,2,1,5,5);
        farmer.addSeeds("Stargazer","Flower",2.5f,2,3,0,1,2,1,10,9);
    }
}
