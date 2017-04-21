/**
 *
 */
package cn.letcode.email.bean;

/**
 * 发送邮件需要使用的基本信息
 */

import java.io.File;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class Email {
    /**
     * 发送邮件的服务器的IP和端口
     */
    private String mailServerHost = "";
    private String mailServerPort = "25";
    /**
     * 邮件发送者的地址
     */
    private String fromAddress;
    private String fromUserName;
    /**
     * 邮件接收者的地址
     */
    private String toAddress;
    /**
     * 登陆邮件发送服务器的用户名和密码 (使用base64编码)
     */
    private String userName;
    private String password;
    /**
     * 是否需要身份验证
     */
    private boolean validate = false;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件的文本内容
     */
    private String content;
    /**
     * 发送超时时间
     */
    private int mailTimeOut;
    /**
     * 连接服务器超时
     */
    private int mailConnTimeOut;
    /**
     * 邮件附件的文件服务器路径
     */
    private File[] attachFiles;
    /**
     * 邮件重试次数
     */
    private Integer retry;
    private boolean debug;

    /**
     * 获得邮件会话属性
     *
     * @return Properties
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.timeout", this.mailTimeOut);
        p.put("mail.smtp.connectiontimeout", this.mailConnTimeOut);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        p.put("mail.debug", debug ? "true" : "false");
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

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getPassword() {
        return new String(Base64.decodeBase64(this.password.getBytes()));
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

    public int getMailTimeOut() {
        return mailTimeOut;
    }

    public void setMailTimeOut(int mailTimeOut) {
        this.mailTimeOut = mailTimeOut;
    }

    public int getMailConnTimeOut() {
        return mailConnTimeOut;
    }

    public void setMailConnTimeOut(int mailConnTimeOut) {
        this.mailConnTimeOut = mailConnTimeOut;
    }

    public File[] getAttachFiles() {
        return attachFiles;
    }

    public void setAttachFiles(File[] attachFiles) {
        this.attachFiles = attachFiles;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getFromUserName() {

        return StringUtils.isBlank(fromUserName) ? "" : fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
}