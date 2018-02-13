import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayBasedStack<T> implements StackInterface<T>
{
    private T[] data;
    private int topOfStack;
    private boolean initialized = false;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack()
    {
        this(INITIAL_CAPACITY);
    }

    public ArrayBasedStack(int initialCapacity)
    {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        data = tempStack;
        topOfStack = -1;
        initialized = true;
    }

    public void push(T newEntry)
    {
        checkInitialization();
        data[topOfStack + 1] = newEntry;
        topOfStack++;
    }

    public T peek()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return data[topOfStack];
    }

    public T pop()
    {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            T top = data[topOfStack];
            data[topOfStack] = null;
            topOfStack--;
            return top;
        }
    }

    public boolean isEmpty()
    {
        return topOfStack < 0;
    }

    public void clear()
    {
        checkInitialization();


        while (topOfStack > -1)
        {
            data[topOfStack] = null;
            topOfStack--;
        }
    }

    private void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException ("ArrayStack object is not initialized properly.");
    }


}