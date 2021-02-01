public class Main {
    public static void main(String[] args) {

        Abilities[] runners = {
                new Cat("Кот Васька", 200, 3),
                new Human("Аркадий", 500, 1),
                new Robot("Робот Чаппи", 300, 2)};

        Barrier[] barriers = {new Wall(1), new Track(500)};

        for (Barrier barrier : barriers) {
            for (Abilities runer : runners) {
                if (barrier instanceof Track) runer.run(barrier);
                if (barrier instanceof Wall) runer.jump(barrier);
            }
        }
    }
}
