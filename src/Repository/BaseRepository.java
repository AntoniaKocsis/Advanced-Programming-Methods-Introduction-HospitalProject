package Repository;

import Domain.ExaminationRoom;

import java.util.ArrayList;
import java.util.Date;


public abstract class BaseRepository<T> {

    public abstract void add(T item);

    public abstract boolean remove(T item);

    public abstract ArrayList<T> getAll();
}
