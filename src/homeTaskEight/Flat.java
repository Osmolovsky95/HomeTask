package homeTaskEight;

public class Flat extends House {
    @Override
    public void setRooms(int rooms) throws FirstException, SecondException {
        if (rooms>5){
            throw new SecondException("This is house");
        }
        super.setRooms(rooms);

    }
}
