package services;

import io.ReadAndWrite;
import models.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanService {
    private List<Human> humans = new ArrayList<>();

    public HumanService(){
        humans = ReadAndWrite.readHuman();
    }

    public void save(Human human) {
        humans.add(human);
        ReadAndWrite.writeHuman(humans);
    }

    public List<Human> findAll() {
        return humans;
    }

    public void delete(int index) {
        humans.remove(index);
    }

    public void edit(int index, Human human) {
        humans.set(index, human);
        ReadAndWrite.writeHuman(humans);
    }

    public int findIndexByName(String name){
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}

