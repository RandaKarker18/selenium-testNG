package com.todo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.todo.utils.BasePage;

public class TodoPage {

	WebDriver driver;

	public TodoPage() {
		this.driver = BasePage.getDriver();
	}

	private By todoInput = By.className("new-todo");
	private By todoList = By.cssSelector(".todo-list li");

	public void addTodo(String todoText) {
		driver.findElement(todoInput).sendKeys(todoText + "\n"); // \n simule Enter
	}

	public boolean isTodoAdded(String todoText) {
		return driver.findElements(todoList).stream().anyMatch(e -> e.getText().equals(todoText));
	}

}
