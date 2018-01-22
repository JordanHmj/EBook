package EBook.Util;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import EBook.Model.Host;

public class MailService {
	public static String myEmailAccount = "shaunebook@163.com";
    public static String myEmailPassword = "hmjzhtx01";
    
    public static String myEmailSMTPHost = "smtp.163.com";
    
    public static void sendMail(String userMail,String userName)
    {
    	Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        
        Session session = Session.getInstance(props);
        //session.setDebug(true);  // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

        try
        {
        	MimeMessage message = createMimeMessage(session, myEmailAccount, userMail,userName);
            // 4. ���� Session ��ȡ�ʼ��������
            Transport transport = session.getTransport();
            transport.connect(myEmailAccount, myEmailPassword);
            // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
            transport.sendMessage(message, message.getAllRecipients());
            // 7. �ر�����
            transport.close();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
    
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String userName) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

        // 2. From: �����ˣ��ǳ��й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸��ǳƣ�
        message.setFrom(new InternetAddress(sendMail, "Ф������Сվ", "UTF-8"));

        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, userName, "UTF-8"));

        // 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
        message.setSubject("Ф������Сվ�˺ż���", "UTF-8");

        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
        message.setContent("���ã�<a href='http://localhost:8080/EBook/HostActivation?sign="+ShaunUtils.StringToHex(receiveMail)+"'>�����˴������˺�</a>", "text/html;charset=UTF-8");

        // 6. ���÷���ʱ��
        message.setSentDate(new Date());

        // 7. ��������
        message.saveChanges();

        return message;
    }
}
