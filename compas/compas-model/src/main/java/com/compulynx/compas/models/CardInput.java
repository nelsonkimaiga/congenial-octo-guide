package com.compulynx.compas.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: SJ
 * Date: 3/2/14
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class CardInput {
    public String card_number;
    public String household_name;
    public String card_serial_number;
    public String pin_number;
    public String household_uuid;
    public int[] interventions;
    public Recipient recipient;
    public List<Alternates> alternates = new ArrayList<Alternates>();

    public List<Alternates> getAlternates() {
        return alternates;
    }

    public void setAlternates(List<Alternates> alternates) {
        this.alternates = alternates;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getHousehold_name() {
        return household_name;
    }

    public void setHousehold_name(String household_name) {
        this.household_name = household_name;
    }

    public String getCard_serial_number() {
        return card_serial_number;
    }

    public void setCard_serial_number(String card_serial_number) {
        this.card_serial_number = card_serial_number;
    }

    public String getPin_number() {
        return pin_number;
    }

    public void setPin_number(String pin_number) {
        this.pin_number = pin_number;
    }

    public String getHousehold_uuid() {
        return household_uuid;
    }

    public void setHousehold_uuid(String household_uuid) {
        this.household_uuid = household_uuid;
    }

    public int[] getInterventions() {
        return interventions;
    }

    public void setInterventions(int[] interventions) {
        this.interventions = interventions;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
}
