import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

abstract class ClassPlayer {
   protected String className;
   protected long levelRequired;
   protected List<Skill> skills = new ArrayList<Skill>();

    public ClassPlayer(String className, long levelRequired) {
        this.className = className;
        this.levelRequired = levelRequired;
    }

    protected void addSkill(Skill newSkill) {
        this.skills.add(newSkill);
    }

    protected void showSkills(){
        for(Skill skill: this.skills)
        {
            System.out.println("Skill " + skill.skillName);
        }
    }

}

abstract class Skill {
    protected String skillName;
    protected int level;
    protected int cost;
    protected int damage;

    public Skill(String skillName, int cost, int damage)
    {
        this.skillName = skillName;
        this.cost = cost;
        this.damage = damage;
        this.level = 1;
    }

    protected void upgradeLevel(int levelAmount) {
        this.level += levelAmount;
    }
}

class ManaSkill extends Skill {
    public ManaSkill(String skillName, int cost, int damage)
    {
        super(skillName, cost, damage);
    }
}

class CombatSkill extends Skill {
    public CombatSkill(String skillName, int cost, int damage)
    {
        super(skillName, cost, damage);
    }
}

class HealingSkill extends Skill {
    public HealingSkill(String skillName, int cost, int damage)
    {
        super(skillName, cost, damage);
    }
}


class WizardClass extends ClassPlayer{
    public WizardClass(String className, long levelRequired) {
        super(className, levelRequired);
    }
}

class WarriorClass extends ClassPlayer{
    public WarriorClass(String className, long levelRequired) {
        super(className, levelRequired);
    }
}

class BarbarianClass extends ClassPlayer {
    public BarbarianClass(String className, long levelRequired) {
        super(className, levelRequired);
    }
}

public class NoFactory{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a classe? ");
        String classe = sc.nextLine();
        System.out.println("Qual o nível?");
        int nivel = sc.nextInt();

        ClassPlayer jogador = null; //= new ClassPlayer(classe, nivel);

        if(classe.equals("warrior")){
            jogador = new WarriorClass(classe, nivel);
        }else{
            if(classe.equals("wizard")){
                jogador = new WizardClass(classe, nivel);
            }else{
                if(classe.equals("barbarian")){
                    jogador = new BarbarianClass(classe, nivel);
                }else{
                    System.out.println("Classe inválida");
                }
            }
        }

        System.out.println("Escolha uma nova Skill");
        System.out.println("1 - Cura");
        System.out.println("2 - Mana");
        System.out.println("3 - Combate");

        int opc = sc.nextInt();
        Skill sk = null;
        if(opc < 1 && opc > 3)
            System.out.println("Valor inválido");
        else{
            if(opc == 1){
                sk = new HealingSkill("Cura",12,20);
            }else{
                if(opc == 2)
                    sk = new ManaSkill("Mana",5,10);
                else
                    sk = new CombatSkill("Combate",8,28);
            }
                
        }
        jogador.addSkill(sk);
        System.out.println(jogador.getClass());
        jogador.showSkills();

        sc.close();
    }
}