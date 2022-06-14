package com.hibernate;

import com.hibernate.model.Item;
import com.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App_ManyToOne_OneToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            Item item = session.get(Item.class, 1);
//
//            // Список товаров у персоны
//            List<Item> itemList = person.getItems();
//
//            // Получить персонажа через item
//            Person owner = item.getOwner();
//
//            System.out.println(itemList);
//            System.out.println(owner);

            // Добавить товары
//            Person person = session.get(Person.class, 2);
//            Item addingItem = new Item("Samsung A20", person);
//
//            session.save(addingItem);
//
////            Person person1 = session.get(Person.class,2);
////            System.out.println(person1.getItems());

//            // Создание нового покупателя и нового товара
//            Person newPerson = new Person("Victor", 33);
//            Item newItem = new Item("XBox One S", newPerson);
//
//            newPerson.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.save(newPerson);
//            session.save(newItem);
            // Удалить товар у пользователя

            Person personToDeleteItems = session.get(Person.class, 3);
            List<Item> itemList = personToDeleteItems.getItems();

            itemList.forEach(item -> {
                session.remove(item);
            });

            personToDeleteItems.getItems().clear();
            System.out.println(personToDeleteItems.getItems());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }

    }
}
