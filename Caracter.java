import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
public abstract class Caracter {

    private String cName;
    private String nName;
    private int lvl = 1;
    int health = 100;
    private int off = 10;
    private int def = 5;

    //Skapar construkur med parametrar
    public Caracter(String cName, String nName, int lvl){
        this.cName = cName;
        this.nName = nName;
        this.lvl = lvl;
    }
    public void displayC() {
        System.out.println("CHARACTER NAME: " + cName);
        System.out.println("Nickname: " + nName);
        System.out.println("Level: " + lvl);
        System.out.println("Health: " + health);
        System.out.println("Offense: " + off);
        System.out.println("Defense: " + def);
    }
    public abstract void heal();
    public abstract int basicAttack();
    public abstract int specialAttack();

    public boolean takeDamage(int damage) {
        health -= damage;
        System.out.println(cName + " took " + damage + " damage. Remaining health: " + health);
        // Check if the character is dead
        if (health <= 0) {
            System.out.println(cName + " has died!");
            return true;  // Character has died
        }
        // Character is still alive
        return false;
    }
    public String getName() {return cName;}
    void setName(String name){
        this.cName = name;
    }
    public int getHealth(){
        return health;
    }
    public int getLvl(){
        return lvl;
    }
    public int getOff(){
        return off;
    }



    /*public void takeDamage(int off){
        this.health = (this.health + def) - off;
        attack();
        System.out.println("you have "+health+" hp left");
    }
    public void attack(int attack){
        //this.off = off * lvl;
        target.takeDamage(off);
    }*/

}
