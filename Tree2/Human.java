import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Gender;

public abstract class Human {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } 
        else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    public void setMother(Human mother){
        this.mother = mother;
    }

    public void setFather(Human father){
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge() {
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public LocalDate getBirthDAte(){
        return birthDate;
    }

    public LocalDate getDeathDAte(){
        return deathDate;
    }

    public List<Human> getChildren(){
        return children;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate){
        this.deathDate = deathDate;
    }

    public Gender getGender(){
        return gender;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append('id: ');
        sb.append(id);
        sb.append(', имя: ');
        sb.append(name);
        sb.append(', пол: ');
        sb.append(getGender());
        sb.append(', возраст: ');
        sb.append(getAge());
        sb.append(', ');
        sb.append(getMotherInfo());
        sb.append(', ');
        sb.append(getFatherInfo());
        sb.append(', ');
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = 'мать: ';
        if (mother != null){
            res += mother.getName();
        }
        else {
            res += 'неизвестна';
        }
    return res;
    }

    public String getFatherInfo(){
        String res = 'отец: ';
        if (father != null){
            res += father.getName();
        }
        else {
            res += 'неизвестен';
        }
    return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append('дети: ');
        if (children.size() != 0){
            for (int i = 1; i < children.size(); i++){
                res.append(', ');
                res.append(children,get(i).getName());
            }
        }
        else {
            res.append('отсутствуют');
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}