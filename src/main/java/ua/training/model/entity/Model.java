package ua.training.model.entity;

import ua.training.model.exception.NotUniqueLoginException;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static int count = 3;

    private static List<Contact> contacts = new ArrayList<>();
    static {
        contacts.add(new Contact(1, "Alex", "Lytvyn", "alexander01"));
        contacts.add(new Contact(2, "John", "Johnson", "john12345"));
    }

    public void addContact(Contact contact) {
        contact.setId(count++);
        contacts.add(contact);
    }

    public void checkLogin(Contact contact) throws NotUniqueLoginException {
        for (Contact c : contacts) {
            if (contact.getLogin().equals(c.getLogin())) {
                throw new NotUniqueLoginException("Such login already exists. " +
                        "Please enter a different login.");
            }
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void printContacts() {
        getContacts().forEach(System.out::println);
    }
}
