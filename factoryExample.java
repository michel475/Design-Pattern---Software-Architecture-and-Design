abstract class ClassPlayer {
   protected String className;
   protected long levelRequired;

    public ClassPlayer(String className, long levelRequired) {
        this.className = className;
        this.levelRequired = levelRequired;
    }

}


class WizardClass extends ClassPlayer{
    public WizardClass(String className, long levelRequired) {
        super(className, levelRequired);
    }

    private void setLevelRequired(long levelRequired) {
        this.levelRequired = levelRequired;
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
        ClassPlayer obj = new ClassPlayerFactory().create("warrior", 15);
        System.out.println(obj.getClass());
    }
}
