package poly.ex2;

public class AnimalPolyMain4 {

    public static void main(String[] args) {
        Animal[] animalArr = {new Dog(), new Cat(), new Cow(), new Duck(), new Pig()};
        for (Animal animal : animalArr) {
            animal.soundAnimal(animal);
        }
    }
}
