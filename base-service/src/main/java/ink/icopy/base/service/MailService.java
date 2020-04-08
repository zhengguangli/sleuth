package ink.icopy.base.service;

/**
 * @author lizhengguang
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);
}
