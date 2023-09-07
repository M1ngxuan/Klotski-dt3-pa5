/**
 * This class represents a data structure to hold information related to sending emails.
 * It includes properties such as server details, sender and receiver addresses, authentication,
 * email subject, content, and attachments.
 */
package com.example.newklotski;

import java.util.Properties;

public class MailInfo {

    private String mailServerHost;  // The email server's IP address
    private String mailServerPort;  // The email server's port
    private String fromAddress;     // Sender's email address
    private String toAddress;       // Receiver's email address
    private String userName;        // User's email username
    private String password;        // User's email password
    private boolean validate = true; // Flag indicating if authentication is required
    private String subject;         // Email subject
    private String content;         // Email content
    private String[] attachFileNames; // Array of file names for attachments

  /**
     * Get the email session properties.
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        return p;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] fileNames) {
        this.attachFileNames = fileNames;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String textContent) {
        this.content = textContent;
    }
}
