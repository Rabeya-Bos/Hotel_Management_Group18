package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class Message_Goal8 implements Serializable {

    private String sender;
    private String receiver;
    private String subject;
    private String message;
    private boolean priority;
    private boolean option;

    public Message_Goal8(String sender, String receiver, String subject, String message, boolean priority, boolean option) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.message = message;
        this.priority = priority;
        this.option = option;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public boolean isOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Message_Goal8{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", priority=" + priority +
                ", option=" + option +
                '}';
    }
}
