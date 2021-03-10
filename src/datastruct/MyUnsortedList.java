package datastruct;

import java.util.Arrays;

public class MyUnsortedList<E> implements UnsortedList<E> {

    private static class Link<E> {
        final E element;
        Link<E> next;
        Link<E> previous;
        private Link(E element) {
            this.element = element;
        }
    }

    private Link<E> head;
    //
    private Link<E> end;
    //
    private int size;

    private MyUnsortedList() {
        this.head = null;
        //
        this.end = null;
        //
        this.size = 0;
    }

    @SafeVarargs
    public static <E> MyUnsortedList<E> of(E... elements) {
        return of(Arrays.asList(elements));
    }

    public static <E> MyUnsortedList<E> of(Iterable<E> elements) {
        MyUnsortedList<E> list = new MyUnsortedList<>();
        for (E element : elements) {
            list.append(element);
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void prepend(E element) {
        size++;
        Link<E> newHead = new Link<>(element);
        newHead.next = head;
        //
        newHead.previous = null;
        if(size != 1) {
        	head.previous = newHead;
        }
        //
        head = newHead;
        
       
    }

    @Override
    public void append(E element) {
        //insert(element, size);	
    	if(size == 0) {
    		prepend(element);
    		this.end = this.head;
    		return;
    	}

    	size++;
    	Link<E> newEnd = new Link<>(element);
    	newEnd.next = null;
    	//
    	newEnd.previous = end;
    	//
    	end.next = newEnd;
    	end = newEnd;
    }

    @Override
    public void insert(E elem, int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            prepend(elem);
            return;
        }
        
        if(pos == size) {
        	//ajout à la fin
        	append(elem);
        	return;
        }

        Link<E> prevLink = head;
        while (pos-- > 1) {
            prevLink = prevLink.next;
        }

        size++;
        Link<E> inserted = new Link<>(elem);
        Link<E> nextLink = prevLink.next;
        //
        inserted.previous = prevLink;
        //
        prevLink.next = inserted;
        inserted.next = nextLink;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        size--;
        Link<E> oldHead = head;
        head = oldHead.next;
        //
        if(head != null) {
        	head.previous = null;
        }
        //

        return oldHead.element;
    }

    @Override
    public E popLast() {
    	/**
    	 * bug found with test test_popLast_list_empty()
    	 * no exception throw
    	 * */
    	if (isEmpty()) {
            throw new EmptyListException();
        }
    	
    	if(size -1 == 0) {
    		return pop();
    	}
    	
    	size--;
        
        Link<E> removed = end;
        end = removed.previous;
        end.next = null;
        
        return removed.element;
    }

    @Override
    public E remove(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            return pop();
        }
        if(pos == size-1) {
        	return popLast();
        }
        Link<E> prevLink = head;
        while (--pos > 0) {
            prevLink = prevLink.next;
        }
        /**
         * Bug found with test_remove_list_out_of_bound() and test_poplast_list_elementRemoved()
         * */
        size--;
        
        Link<E> removed = prevLink.next;
        prevLink.next = removed.next;
        
        return removed.element;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MyUnsortedList)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        MyUnsortedList<E> that = (MyUnsortedList<E>) obj;
        if (this.size != that.size) {
            return false;
        }

        Link<E> thisLink = this.head;
        Link<E> thatLink = that.head;
        while (thisLink != null) {
            if (thatLink == null || !thisLink.element.equals(thatLink.element)) {
                return false;
            }
            thisLink = thisLink.next;
            thatLink = thatLink.next;
        }

        return thatLink == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MyUnsortedList { size = ");
        builder.append(size);
        builder.append(", [");

        MyUnsortedList.Link<E> link = head;
        while (link != null) {
            builder.append(link.element);
            link = link.next;
            if (link != null) {
                builder.append(", ");
            }
        }

        return builder.append("] }").toString();
    }
}