package com.lf.minhalivraria.model.buscape;

public class Contacts {
    private Contact contact;

    public Contacts() {
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contact=" + contact +
                '}';
    }
}
