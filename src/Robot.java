public class Robot implements Abilities {
    private String name;
    private int canRun;
    private int canJump;
    private boolean participate = true;

    public Robot(String name, int canRun, int canJump) {
        this.name = name;
        this.canRun = canRun;
        this.canJump = canJump;
    }

    @Override
    public void run(Barrier track) {
        if (participate) {
            if (track.getBarrierSize() < this.canRun) {
                System.out.println(this.name + " успешно пробежал");
            } else {
                System.out.println(this.name + " не смог пробежать");
                this.participate = false;
            }
        }
    }

    @Override
    public void jump(Barrier wall) {
        if (participate) {
            if (wall.getBarrierSize() < this.canJump) {
                System.out.println(this.name + " успешно перепрыгнул");
            } else {
                System.out.println(this.name + " не смог перепрыгнуть");
                this.participate = false;
            }
        }
    }
}

