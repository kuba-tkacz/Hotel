package model;

public class Room {

    private int number;
    private int size;
    private boolean bathroom;
    private boolean available = true;

    private static int nextNumber = 1;

    public Room(int size, boolean bathroom) {
        number = nextNumber;
        this.size = size;
        this.bathroom = bathroom;
        nextNumber++;
    }

    @Override
    public String toString() {
        String bathroomMessage = bathroom ? "z łazienką" : "bez łazienki";
        String availableMessage = available ? "dostępny" : "niedostępny :(";
        return String.format("Pokój nr: %d, mieści %d osób, %s, %s",number, size,bathroomMessage,availableMessage );
    }

    public boolean isAvailable() {
        return available;
    }

    public int getNumber() {
        return number;
    }

    public void reserve() {
        available = false;
    }

    public void release() { available = true; }
}

