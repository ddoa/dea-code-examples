package nl.ica.ddoa.generics;

/**
 * Description for the class ObjectHolder:
 * <p/>
 * Example usage:
 * <p/>
 * <pre>
 *
 * </pre>
 *
 * @author mdkr
 * @version Copyright (c) 2012 HAN University, All rights reserved.
 */
public class ObjectHolder<T> {
    private T toHold;

    public ObjectHolder(T toHold)
    {
        this.toHold = toHold;
    }

    public T getValue()
    {
        return toHold;
    }
}
