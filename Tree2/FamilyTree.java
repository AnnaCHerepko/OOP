import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


public class FamilyTree implements Serializable{
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this( new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setID(humansID++);
            addToParents(human);
            addToChldren(human);
            return true;
        }
        return false;
    }

    public Human getById(long id){
        if (!checkId(id)){
            return null;
        }
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            parent.addParent(human);
        }
    }

    private boolean chrckId(long id){
        return id < humansId && id >= 0;
    }
    
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append('В дереве ');
        sb.append(humanList.size());
        sb.append(' объектов: \n');
        for (Human human: humanList){
            sb.append(human);
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

}