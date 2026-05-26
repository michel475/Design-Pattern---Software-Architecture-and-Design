import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


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


class ClassSkillFactory {
    public ClassSkillFactory(){}
    static public Skill create(String skillGroup, String skillName, int cost, int points) {
        switch(skillGroup) {
            case "mana":
                return new ManaSkill(skillName, cost, points);
            case "combat":
                return new CombatSkill(skillName, cost, points);
            case "healing":
                return new HealingSkill(skillName, cost, points);
            default:
                throw new IllegalArgumentException("Grupo de skill não encontrado");
        }
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

class ClassPlayerFactory {
    public ClassPlayerFactory(){}
    static public ClassPlayer create(String className, long levelRequired) {
        switch(className) {
            case "wizard":
                return new WizardClass(className, levelRequired);
            case "warrior":
                return new WarriorClass(className, levelRequired);
            case "barbarian":
                return new BarbarianClass(className, levelRequired);
            default:
                throw new IllegalArgumentException("Classe não encontrada");
        }
    }
}

class MenuSkillResult {
    public String skillGroup;
    public String skillName;
    public int cost;
    public int damage;
    
    public MenuSkillResult(String skillGroup, String skillName, int cost, int damage) {
        this.skillGroup = skillGroup;
        this.skillName = skillName;
        this.cost = cost;
        this.damage = damage;
    }
}

class MenuClasseResult {
    public String classe;
    public int nivel;
    
    public MenuClasseResult(String classe, int nivel) {
        this.classe = classe;
        this.nivel = nivel;
    }
}


public class factoryExample {

    static MenuSkillResult menuSkill(){
        Scanner sc = new Scanner(System.in);
        String skillGroup;
        
        System.out.println("Escolha um tipo de Skill");
        System.out.println("mana");
        System.out.println("combat");
        System.out.println("healing");
        skillGroup = sc.nextLine();
            
        System.out.println("Qual o nome da skill?");
        String skillName = sc.nextLine();

        System.out.println("Qual o custo da skill?");
        int cost = sc.nextInt();

        System.out.println("Qual o dano da skill?");
        int damage = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        return new MenuSkillResult(skillGroup, skillName, cost, damage);
    }

    static MenuClasseResult menuClasse(){
        Scanner sc = new Scanner(System.in);
        String classe;
        
        System.out.println("Escolha uma Classe");
        System.out.println("wizard");
        System.out.println("warrior");
        System.out.println("barbarian");
        classe = sc.nextLine();
            
        System.out.println("Qual o nível?");
        int nivel = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        return new MenuClasseResult(classe, nivel);
    }
    public static void main(String args[]) {

        //Player 1
        System.out.println("Player 1"); 
        //instancia o player utilizando o factory
        MenuClasseResult resultPlayer1 = menuClasse();
        ClassPlayer obj1 = ClassPlayerFactory.create(resultPlayer1.classe, resultPlayer1.nivel);

        //instancia as skills utilizando o factory
        MenuSkillResult resultSkill1 = menuSkill();
        Skill newSkill = ClassSkillFactory.create(resultSkill1.skillGroup, resultSkill1.skillName, resultSkill1.cost, resultSkill1.damage);
        MenuSkillResult resultSkill2 = menuSkill();
        Skill newSkill2 = ClassSkillFactory.create(resultSkill2.skillGroup, resultSkill2.skillName, resultSkill2.cost, resultSkill2.damage);
        obj1.addSkill(newSkill);
        obj1.addSkill(newSkill2);

        System.out.println(obj1.getClass());
        obj1.showSkills();

        System.out.println("\nPlayer 2");
        MenuClasseResult resultPlayer2 = menuClasse();
        ClassPlayer obj2 = ClassPlayerFactory.create(resultPlayer2.classe, resultPlayer2.nivel);

        MenuSkillResult resultSkill3 = menuSkill();
        Skill newSkill3 = ClassSkillFactory.create(resultSkill3.skillGroup, resultSkill3.skillName, resultSkill3.cost, resultSkill3.damage);
        obj2.addSkill(newSkill3);
        
        System.out.println(obj2.getClass());
        obj2.showSkills();
        //inicialmente instancia-se o player e em seguida instancia as skills
        //instanciei duas skills também utilizando o factory
    }
}