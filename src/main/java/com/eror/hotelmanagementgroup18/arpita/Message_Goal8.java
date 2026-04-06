package com.eror.hotelmanagementgroup18.arpita;

import java.io.Serializable;

public class Message_Goal8 implements Serializable {

    private String sender;
    private String receiver;
    private String subject;
    private String message;
    private boolean priority;
    private boolean option;

    public Message_Goal8(String sender, String receiver, String subject,
                         String message, boolean priority, boolean option) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.message = message;
        this.priority = priority;
        this.option = option;
    }

    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public String getSubject() { return subject; }
    public String getMessage() { return message; }
    public boolean isPriority() { return priority; }
    public boolean isOption() { return option; }
}