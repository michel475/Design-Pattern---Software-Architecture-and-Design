import java.util.List;
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
                return null;
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
                return null;
        }
    }
}


public class factoryExample {
    public static void main(String args[]) {
        ClassPlayer obj = new ClassPlayerFactory().create("wizard", 15);
        System.out.println(obj.getClass());
        Skill newSkill = new ClassSkillFactory().create("mana", "Fire Breath", 21, 29);
        Skill newSkill2 = new ClassSkillFactory().create("healing", "Bless of Athena", 13, 49);
        obj.addSkill(newSkill);
        obj.addSkill(newSkill2);
        obj.showSkills();
    }
}