package homeTaskEight;

public class House {
    private int rooms;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) throws FirstException, SecondException {
        if(rooms==0){
           throw new FirstException("Не может быть ноль комнат");
        }
        else {
            this.rooms = rooms;
        }
    }
}
