import java.util.Random;
public class orch extends Caracter{

    String rage;
    int useRages = getLvl()*2;
    int rages = 5;

    public orch(String cName,String nName, int lvl) {
        super(cName, nName, lvl);
        this.rage = "rage";
    }
    @Override
    public void displayC(){
        super.displayC();
        System.out.println("Special ability: "+rage);
        System.out.println("You can use up to: "+rages+" "+rage );
    }
    @Override
    public int basicAttack(){
        int totalDamage = getOff();
        return totalDamage;
    }
    @Override
    public int specialAttack(){
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if(chance>=30){
            int totaldamage= getOff()+useRages;
            System.out.println(getName()+" attacks with "+getOff()+" offense"+" and specialability "+ useRages);
            return totaldamage;
        }
        else return basicAttack();
    }
    @Override
    public void heal(){
        health +=10;
        System.out.println(getName()+" has been heald. New health "+health);
    }
}
