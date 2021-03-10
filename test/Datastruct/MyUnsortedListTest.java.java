package datastruct;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyUnsortedListTest {
	/**
	 * Is empty tests
	 * */
	@Test
	void test_is_empty_list_false() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		assertEquals("not empty list ", false, integers.isEmpty());
	}
	
	@Test
	void test_is_empty_list_true() {
		UnsortedList<Integer> integers = MyUnsortedList.of();
		assertEquals("empty list ", true, integers.isEmpty());
	}
	/**
	 * Size tests
	 * */
	@Test
	void test_size_list_not_empty() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		assertEquals("test size list  ", 4, integers.size());
	}
	
	@Test
	void test_size_list_empty() {
		UnsortedList<Integer> integers = MyUnsortedList.of();
		assertEquals("size empty list ", 0, integers.size());
	}
	/**
	 * Prepend tests
	 * */
	@Test
	void test_prepend_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.prepend(0);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(0,1,2,3,4);
		assertEquals("prepend number in list ", integers2, integers);
	}
	
	@Test
	void test_prepend_list_existing_number() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.prepend(1);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,1,2,3,4);
		assertEquals("prepend existing number in list ", integers2, integers);
	}
	/**
	 * Append tests
	 * */
	@Test
	void test_append_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.append(0);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3,4,0);
		assertEquals("append number to list ", integers2, integers);
	}
	
	@Test
	void test_append_list_existing_number() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.append(1);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3,4,1);
		assertEquals("prepend existing number to list ", integers2, integers);
	}
	/**
	 * Insert tests
	 * */
	@Test
	void test_insert_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.insert(0, 2);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,0,3,4);
		assertEquals("insert number in list ", integers2, integers);
	}
	
	@Test
	void test_insert_list_begining() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.insert(1,0);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,1,2,3,4);
		assertEquals("insert number to the begining of the list ", integers2, integers);
	}
	@Test
	void test_insert_list_end() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.insert(1,4);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3,4,1);
		assertEquals("insert number to the end of the list ", integers2, integers);
	}
	@Test
	void test_insert_list_outOfBounds() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			integers.insert(1,5);
		  });
	}
	/**
	 * Pop tests
	 * */
	
	@Test
	void test_pop_list_numberReturn() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		int a = integers.pop();
		assertEquals("pop right number ", 1, a);
	}
	
	@Test
	void test_pop_list_elementRemoved() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.pop();
		UnsortedList<Integer> integers2 = MyUnsortedList.of(2,3,4);
		assertEquals("pop number removed from list ", integers2, integers);
	}
	
	@Test
	void test_pop_list_empty() {
		UnsortedList<Integer> integers = MyUnsortedList.of();
		assertThrows(EmptyListException.class, () -> {
			integers.pop();
		  });
	}
	
	/**
	 * PopLast tests
	 * */
	
	@Test
	void test_poplast_list_numberReturn() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		int a = integers.popLast();
		assertEquals("poplast element correspond ", 4, a);
	}
	
	@Test
	void test_poplast_list_singlenumber_numberReturn() {
		UnsortedList<Integer> integers = MyUnsortedList.of(4);
		int a = integers.popLast();
		assertEquals("poplast element correspond ", 4, a);
	}
	
	@Test
	void test_poplast_list_elementRemoved() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.popLast();
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3);
		assertEquals("poplast element removed from list ", integers2, integers);
	}
	
	@Test
	void test_popLast_list_empty() {
		UnsortedList<Integer> integers = MyUnsortedList.of();
		assertThrows(EmptyListException.class, () -> {
			integers.popLast();
		  });
	}
	
	/**
	 * Remove tests
	 * */
	
	@Test
	void test_remove_list_first_numberReturn() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		int a = integers.remove(0);
		assertEquals("remove first element correspond ", 1, a);
	}
	
	@Test
	void test_remove_list_last_numberReturn() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		int a = integers.remove(3);
		assertEquals("remove last element correspond ", 4, a);
	}
	
	@Test
	void test_remove_list_numberReturn() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		int a = integers.remove(2);
		assertEquals("remove last element correspond ", 3, a);
	}
	
	@Test
	void test_remove_list_first_elementRemoved() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.remove(0);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(2,3,4);
		assertEquals("remove first element not in list anymore ", integers2, integers);
	}
	
	@Test
	void test_remove_list_last_elementRemoved() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		integers.remove(3);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3);
		assertEquals("remove element not in list anymore ", integers2, integers);
	}
	
	@Test
	void test_remove_list_out_of_bound() {
		UnsortedList<Integer> integers = MyUnsortedList.of();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			integers.remove(5);
		  });
	}
	
	/**
	 * After using eclemma
	 * */
	/**
	 * Equals tests
	 * */
	
	@Test
	void test_equals_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,3,4);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3, 4);
		assertEquals("test equals on same list ", true,integers.equals(integers2));
	}
	
	@Test
	void test_equals_different_size_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,4);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3, 4);
		assertEquals("test equals on different size list ", false,integers.equals(integers2));
	}
	
	@Test
	void test_equals_different_content_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,5,4);
		UnsortedList<Integer> integers2 = MyUnsortedList.of(1,2,3, 4);
		assertEquals("test equals on list with different content ", false,integers.equals(integers2));
	}
	
	@Test
	void test_equals_different_type_of_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,5,4);
		UnsortedList<String> integers2 = MyUnsortedList.of("1");
		assertEquals("test equals on list with different type ", false,integers.equals(integers2));
	}
	
	@Test
	void test_equals_different_type_of_object() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2,5,4);
		assertEquals("test equals on list with different object type ", false,integers.equals(1));
	}
	
	/**
	 * ToString tests
	 * */
	

	@Test
	void test_tostring_list() {
		UnsortedList<Integer> integers = MyUnsortedList.of(1,2);
		assertEquals("test tostring list ", "MyUnsortedList { size = 2, [1, 2] }",integers.toString());
	}
	
	
}