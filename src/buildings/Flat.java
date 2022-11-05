package buildings;

public class Flat {

    private int square;
    private int rooms;

    private static final int BASE_SQUARE = 50;
    private static final int BASE_ROOMS = 2;

    /***
     * Конструктор по умолчанию создает квартиру из 2 комнат площадью 50 кв.м.
     */
    public Flat(){
        this.square = BASE_SQUARE;
        this.rooms = BASE_ROOMS;
    }

    /***
     *Конструктор может принимать площадь квартиры (создается квартира с 2 комнатами).
     * @param square
     */
    public Flat(int square){
        this.square = square;
        this.rooms = BASE_ROOMS;
    }

    /***
     * Конструктор может принимать площадь квартиры и количество комнат.
     * @param square
     * @param rooms
     */
    public Flat(int square, int rooms){
        this.square = square;
        this.rooms = rooms;
    }

    /***
     * Создайте метод получения количества комнат в квартире.
     * @return
     */
    public int getRooms(){
        return rooms;
    }

    /***
     * Метод изменения количества комнат в квартире.
     * @param rooms
     */
    public void setRooms(int rooms){
        this.rooms = rooms;
    }

    /***
     * Создайте метод получения количества комнат в квартире.
     */
    public int getSquare(){
        return square;
    }

    /***
     * Метод изменения количества комнат в квартире.
     * @param square
     */
    public void setSquare(int square){
        this.square = square;
    }

    public String toString(){
        return String.format("Rooms: %d;\tSquare: %d;", rooms, square);
    }
}
