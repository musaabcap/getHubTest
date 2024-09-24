import java.util.Random;
public class warrior extends Caracter {

    String specialAbility;
    int useSpecialAbility = getOff()*2;
    int specialAbilitys = 5;

    public warrior(String cName, String nName, int lvl) {
        //Med Super hämtar du variablerna från Caracter-klassen.
        super(cName,nName, lvl);
        this.specialAbility = "specialability";
    }
    //Här "overridas" infon i displayC-metoden med ny info.
    @Override
    public void displayC(){
        //Här läggs ytterliggare info till displayC-metoden med hjälp av super.
        super.displayC();
        System.out.println("Special ability: "+ specialAbility);
        System.out.println("You can use up to: "+specialAbilitys+" "+specialAbility);
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
            int totalDamage = getOff()+useSpecialAbility;
            System.out.println(getName()+" attacks with "+getOff()+" offense"+" and specialability "+ useSpecialAbility);
            return totalDamage;
        }
        else return basicAttack();
    }
    @Override
    public void heal(){
        health +=10;
        System.out.println(getName()+" has been heald. New health "+health);
    }
}

