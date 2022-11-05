package buildings;

import java.util.ArrayList;
import java.util.HashMap;

public class Dwelling {

    private ArrayList<DwellingFloor> floors = new ArrayList<DwellingFloor>();

    /***
     * Конструктор может принимать количество этажей и массив количества квартир по этажам.
     * @param amountOfFloors
     * @param arrAmountFlatsOnFloors
     */
    public Dwelling(int amountOfFloors, int[] arrAmountFlatsOnFloors){

        for (int i = 0; i < amountOfFloors; i++) {
            DwellingFloor currentFloor = new DwellingFloor(arrAmountFlatsOnFloors[i]);
            floors.add(currentFloor);
        }
    }

    /***
     * Конструктор может принимать массив этажей дома.
     * @param floors
     */
    public Dwelling (ArrayList<DwellingFloor> floors){
        this.floors = floors;
    }

    /***
     * метод получения общего количества этажей дома.
     * @return
     */
    public int getAmountFloorsInDwelling(){
        return floors.size();
    }

    /***
     * метод получения общего количества квартир дома.
     * @return
     */
    public int getAmountFlatsInDwelling(){
        int AmountFlatsInDwelling = 0;
        for (int i = 0; i < getAmountFloorsInDwelling(); i++) {
            AmountFlatsInDwelling += floors.get(i).getAmountFlatsOnFloor();
        }
        return AmountFlatsInDwelling;
    }

    /***
     * метод получения общей площади квартир дома.
     * @return
     */
    public int getCommonSquareFlatsInDwelling(){
        int CommonSquareFlatsInDwelling = 0;
        for (int i = 0; i < getAmountFloorsInDwelling(); i++) {
            CommonSquareFlatsInDwelling += floors.get(i).getSquareFlatsOnFloor();
        }
        return CommonSquareFlatsInDwelling;
    }

    /***
     * метод получения общего количества комнат дома.
     * @return
     */
    public int getAmountRoomsInDwelling(){
        int AmountRoomsInDwelling = 0;
        for (int i = 0; i < getAmountFloorsInDwelling(); i++) {
            AmountRoomsInDwelling += floors.get(i).getRoomsFlatsOnFloor();
        }
        return AmountRoomsInDwelling;
    }

    /***
     * метод получения массива этажей жилого дома.
     * @return
     */
    public ArrayList<DwellingFloor> getFloors(){
        return floors;
    }

    /***
     * метод получения объекта этажа, по его номеру в доме.
     * @param number
     * @return
     */
    public DwellingFloor getFloor(int number){
        return floors.get(number);
    }

    /***
     * метод изменения этажа по его номеру в доме и ссылке на обновленный этаж.
     * @param number
     * @param obj
     */
    public void ChangeFloorInDwelling(int number, DwellingFloor obj){
        floors.set(number, obj);
    }

    /***
     * метод получения объекта квартиры по ее номеру в доме.
     * @param number
     * @return
     */
    public Flat getFlatInDwelling(int number){
        HashMap<String, Integer> address = new HashMap<>();
        address = getNumberFloorAndFlat(number);
        return floors.get(address.get("FloorNumber")).getArrayFlatsOnFloor().get(address.get("FlatOnFloorNumber"));
    }

    /***
     * метод изменения объекта квартиры по ее номеру в доме и ссылке на объект квартиры.
     * @param number
     * @param obj
     */
    public void changeFlatInDwelling(int number, Flat obj){
        HashMap<String, Integer> address = new HashMap<>();
        address = getNumberFloorAndFlat(number);
        floors.get(address.get("FloorNumber")).getArrayFlatsOnFloor().set(address.get("FlatOnFloorNumber"), obj);
    }

    /***
     * метод удаления квартиры по ее номеру в доме.
     * @param number
     */
    public void deleteFlatInDwelling(int number){
        HashMap<String, Integer> address = new HashMap<>();
        address = getNumberFloorAndFlat(number);
        floors.get(address.get("FloorNumber")).getArrayFlatsOnFloor().remove(address.get("FlatOnFloorNumber"));
    }

    /***
     * метод получения самой большой по площади квартиры дома.
     * @return
     */
    public Flat getBestSpase(){
        int BestSpase = 0;
        int bestSpaseInCurrentFloor = 0;
        Flat currentBestFlat = null;
        Flat currentFlat = null;
        for (int i = 0; i < getAmountFloorsInDwelling(); i++) {
            currentFlat = floors.get(i).getBestSpase();
            bestSpaseInCurrentFloor = currentBestFlat.getSquare();
            if (bestSpaseInCurrentFloor > BestSpase) {
                BestSpase = bestSpaseInCurrentFloor;
                currentBestFlat = currentFlat;
            }
        }
        return currentBestFlat;
    }

    /**
     * метод получения отсортированного по убыванию площадей массива квартир.
     * @return
     */
    public Flat[] getSortFlatsArray(){
        Flat[] arrayOfFlats = new Flat[getAmountFlatsInDwelling()];
        arrayOfFlats = getArrayFlatInDwelling();
        int swap = -1;
        while (swap != 0)
        {
            swap = 0;
            for (int i = 0; i < arrayOfFlats.length-1; i++)
            {
                if (arrayOfFlats[i].getSquare() < arrayOfFlats[i+1].getSquare())
                {
                    Flat currentFlat = arrayOfFlats[i];
                    arrayOfFlats[i] = arrayOfFlats[i+1];
                    arrayOfFlats[i+1] = currentFlat;
                    swap++;
                }
            }
        }
        return arrayOfFlats;
    }

    /***
     * метод получения всех квартир дома
     * @return
     */
    public Flat[] getArrayFlatInDwelling(){
        Flat[] arrayFlatInDwelling = new Flat[getAmountFlatsInDwelling()];
        DwellingFloor currentFloor = null;
        Flat currentFlat = null;
        int count = 0;
        for (int i = 0; i < getAmountFloorsInDwelling(); i++) {
            currentFloor = floors.get(i);
            for (int j = 0; j < currentFloor.getAmountFlatsOnFloor(); j++) {
                currentFlat = currentFloor.getFlatOnFloor(j);
                arrayFlatInDwelling[count] = currentFlat;
            }
        }
        return arrayFlatInDwelling;
    }

    /***
     * Доп. метод возвращает номер этажа и номер квартиры на этаже по номеру крартиры в доме
     * @param number - номер квартиры в доме
     * @return - хеш-таблица("FloorNumber","FlatOnFloorNumber")
     */
    public HashMap<String, Integer> getNumberFloorAndFlat(int number)
    {
        HashMap<String, Integer> response = new HashMap<>();
        int currentNumber = 0;
        int amountFlatsOnCurrentFloor = 0;
        int numberFlatOnFloor = 0;
        for (int i = 0; i < getAmountFloorsInDwelling(); i++)
        {
            DwellingFloor currentFloor = floors.get(i);
            amountFlatsOnCurrentFloor = currentFloor.getAmountFlatsOnFloor();
            currentNumber += amountFlatsOnCurrentFloor;
            if (number <= currentNumber)
            {
                numberFlatOnFloor = amountFlatsOnCurrentFloor - (currentNumber - number);
                response.put("FloorNumber", i);
                response.put("FlatOnFloorNumber", numberFlatOnFloor);
                break;
            }
        }
        return response;
    }

}
