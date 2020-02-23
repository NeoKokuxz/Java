import java.util.*;

public interface MyList<Contact> extends Iterable<Contact>    {

    public boolean add(Contact e);

    public void add(int index, Contact element);

    public void clear();

    public boolean contains(Object obj);

    public boolean equals(Object obj);

    public Contact get(int index);

    public Contact set(int index, Contact element);

    public int indexOf(Object obj);

    public boolean isEmpty();

    public Iterator<Contact> iterator();

    public int lastIndexOf(Object obj);

    public Contact remove(int index);

    public boolean remove(Object obj);

    public int size();

}