package poly.ex2;

public class Animal {
    public void sound() {
        System.out.println("동물 울음 소리");
    }

    public void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
