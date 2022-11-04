package buildings;

import java.util.ArrayList;

public class DwellingFloor {

    private ArrayList<Flat> flats = new ArrayList<Flat>();

    /***
     * Конструктор может принимать количество квартир на этаже.
     * @param numberOfFlatOnFloor
     */
    public DwellingFloor(int numberOfFlatOnFloor){
        for (int i = 0; i < numberOfFlatOnFloor; i++) {
            flats.add(new Flat());
        }
    }

    /***
     * Конструктор может принимать массив квартир этажа.
     * @param flats
     */
    public DwellingFloor(ArrayList<Flat> flats){
        this.flats = flats;
    }

    /***
     * Метод получения количества квартир на этаже.
     * @return
     */
    public int getAmountFlatsOnFloor(){
        return flats.size();
    }

    /***
     * Метод получения общей площади квартир этажа.
     * @return
     */
    public int getSquareFlatsOnFloor(){
        int sumSquare = 0;
        for (int i = 0; i < getAmountFlatsOnFloor(); i++) {
            sumSquare += flats.get(i).getSquare();
        }
        return sumSquare;
    }

    /***
     * Метод получения общего количества комнат этажа.
     * @return
     */
    public int getRoomsFlatsOnFloor(){
        int sumRooms = 0;
        for (int i = 0; i < getAmountFlatsOnFloor(); i++) {
            sumRooms += flats.get(i).getRooms();
        }
        return sumRooms;
    }

    /***
     * метод получения массива квартир этажа.
     * @return
     */
    public ArrayList<Flat> getArrayFlatsOnFloor(){
        return flats;
    }

    /***
     * метод получения объекта квартиры по ее номеру на этаже.
     * @param number
     * @return
     */
    public Flat getFlatOnFloor(int number){
        return flats.get(number);
    }

    /***
     * метод изменения квартиры по ее номеру на этаже и ссылке на новую квартиру.
     * @param number
     * @param obj
     */
    public void changeFlatOnFlor(int number, Flat obj){
        flats.set(number, obj);
    }

    /***
     * метод добавления новой квартиры на этаже по будущему номеру квартиры и ссылке на объект квартиры.
     * @param number
     * @param obj
     */
    public void addFlatOnFloor(int number, Flat obj){
        flats.add(number, obj);
    }

    /***
     * метод удаления квартиры по ее номеру на этаже.
     * @param number
     */
    public void removeFlatOnFloor(int number){
        flats.remove(number);
    }

    /***
     * метод получения самой большой по площади квартиры этажа.
     * @return
     */
    public Flat getBestSpase(){
        int BestSpace = 0;
        Flat FlatWithBestSpase = null;

        for (int i = 0; i < getAmountFlatsOnFloor(); i++) {
            Flat currentFlat = flats.get(i);
            int currentSquareOnFlat = currentFlat.getSquare();
            if (currentSquareOnFlat > BestSpace) {
                BestSpace = currentSquareOnFlat;
                FlatWithBestSpase = currentFlat;
            }
        }
        return FlatWithBestSpase;
    }
}
