package com.todo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.todo.page.TodoPage;
import com.todo.utils.Setup;

public class TodoTest extends Setup {

	TodoPage todoPage;

	public TodoTest() throws Exception {
		super();
	}

	@Test
	public void testAddTodo() {
		todoPage = new TodoPage();
		String newTodo = prop.getProperty("todo1");
		todoPage.addTodo(newTodo);
		Assert.assertTrue(todoPage.isTodoAdded(newTodo), "Todo item was not added!");
	}

}
